
package Presentacion.Tareas;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Empleado.TEmpleado;
import Negocio.Tareas.TTarea;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.EmpleadosTableModel;
import Presentacion.Empleado.VistaListarEmpleado;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;


public class VistaListarTareasEquipoId extends JFrame implements IGUI {

	private JPanel contentPane;	
	private JTable table;
	
	private TareasTableModel tareasmodel;
	
	public VistaListarTareasEquipoId() {
		vListarTareasEquipoId();
	}
	
	public void vListarTareasEquipoId() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarTareas.class.getResource("/icons/tarea.png")));
		setTitle("Mostrar Tareas de un Equipo por ID");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowTarea, null);
			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tareasmodel = new TareasTableModel();
		table = new JTable(tareasmodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaListarTareasEquipoId:
			setVisible(true);
			break;
		case Eventos.ListarTareasEquipoId:
			tareasmodel.setLista((Set<TTarea>) object);
			tareasmodel.fireTableStructureChanged();
			break;
		case Eventos.ListarTareasEquipoIdNoOK:
			JOptionPane.showMessageDialog(null, "Error. La Tarea no existe");
			Controlador.getInstance().update(Eventos.VistaFormListarTareasEquipoId, null);
			break; 
		}
	}
}