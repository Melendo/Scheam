package Presentacion.Cliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;
import Negocio.Producto.TProducto;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaListarEmpleado;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaMostrarClienteID extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTable table;
	
	private DistribuidorTableModel disModel;
	private ParticularTableModel parModel;
	
	public VistaMostrarClienteID() {
		vVistaMostrarClienteID();
	}	
	
	public void vVistaMostrarClienteID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaListarEmpleado.class.getResource("/icons/empleado.png")));
		setTitle("Mostrar Cliente por ID");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowCliente, null);
			}
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		setVisible(false);	
	}
	
	public void TableDis() {
		disModel = new DistribuidorTableModel();
		table = new JTable(disModel);
		JScrollPane tabledis = new JScrollPane(table);
		contentPane.add(tabledis, BorderLayout.CENTER);
	}
	
	public void TablePar() {
		parModel = new ParticularTableModel();
		table = new JTable(parModel);
		JScrollPane tablepar = new JScrollPane(table);
		contentPane.add(tablepar, BorderLayout.CENTER);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaMostrarClienteID:
			setVisible(true);
			break;
		case Eventos.MostrarClienteID:
			if(object instanceof TDistribuidor) {
				TableDis();
				Set<TDistribuidor> lista = new HashSet<TDistribuidor>();
				lista.add((TDistribuidor) object);
				disModel.setLista(lista);
				disModel.fireTableStructureChanged();
			}else {
				TablePar();
				Set<TParticular> lista = new HashSet<TParticular>();
				lista.add((TParticular) object);
				parModel.setLista(lista);
				parModel.fireTableStructureChanged();
			}
			break;
		case Eventos.MostrarClienteIDNoOK:
			JOptionPane.showMessageDialog(null, "Error. El cliente no existe");
			Controlador.getInstance().update(Eventos.VistaFormMostrarClienteID, null);
			break;
		}		
	}
}