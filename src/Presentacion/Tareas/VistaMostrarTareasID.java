/**
 * 
 */
package Presentacion.Tareas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Tareas.TTarea;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Tareas.TareasTableModel;
import Presentacion.Tareas.VistaListarTareas;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaMostrarTareasID extends JFrame implements IGUI{

	private JPanel contentPane;
	private JTable table;
	
	private TareasTableModel tareasmodel;
	
	
	public VistaMostrarTareasID() {
		vMostrarTareaID();
	}
	
	public void vMostrarTareaID() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarTareas.class.getResource("/icons/tareas.png")));
		setTitle("Mostrar Tarea por ID");
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
		
		setVisible(false);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarTareasID:
			setVisible(true);
			break;
		case Eventos.MostrarTareasID:
			Set<TTarea> lista = new HashSet<TTarea>();
			lista.add((TTarea) object);
			tareasmodel.setLista(lista);
			tareasmodel.fireTableStructureChanged();
			break;
		case Eventos.MostrarTareasIDNoOK:
			JOptionPane.showMessageDialog(null, "Error. La tarea no existe");
			Controlador.getInstance().update(Eventos.VistaFormMostrarTareasID, null);
			break;
		}
	}
}