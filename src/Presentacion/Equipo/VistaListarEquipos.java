
package Presentacion.Equipo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;
import Negocio.Equipo.TEquipo;

import Presentacion.IGUI;
import Presentacion.Cliente.DistribuidorTableModel;
import Presentacion.Cliente.ParticularTableModel;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;

public class VistaListarEquipos extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table1;
	private JTable table2;
	
	private EquipoDesarrolloTableModel desmodel;
	private EquipoDisenyoTableModel dismodel;
	
	public VistaListarEquipos() {
		setMinimumSize(new Dimension(670, 250));
		vListarEquipos();
	}

	public void vListarEquipos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/cliente.png")));
		setTitle("Listado equipos");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
				dispose();
			}
		});
		setBounds(100, 100, 671, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		setContentPane(contentPane);
		
		desmodel = new EquipoDesarrolloTableModel();
		table2 = new JTable(desmodel);
		JScrollPane tablpar = new JScrollPane(table2);
		contentPane.add(tablpar);
		
		dismodel = new EquipoDisenyoTableModel();
		table1 = new JTable(dismodel);
		JScrollPane tabldis = new JScrollPane(table1);
		contentPane.add(tabldis);
		
	}

	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Eventos.VistaListarEquipos:
			setVisible(true);
			break;
		case Eventos.ListarEquipos:
			Set<TEquipoDesarrollo> listades = new HashSet<TEquipoDesarrollo>();
			Set<TEquipoDisenio> listadis = new HashSet<TEquipoDisenio>();
			Set<TEquipo> lista = (Set<TEquipo>) object;
			
			for (TEquipo cl : lista) {
				if (cl instanceof TEquipoDesarrollo) {
					listades.add((TEquipoDesarrollo) cl);
				} else if (cl instanceof TEquipoDisenio) {
					listadis.add((TEquipoDisenio) cl);
				}
			}
			
			desmodel.setLista(listades);
			desmodel.fireTableStructureChanged();
			
			dismodel.setLista(listadis);
			dismodel.fireTableStructureChanged();
			break;
		}		
	}
}