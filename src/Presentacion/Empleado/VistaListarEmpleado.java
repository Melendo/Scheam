package Presentacion.Empleado;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import Presentacion.IGUI;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaListarEmpleado extends JFrame implements ActionListener, IGUI {
	
	private JPanel contentPane;
	private JTable table;

	public void vListarEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TableEmpleadosWindow.class.getResource("/icons/empleado.png")));
		setTitle("Listado Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
		//TODO añadir el tablemodel
	}

	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void update(int event, Object object) {
		
	}
	
}