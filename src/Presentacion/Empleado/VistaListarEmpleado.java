package Presentacion.Empleado;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Empleado.TEmpleado;
import Presentacion.IGUI;
import Presentacion.Controlador.Eventos;

public class VistaListarEmpleado extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	
	private EmpleadosTableModel empleadosmodel;
	
	public VistaListarEmpleado() {
		vListarEmpleado();
	}

	public void vListarEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TableEmpleadosWindow.class.getResource("/icons/empleado.png")));
		setTitle("Listado Empleados");
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
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Eventos.VistaListarEmpleado:
			setVisible(true);
			break;
		case Eventos.ListarEmpleado:
			empleadosmodel.setLista((Set<TEmpleado>) object);
			empleadosmodel.fireTableStructureChanged();
			break;
		}
	}
	
}