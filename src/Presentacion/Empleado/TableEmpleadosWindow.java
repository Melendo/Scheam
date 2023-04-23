package Presentacion.Empleado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JTable;

public class TableEmpleadosWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public TableEmpleadosWindow() {
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
	}

}
