package Presentacion.Cliente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Producto.TProducto;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaModificarEmpleado;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaModificarCliente extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTextField NoTF;
	private JTextField DiTF;
	private JTextField TeTF;
	private JTextField CiTF;
	private JTextField EmTF;
	private JTextField IdTF;
	private JTextField DnTF;
	
	private boolean cerrar = true;
	private boolean esDistribuidor = true;
	
	public VistaModificarCliente() {
		vModificarCliente();
	}
	
	public void vModificarCliente() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Modificar cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaModificarEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Modificar Cliente");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaModificarEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel nombrelabel = new JLabel("Nombre: ");
		nombrelabel.setBounds(100, 34, 56, 14);
		infopanel.add(nombrelabel);
		
		NoTF = new JTextField();
		NoTF.setColumns(10);
		NoTF.setBounds(153, 34, 215, 17);
		infopanel.add(NoTF);
		
		JLabel emaillabel = new JLabel("Email: ");
		emaillabel.setBounds(110, 54, 111, 14);
		infopanel.add(emaillabel);
		
		EmTF = new JTextField();
		EmTF.setColumns(10);
		EmTF.setBounds(153, 54, 215, 17);
		infopanel.add(EmTF);
		
		JLabel tipoLabel = new JLabel("Tipo: ");
		tipoLabel.setBounds(115, 10, 111, 14);
		infopanel.add(tipoLabel);
		
		JLabel ciflabel = new JLabel("CIF: ");
		ciflabel.setBounds(110, 74, 111, 14);
		infopanel.add(ciflabel);
		
		CiTF = new JTextField();
		CiTF.setColumns(10);
		CiTF.setBounds(153, 74, 215, 17);
		infopanel.add(CiTF);
		
		JLabel telefonolabel = new JLabel("telefono: ");
		telefonolabel.setBounds(96, 94, 111, 14);
		infopanel.add(telefonolabel);
		
		TeTF = new JTextField();
		TeTF.setColumns(10);
		TeTF.setBounds(153, 94, 215, 17);
		infopanel.add(TeTF);
		
		JLabel dnilabel = new JLabel("DNI: ");
		dnilabel.setBounds(110, 74, 111, 14);
		infopanel.add(dnilabel);
		
		DnTF = new JTextField();
		DnTF.setColumns(10);
		DnTF.setBounds(153, 74, 215, 17);
		infopanel.add(DnTF);
		
		JLabel direccionlabel = new JLabel("Direccion: ");
		direccionlabel.setBounds(90, 94, 111, 14);
		infopanel.add(direccionlabel);
		
		DiTF = new JTextField();
		DiTF.setColumns(10);
		DiTF.setBounds(153, 94, 215, 17);
		infopanel.add(DiTF);
		
		JLabel idlabel = new JLabel("ID: ");
		idlabel.setBounds(110, 114, 111, 14);
		infopanel.add(idlabel);
		
		IdTF = new JTextField();
		IdTF.setColumns(10);
		IdTF.setBounds(153, 114, 215, 17);
		infopanel.add(IdTF);
		
		JSpinner fieldspinner = new JSpinner();
		fieldspinner.setModel(new SpinnerListModel(new String[] {"Distribuidor", "Particular"}));
		fieldspinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Tipo de cliente: " + fieldspinner.getValue().toString());
				if (fieldspinner.getValue().toString().equals("Distribuidor"))
					esDistribuidor = true;
				else
					esDistribuidor = false;
				
				ciflabel.setVisible(esDistribuidor);
				CiTF.setVisible(esDistribuidor);
				telefonolabel.setVisible(!esDistribuidor);
				TeTF.setVisible(!esDistribuidor);
				dnilabel.setVisible(!esDistribuidor);
				DnTF.setVisible(!esDistribuidor);
				direccionlabel.setVisible(esDistribuidor);
				DiTF.setVisible(esDistribuidor);
			}
		});
		fieldspinner.setBounds(153, 10, 215, 20);
		infopanel.add(fieldspinner);
		
		
		JButton okbutton = new JButton("Ok");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		okbutton.setBounds(141, 205, 90, 23);
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.addActionListener((e)->{
				Controlador.getInstance().update(Eventos.MainWindowCliente, e);				
				dispose();
			});
		
		cancelbutton.setBounds(248, 205, 90, 23);
		infopanel.add(cancelbutton);
		
		ciflabel.setVisible(esDistribuidor);
		CiTF.setVisible(esDistribuidor);
		telefonolabel.setVisible(!esDistribuidor);
		TeTF.setVisible(!esDistribuidor);
		dnilabel.setVisible(!esDistribuidor);
		DnTF.setVisible(!esDistribuidor);
		direccionlabel.setVisible(esDistribuidor);
		DiTF.setVisible(esDistribuidor);
	}
	
	public void ok() {
		TCliente cliente;
		if(esDistribuidor) {
			cliente = new TDistribuidor();
			cliente.setNombre(NoTF.getText());
			cliente.setEmail(EmTF.getText());
			cliente.setID(Integer.parseInt(IdTF.getText()));
			((TDistribuidor) cliente).setCIF(CiTF.getText());
			((TDistribuidor) cliente).setDireccion(DiTF.getText());
		} else {
			cliente = new TParticular();
			cliente.setNombre(NoTF.getText());
			cliente.setEmail(EmTF.getText());
			((TParticular) cliente).setDNI(DnTF.getText());
			((TParticular) cliente).setTelefono(Integer.parseInt(TeTF.getText()));
		}
		Controlador.getInstance().update(Eventos.ModificarCliente, cliente);
		if (cerrar) 
			dispose();
		else
			cerrar = true;
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaModificarCliente:
			setVisible(true);
			break;
		case Eventos.ModificarClienteOK:
			JOptionPane.showMessageDialog(null, "Modificado con éxito");
			Controlador.getInstance().update(Eventos.MainWindowCliente, null);
			break;
		case Eventos.ModificarClienteEmailNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el email ya existe en la base de datos");
			cerrar = false;
			break;
		case Eventos.ModificarClienteActivoNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el Cliente no esta activo");
			cerrar = false;
			break;
		case Eventos.ModificarClienteNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el ID no existe en la base de datos");
			cerrar = false;
			break;
		}	
	}
}