package Presentacion.Factura;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Empleado.TEmpleado;
import Negocio.Factura.TLineaFactura;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

public class VistaMostrarCarrito extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	
	private LineaFacturaTableModel facturamodel;
	
	
	public VistaMostrarCarrito() {
		vMostrarEmpleadoID();
	}
	
	public void vMostrarEmpleadoID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaMostrarCarrito.class.getResource("/icons/factura.png")));
		setTitle("Mostrar Carrito");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		facturamodel = new LineaFacturaTableModel();
		table = new JTable(facturamodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
		
		setVisible(false);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarCarrito:
			setVisible(true);
			break;
		case Eventos.MostrarCarrito:
			facturamodel.setLista((Set<TLineaFactura>) object);
			facturamodel.fireTableStructureChanged();
			break;
		case Eventos.MostrarCarritoNoOk:
			JOptionPane.showMessageDialog(null, "Error. Carrito no está abierto");
			break;
		case Eventos.NecesitasCarrito:
			JOptionPane.showMessageDialog(null, "Necesitas un Carrito abierto para hacer esto.");
			break; 
		}
	}

}
