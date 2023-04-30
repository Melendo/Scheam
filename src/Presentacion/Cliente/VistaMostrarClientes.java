package Presentacion.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Cliente.TCliente;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class VistaMostrarClientes extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table1;
	private JTable table2;
	
	private ClientesTableModel distribuidoresmodel;
	private ClientesTableModel particularesmodel;
	
	public VistaMostrarClientes() {
		vMostrarClientes();
	}
	
	public void vMostrarClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/cliente.png")));
		setTitle("Listado clientes");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowCliente, null);
				dispose();
			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		distribuidoresmodel = new ClientesTableModel(true);
		table1 = new JTable(distribuidoresmodel);
		JScrollPane tabldis = new JScrollPane(table1);
		contentPane.add(tabldis);
		/*
		JPanel tabla2 = new JPanel();
		tabla2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tabla2);
		tabla2.setLayout(new BorderLayout(0, 0));*/
		
		particularesmodel = new ClientesTableModel(false);
		table2 = new JTable(particularesmodel);
		JScrollPane tablpar = new JScrollPane(table2);
		contentPane.add(tablpar);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Eventos.VistaListarCliente:
			setVisible(true);
			break;
		case Eventos.ListarCliente:
			distribuidoresmodel.setLista((Set<TCliente>) object);
			distribuidoresmodel.fireTableStructureChanged();
			break;
		}
	}

}