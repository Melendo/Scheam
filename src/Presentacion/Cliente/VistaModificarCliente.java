package Presentacion.Cliente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
	
	public VistaModificarCliente() {
		vModificarCliente();
	}
	
	public void vModificarCliente() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Modificar Producto");
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
		nombrelabel.setBounds(75, 14, 56, 14);
		infopanel.add(nombrelabel);
		
		NoTF = new JTextField();
		NoTF.setColumns(10);
		NoTF.setBounds(153, 11, 215, 17);
		infopanel.add(NoTF);
		
		JLabel fecchalabel = new JLabel("Email: ");
		fecchalabel.setBounds(10, 39, 111, 14);
		infopanel.add(fecchalabel);
		
		EmTF = new JTextField();
		EmTF.setColumns(10);
		EmTF.setBounds(153, 36, 215, 17);
		infopanel.add(EmTF);
		
		JLabel preciolabel = new JLabel("Precio:");
		preciolabel.setBounds(85, 66, 46, 14);
		infopanel.add(preciolabel);
		
		/*
		PrTF = new JTextField();
		PrTF.setColumns(10);
		PrTF.setBounds(153, 63, 215, 17);
		infopanel.add(PrTF);
		
		JLabel generolabel = new JLabel("Genero:");
		generolabel.setBounds(75, 91, 46, 14);
		infopanel.add(generolabel);
		
		GeTF = new JTextField();
		GeTF.setColumns(10);
		GeTF.setBounds(153, 91, 215, 17);
		infopanel.add(GeTF);
		
		JLabel pegilabel = new JLabel("PEGI:");
		pegilabel.setBounds(85, 118, 56, 14);
		infopanel.add(pegilabel);
		
		PeTF = new JTextField();
		PeTF.setColumns(10);
		PeTF.setBounds(153, 116, 215, 17);
		infopanel.add(PeTF);
		
		JLabel stocklabel = new JLabel("Stock:");
		stocklabel.setBounds(85, 147, 46, 14);
		infopanel.add(stocklabel);
		
		StTF = new JTextField();
		StTF.setColumns(10);
		StTF.setBounds(153, 144, 215, 17);
		infopanel.add(StTF);
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(102, 172, 29, 14);
		infopanel.add(idlabel);
		
		IdTF = new JTextField();
		IdTF.setColumns(10);
		IdTF.setBounds(153, 172, 215, 17);
		infopanel.add(IdTF);
		*/
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
				Controlador.getInstance().update(Eventos.MainWindowProducto, e);				
				dispose();
			});
		
		cancelbutton.setBounds(248, 205, 90, 23);
		infopanel.add(cancelbutton);
	}
	
	public void ok() {
		TCliente cliente = new TCliente();

		cliente.setNombre(NoTF.getText());
		cliente.setEmail(EmTF.getText());
		cliente.setID(Integer.parseInt(IdTF.getText()));
		if(cliente instanceof TDistribuidor) {
			((TDistribuidor) cliente).setCIF(CiTF.getText());
			((TDistribuidor) cliente).setDireccion(DiTF.getText());
		} else if(cliente instanceof TParticular){
			((TParticular) cliente).setDNI(DnTF.getText());
			((TParticular) cliente).setTelefono(Integer.parseInt(DiTF.getText()));
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
			Controlador.getInstance().update(Eventos.MainWindowProducto, null);
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