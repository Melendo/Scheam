/**
 * 
 */
package Presentacion.Empleado;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Empleado.TEmpleado;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaModificarEmpleado extends JFrame implements IGUI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombretextfield;
	private JTextField apellidostextfield;
	private JTextField dnitextfield;
	private JTextField emailtextfield;
	private JTextField telefonotextfield;
	private JTextField sueldotextfield;
	private JTextField idtextfield;
	
	private boolean cerrar = true;
	
	public VistaModificarEmpleado() {
		vModificarEmpleado();
	}

	public void vModificarEmpleado() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Modificar Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaModificarEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Modificar Empleado");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaModificarEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
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
				ok();
			}
		});
		okbutton.setBounds(141, 205, 90, 23);
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowEmpleado, e);				
				dispose();
			}
		});
		cancelbutton.setBounds(248, 205, 90, 23);
		infopanel.add(cancelbutton);
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(107, 172, 46, 14);
		infopanel.add(idlabel);
		
		idtextfield = new JTextField();
		idtextfield.setColumns(10);
		idtextfield.setBounds(153, 172, 215, 17);
		infopanel.add(idtextfield);
	}
	
	private void ok() {
		TEmpleado empleado = new TEmpleado();
		if (!idtextfield.getText().equals("")) 
			empleado.setIdEmpleado(Integer.parseInt(idtextfield.getText()));
		else
			empleado.setIdEmpleado(null);
		if (!nombretextfield.getText().equals("")) 
			empleado.setNombre(nombretextfield.getText());
		if (!apellidostextfield.getText().equals("")) 
			empleado.setApellidos(apellidostextfield.getText());
		if (!dnitextfield.getText().equals("")) 
			empleado.setDNI(dnitextfield.getText());
		if (!emailtextfield.getText().equals("")) 
			empleado.setE_mail(emailtextfield.getText());
		if (!telefonotextfield.getText().equals("")) 
			empleado.setTlfn(Integer.parseInt(telefonotextfield.getText()));
		else
			empleado.setTlfn(null);
		if (!sueldotextfield.getText().equals(""))
			empleado.setSueldo(Double.parseDouble(sueldotextfield.getText()));
		else
			empleado.setSueldo(null);
		Controlador.getInstance().update(Eventos.ModificarEmpleado, empleado);
		if (cerrar) 
			dispose();
		else
			cerrar = true;
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaModificarEmpleado:
			setVisible(true);
			break;
		case Eventos.ModificarEmpleadoOK:
			JOptionPane.showMessageDialog(null, "Modificado con éxito");
			Controlador.getInstance().update(Eventos.MainWindowEmpleado, null);
			break;
		case Eventos.ModificarEmpleadoDNINoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el DNI ya existe en la base de datos");
			cerrar = false;
			break;
		case Eventos.ModificarEmpleadoNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el ID no existe en la base de datos");
			cerrar = false;
			break;
		}
	}
}