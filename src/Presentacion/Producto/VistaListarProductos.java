/**
 * 
 */
package Presentacion.Producto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Producto.TProducto;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaListarProductos extends JFrame implements IGUI, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private ProductosTableModel productosmodel;
	
	public VistaListarProductos() {		
		vListarProductos();
	}

	
	public void vListarProductos() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/producto.png")));
		setTitle("Listado Productos");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowProducto, null);
				dispose();
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
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Eventos.VistaListarProducto:
			setVisible(true);
			break;
		case Eventos.ListarProducto:
			productosmodel.setLista((Set<TProducto>) object);
			productosmodel.fireTableStructureChanged();
			break;
		}
	}
}