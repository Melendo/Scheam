package Presentacion.Cliente;

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

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;

public class VistaMostrarClientes extends JFrame implements IGUI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table1;
	private JTable table2;
	
	private DistribuidorTableModel distribuidoresmodel;
	private ParticularTableModel particularesmodel;
	
	public VistaMostrarClientes() {
		setMinimumSize(new Dimension(670, 250));
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
		setBounds(100, 100, 671, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		setContentPane(contentPane);
		
		particularesmodel = new ParticularTableModel();
		table2 = new JTable(particularesmodel);
		JScrollPane tablpar = new JScrollPane(table2);
		contentPane.add(tablpar);
		
		distribuidoresmodel = new DistribuidorTableModel();
		table1 = new JTable(distribuidoresmodel);
		JScrollPane tabldis = new JScrollPane(table1);
		contentPane.add(tabldis);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Eventos.VistaListarCliente:
			setVisible(true);
			break;
		case Eventos.ListarCliente:
			Set<TDistribuidor> listadist = new HashSet<TDistribuidor>();
			Set<TParticular> listapart = new HashSet<TParticular>();
			Set<TCliente> lista = (Set<TCliente>) object;
			
			for (TCliente cl : lista) {
				if (cl instanceof TDistribuidor) {
					listadist.add((TDistribuidor) cl);
				} else if (cl instanceof TParticular) {
					listapart.add((TParticular) cl);
				}
			}
			
			distribuidoresmodel.setLista(listadist);
			distribuidoresmodel.fireTableStructureChanged();
			
			particularesmodel.setLista(listapart);
			particularesmodel.fireTableStructureChanged();
			break;
		}
	}
}