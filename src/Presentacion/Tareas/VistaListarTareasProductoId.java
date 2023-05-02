/**
 * 
 */
package Presentacion.Tareas;

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

import Negocio.Tareas.TTarea;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

public class VistaListarTareasProductoId extends JFrame implements IGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JTable table;
	
	private TareasTableModel tareasmodel;
	
	public VistaListarTareasProductoId() {
		vListarTareasProductoId();
	}
	
	public void vListarTareasProductoId() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarTareas.class.getResource("/icons/tarea.png")));
		setTitle("Mostrar Tareas de un Producto por ID");
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
		case Eventos.VistaListarTareasProductoId:
			setVisible(true);
			break;
		case Eventos.ListarTareasProductoId:
			tareasmodel.setLista((Set<TTarea>) object);
			tareasmodel.fireTableStructureChanged();
			break;
		case Eventos.ListarTareasProductoIdNoOK:
			JOptionPane.showMessageDialog(null, "Error. El Producto no existe");
			Controlador.getInstance().update(Eventos.VistaFormListarTareasProductoId, null);
			break; 
		}
	}
}