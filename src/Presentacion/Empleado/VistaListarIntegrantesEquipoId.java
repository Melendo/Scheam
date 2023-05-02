
package Presentacion.Empleado;

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

import Negocio.Empleado.TEmpleado;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

public class VistaListarIntegrantesEquipoId extends JFrame implements IGUI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JTable table;
	
	private EmpleadosTableModel empleadosmodel;
	
	public VistaListarIntegrantesEquipoId() {
		vListarIntegrantesEquipoId();
	}
	
	public void vListarIntegrantesEquipoId() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/empleado.png")));
		setTitle("Mostrar Integrantes de un Equipo por ID");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowEmpleado, null);
			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		empleadosmodel = new EmpleadosTableModel();
		table = new JTable(empleadosmodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaListarIntegrantesEquipo:
			setVisible(true);
			break;
		case Eventos.ListarIntegrantesEquipo:
			empleadosmodel.setLista((Set<TEmpleado>) object);
			empleadosmodel.fireTableStructureChanged();
			break;
		case Eventos.ListarIntegrantesEquipoNoOk:
			JOptionPane.showMessageDialog(null, "Error. El equipo no existe");
			Controlador.getInstance().update(Eventos.VistaFormListarIntegrantesEquipoId, null);
			break; 
		}
	}
}