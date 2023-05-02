package Presentacion.Producto;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Empleado.TEmpleado;
import Negocio.Producto.TProducto;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaMostrarProductoID extends JFrame implements IGUI, ActionListener {
	
	private JPanel contentPane;
	private JTable table;
	
	private ProductosTableModel productosmodel;
	
	public VistaMostrarProductoID() {
		vMostrarProductoID();
	}
	
	public void vMostrarProductoID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarProductos.class.getResource("/icons/producto.png")));
		setTitle("Mostrar Producto por ID");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowProducto, null);
			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		productosmodel = new ProductosTableModel();
		table = new JTable(productosmodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
		
		setVisible(false);
	}

	public void update() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void actionPerformed(ActionEvent e) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarProductoID:
			setVisible(true);
			break;
		case Eventos.MostrarProductoID:
			Set<TProducto> lista = new HashSet<>();
			lista.add((TProducto) object);
			productosmodel.setLista(lista);
			productosmodel.fireTableStructureChanged();
			break;
		case Eventos.MostrarProductoIDNoOK:
			JOptionPane.showMessageDialog(null, "Error. El producto no existe");
			Controlador.getInstance().update(Eventos.VistaFormMostrarProductoID, null);
			break;	
		}
	}
		
}