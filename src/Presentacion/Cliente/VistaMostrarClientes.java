package Presentacion.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Cliente.TCliente;
import Negocio.Producto.TProducto;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;
import Presentacion.Producto.ProductosTableModel;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaMostrarClientes extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	
	private ClientesTableModel clientesmodel;
	
	public VistaMostrarClientes() {
		vMostrarClientes();
	}
	
	public void vMostrarClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/cliente.png")));
		setTitle("Listado clientes");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowCliente, null);
				dispose();
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
	}

	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Eventos.VistaListarCliente:
			setVisible(true);
			break;
		case Eventos.ListarCliente:
			clientesmodel.setLista((Set<TCliente>) object);
			clientesmodel.fireTableStructureChanged();
			break;
		}
	}

}