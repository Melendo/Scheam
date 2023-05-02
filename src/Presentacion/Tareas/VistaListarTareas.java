/**
 * 
 */
package Presentacion.Tareas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


import Negocio.Tareas.TTarea;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class VistaListarTareas extends JFrame implements IGUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private TareasTableModel tareasmodel;
		
	public VistaListarTareas() {
		vListarTarea();
	}

	public void vListarTarea() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarTareas.class.getResource("/icons/tarea.png")));
		setTitle("Listado Tareas");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowTarea, null);
				dispose();
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
		switch (event) {
		case Eventos.VistaListarTareas:
			setVisible(true);
			break;
		case Eventos.ListarTareas:
			tareasmodel.setLista((Set<TTarea>) object);
			tareasmodel.fireTableStructureChanged();
			break;
		}
	}
	
}