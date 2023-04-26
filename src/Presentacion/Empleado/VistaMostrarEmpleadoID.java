package Presentacion.Empleado;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Presentacion.IGUI;

public class VistaMostrarEmpleadoID extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	
	private EmpleadosTableModel empleadosmodel;
	
	public VistaMostrarEmpleadoID() {
		vMostrarEmpleadoID();
	}
	
	public void vMostrarEmpleadoID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/empleado.png")));
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

	@Override
	public void update(int event, Object object) {
		// TODO Auto-generated method stub

	}

}
