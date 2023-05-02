
package Presentacion.Factura;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Factura.TFactura;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;

public class VistaMostrarFacturasIDCliente extends JFrame implements IGUI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private FacturaTableModel facturamodel;
	
	public VistaMostrarFacturasIDCliente() {
		vListarFacturasIDCliente();
	}

	public void vListarFacturasIDCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/factura.png")));
		setTitle("Mostrar Facturas por ID Cliente");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowFactura, null);
			}
		});
		setBounds(100, 100, 360, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		facturamodel = new FacturaTableModel();
		contentPane.setLayout(new BorderLayout(0, 0));
		table = new JTable(facturamodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp);
		
		setVisible(false);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarFacturasIDCliente:
			setVisible(true);
			break;
		case Eventos.MostrarFacturasIDCliente:
			@SuppressWarnings("unchecked") Set<TFactura> lista = (Set<TFactura>) object;
			facturamodel.setLista(lista);
			facturamodel.fireTableStructureChanged();
			break;
		case Eventos.MostrarFacturasIDClienteNoOk:
			JOptionPane.showMessageDialog(null, "Error. El cliente no existe");
			Controlador.getInstance().update(Eventos.VistaFormMostrarFacturasIDCliente, null);
			break;
		}
	}

}