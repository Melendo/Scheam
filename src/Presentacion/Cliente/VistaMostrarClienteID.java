package Presentacion.Cliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Cliente.TCliente;
import Negocio.Producto.TProducto;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Producto.ProductosTableModel;
import Presentacion.Producto.VistaListarProductos;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaMostrarClienteID extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	
	private ClientesTableModel clientesmodel;
	
	public VistaMostrarClienteID() {
		vVistaMostrarClienteID();
	}	
	
	public void vVistaMostrarClienteID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaMostrarClientes.class.getResource("/icons/cliente.png")));
		setTitle("Mostrar Cliente por ID");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowCliente, null);
			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		clientesmodel = new ClientesTableModel();
		table = new JTable(clientesmodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
		
		setVisible(false);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarClienteID:
			setVisible(true);
			break;
		case Eventos.MostrarClienteID:
			Set<TCliente> lista = new HashSet<>();
			lista.add((TCliente) object);
			clientesmodel.setLista(lista);
			clientesmodel.fireTableStructureChanged();
			break;
		case Eventos.MostrarClienteIDOK:
			JOptionPane.showMessageDialog(null, "Error. El cliente no existe");
			Controlador.getInstance().update(Eventos.VistaFormMostrarClienteID, null);
			break;
		}		
	}
}