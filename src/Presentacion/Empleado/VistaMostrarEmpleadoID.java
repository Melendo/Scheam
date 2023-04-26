package Presentacion.Empleado;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Empleado.TEmpleado;
import Presentacion.IGUI;
import Presentacion.Controlador.Eventos;

public class VistaMostrarEmpleadoID extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	
	private EmpleadosTableModel empleadosmodel;
	
	public VistaMostrarEmpleadoID() {
		vMostrarEmpleadoID();
	}
	
	public void vMostrarEmpleadoID() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/empleado.png")));
		setTitle("Mostrar Empleado por ID");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		empleadosmodel = new EmpleadosTableModel();
		table = new JTable(empleadosmodel);
		JScrollPane tablesp = new JScrollPane(table);
		contentPane.add(tablesp, BorderLayout.CENTER);
		
		setVisible(false);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarEmpleadoID:
			setVisible(true);
			break;
		case Eventos.MostrarEmpleadoID:
			Set<TEmpleado> lista = new HashSet<TEmpleado>();
			lista.add((TEmpleado) object);
			empleadosmodel.setLista(lista);
			empleadosmodel.fireTableStructureChanged();
			break;
		}
	}

}
