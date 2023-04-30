package Presentacion.Cliente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import Negocio.Equipo.TEquipoDisenio;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaAltaEmpleado;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;


public class VistaAltaCliente extends JFrame implements IGUI {

	private JPanel contentPane;
	private JTextField nombretextfield;
	private JTextField direcciontextfield;
	private JTextField telefonotextfield;
	private JTextField ciftextfield;
	private JTextField emailtextfield;
	private JTextField DNItextfield;
	
	private boolean esDistribuidor = true;
	private boolean cerrar = true;
	
	public VistaAltaCliente() {
		vAltaCliente();
	}
	
	public void vAltaCliente() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Alta Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaAltaEmpleado.class.getResource("/icons/generales/alta-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Alta Cliente");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaAltaEmpleado.class.getResource("/icons/generales/alta-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel tipoCliente = new JLabel("Elige el tipo de cliente:");
		tipoCliente.setBounds(78, 37, 130, 14);
		infopanel.add(tipoCliente);
		
		//METER NOMBRE
		JLabel nombre = new JLabel("Nombre: ");
		nombre.setBounds(67, 79, 130, 14);
		infopanel.add(nombre);
		
		nombretextfield = new JTextField();
		nombretextfield.setBounds(183, 79, 215, 17);
		infopanel.add(nombretextfield);
		nombretextfield.setColumns(10);
		
		//METER EMAIL
		JLabel Email = new JLabel("Email: ");
		Email.setBounds(67, 100, 130, 14);
		infopanel.add(Email);
		
		emailtextfield = new JTextField();
		emailtextfield.setBounds(183, 100, 215, 17);
		infopanel.add(emailtextfield);
		emailtextfield.setColumns(10);
		
		//METER TELEFONO SI ES PARTICULAR
		JLabel telefono = new JLabel("Telefono: ");
		telefono.setBounds(67, 120, 130, 14);
		infopanel.add(telefono);
		
		telefonotextfield = new JTextField();
		telefonotextfield.setBounds(183, 120, 215, 17);
		infopanel.add(telefonotextfield);
		telefonotextfield.setColumns(10);
		
		//METER DNI SI ES PARTICULAR
		JLabel DNI = new JLabel("DNI: ");
		DNI.setBounds(67, 140, 130, 14);
		infopanel.add(DNI);
		
		DNItextfield = new JTextField();
		DNItextfield.setBounds(183, 140, 215, 17);
		infopanel.add(DNItextfield);
		DNItextfield.setColumns(10);
		
		//METER CIF SI ES DISTRIBUIDOR
		JLabel CIF = new JLabel("CIF: ");
		CIF.setBounds(67, 120, 130, 14);
		infopanel.add(CIF);
		
		ciftextfield = new JTextField();
		ciftextfield.setBounds(183, 120, 215, 17);
		infopanel.add(ciftextfield);
		ciftextfield.setColumns(10);
		
		//METER DIRECCION SI ES DISTRIBUIDOR
		JLabel direccion = new JLabel("Direccion: ");
		direccion.setBounds(67, 140, 130, 14);
		infopanel.add(direccion);
		
		direcciontextfield = new JTextField();
		direcciontextfield.setBounds(183, 140, 215, 17);
		infopanel.add(direcciontextfield);
		direcciontextfield.setColumns(10);
		
		JButton okbutton = new JButton("Ok");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		okbutton.setBounds(142, 188, 90, 23);
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowCliente, null);
				dispose();
			}
		});
		cancelbutton.setBounds(249, 188, 90, 23);
		infopanel.add(cancelbutton);
		
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
				
				CIF.setVisible(esDistribuidor);
				ciftextfield.setVisible(esDistribuidor);
				direccion.setVisible(esDistribuidor);
				direcciontextfield.setVisible(esDistribuidor);
				telefonotextfield.setVisible(!esDistribuidor);
				telefono.setVisible(!esDistribuidor);
				DNI.setVisible(!esDistribuidor);
				DNItextfield.setVisible(!esDistribuidor);
			}
		});
		CIF.setVisible(esDistribuidor);
		ciftextfield.setVisible(esDistribuidor);
		direccion.setVisible(esDistribuidor);
		direcciontextfield.setVisible(esDistribuidor);
		telefonotextfield.setVisible(!esDistribuidor);
		telefono.setVisible(!esDistribuidor);
		DNI.setVisible(!esDistribuidor);
		DNItextfield.setVisible(!esDistribuidor);
		fieldspinner.setBounds(211, 34, 173, 20);
		infopanel.add(fieldspinner);
	}

	private void ok() {
		TCliente cliente;
		if (esDistribuidor) {
			cliente = new TDistribuidor();
			cliente.setNombre(nombretextfield.getText());
			cliente.setEmail(emailtextfield.getText());
			((TDistribuidor) cliente).setDireccion(direcciontextfield.getText());
			((TDistribuidor) cliente).setCIF(ciftextfield.getText());
		} else {
			cliente = new TParticular();
			cliente.setNombre(nombretextfield.getText());
			cliente.setEmail(emailtextfield.getText());
			((TParticular) cliente).setTelefono(Integer.parseInt(telefonotextfield.getText()));
			((TParticular) cliente).setDNI(DNItextfield.getText());
		}
		Controlador.getInstance().update(Eventos.AltaCliente, cliente);
		if (cerrar)
			dispose();
		else
			cerrar = true;
	}	

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaAltaCliente:
			setVisible(true);
			break;
		}
	}
}