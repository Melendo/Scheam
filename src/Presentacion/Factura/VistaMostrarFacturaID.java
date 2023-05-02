
package Presentacion.Factura;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.EmpleadosTableModel;
import Presentacion.Empleado.VistaListarEmpleado;
import Negocio.Factura.TFactura;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.HashSet;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;

public class VistaMostrarFacturaID extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	
	private FacturaTableModel facturamodel;
	private LineaFacturaTableModel lineasmodel;
	
	public VistaMostrarFacturaID() {
		setMinimumSize(new Dimension(700, 300));
		vMostrarFacturaID();
	}

	public void vMostrarFacturaID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/factura.png")));
		setTitle("Mostrar Factura por ID");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowFactura, null);
			}
		});
		setBounds(100, 100, 700, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		facturamodel = new FacturaTableModel();
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		table = new JTable(facturamodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp);
		
		lineasmodel = new LineaFacturaTableModel();
		table2 = new JTable(lineasmodel);
		JScrollPane table2sp = new JScrollPane(table2);
		contentPane.add(table2sp);
		
		setVisible(false);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarFacturaID:
			setVisible(true);
			break;
		case Eventos.MostrarFacturaID:
			TFactura factura = (TFactura) object;
			Set<TFactura> lista = new HashSet<TFactura>();
			lista.add(factura);
			facturamodel.setLista(lista);
			facturamodel.fireTableStructureChanged();
			lineasmodel.setLista(factura.getLineas());
			lineasmodel.fireTableStructureChanged();
		case Eventos.MostrarFacturaIDNoOK:
			JOptionPane.showMessageDialog(null, "Error. La factura no existe");
			Controlador.getInstance().update(Eventos.VistaFormMostrarFacturaID, null);
			break;
		}
	}
}