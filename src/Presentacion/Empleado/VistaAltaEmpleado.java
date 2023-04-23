package Presentacion.Empleado;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Presentacion.IGUI;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;


public class VistaAltaEmpleado extends JFrame implements IGUI, ActionListener {
	
	private JPanel contentPane;
	private JTextField nombretextfield;
	private JTextField apellidostextfield;
	private JTextField dnitextfield;
	private JTextField emailtextfield;
	private JTextField telefonotextfield;
	private JTextField sueldotextfield;

	public void vAltaEmpleado() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Alta Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaAltaEmpleado.class.getResource("/icons/generales/alta-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Alta Empleado");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaAltaEmpleado.class.getResource("/icons/generales/alta-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel nombrelabel = new JLabel("Nombre:");
		nombrelabel.setBounds(75, 14, 56, 14);
		infopanel.add(nombrelabel);
		
		nombretextfield = new JTextField();
		nombretextfield.setBounds(153, 11, 215, 17);
		infopanel.add(nombretextfield);
		nombretextfield.setColumns(10);
		
		JLabel apellidoslabel = new JLabel("Apellidos: ");
		apellidoslabel.setBounds(74, 39, 69, 14);
		infopanel.add(apellidoslabel);
		
		apellidostextfield = new JTextField();
		apellidostextfield.setColumns(10);
		apellidostextfield.setBounds(153, 36, 215, 17);
		infopanel.add(apellidostextfield);
		
		JLabel dnilabel = new JLabel("DNI:");
		dnilabel.setBounds(98, 66, 33, 14);
		infopanel.add(dnilabel);
		
		dnitextfield = new JTextField();
		dnitextfield.setColumns(10);
		dnitextfield.setBounds(153, 63, 215, 17);
		infopanel.add(dnitextfield);
		
		JLabel emaillabel = new JLabel("Email:");
		emaillabel.setBounds(93, 94, 38, 14);
		infopanel.add(emaillabel);
		
		emailtextfield = new JTextField();
		emailtextfield.setColumns(10);
		emailtextfield.setBounds(153, 91, 215, 17);
		infopanel.add(emailtextfield);
		
		JLabel telefonolabel = new JLabel("Telefono:");
		telefonolabel.setBounds(75, 119, 56, 14);
		infopanel.add(telefonolabel);
		
		telefonotextfield = new JTextField();
		telefonotextfield.setColumns(10);
		telefonotextfield.setBounds(153, 116, 215, 17);
		infopanel.add(telefonotextfield);
		
		JLabel sueldolabel = new JLabel("Sueldo:");
		sueldolabel.setBounds(85, 147, 46, 14);
		infopanel.add(sueldolabel);
		
		sueldotextfield = new JTextField();
		sueldotextfield.setColumns(10);
		sueldotextfield.setBounds(153, 144, 215, 17);
		infopanel.add(sueldotextfield);
		
		JButton okbutton = new JButton("Ok");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		okbutton.setBounds(142, 188, 90, 23);
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelbutton.setBounds(249, 188, 90, 23);
		infopanel.add(cancelbutton);
	}

	public void actionPerformed(ActionEvent e) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void update(int event, Object object) {
		// TODO Auto-generated method stub
		
	}
}