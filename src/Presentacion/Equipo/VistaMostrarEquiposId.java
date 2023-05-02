
package Presentacion.Equipo;

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

import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;

import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;

public class VistaMostrarEquiposId extends JFrame implements IGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private EquipoDesarrolloTableModel equipoDesmodel;
	private EquipoDisenyoTableModel equipoDismodel;
	
	public VistaMostrarEquiposId() {
		vMostrarEquiposID();
	}

	
	public void vMostrarEquiposID() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/empleado.png")));
		setTitle("Mostrar Empleado por ID");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));		
		
		setVisible(false);	
	}
	
	public void initTableDes() {
		equipoDesmodel = new EquipoDesarrolloTableModel();
		table = new JTable(equipoDesmodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
	}
	
	public void initTableDis() {
		equipoDismodel = new EquipoDisenyoTableModel();
		table = new JTable(equipoDismodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarEquipoID:
			setVisible(true);
			break;
		case Eventos.MostrarEquipoID:
			if(object instanceof TEquipoDesarrollo) {
				initTableDes();
				Set<TEquipoDesarrollo> lista = new HashSet<TEquipoDesarrollo>();
				lista.add((TEquipoDesarrollo) object);
				equipoDesmodel.setLista(lista);
				equipoDesmodel.fireTableStructureChanged();

			}else {
				 initTableDis();
				 Set<TEquipoDisenio> lista = new HashSet<TEquipoDisenio>();
					lista.add((TEquipoDisenio) object);
					equipoDismodel.setLista(lista);
					equipoDismodel.fireTableStructureChanged();					
			}
			
			break;
		case Eventos.MostrarEquipoIDNoOK:
			JOptionPane.showMessageDialog(null, "Error. El empleado no existe");
			Controlador.getInstance().update(Eventos.VistaFormMostrarEquipoID, null);
			break;
		}
	}
}