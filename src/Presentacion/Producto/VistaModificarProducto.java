package Presentacion.Producto;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

public class VistaModificarProducto extends JFrame implements IGUI, ActionListener {
	
	private JPanel contentPane;
	private JTextField NoTF;
	private JTextField FeTF;
	private JTextField PrTF;
	private JTextField GeTF;
	private JTextField PeTF;
	private JTextField StTF;
	private JTextField IdTF;
	
	private boolean cerrar = true;
	
	public VistaModificarProducto() {		
		vModificarProducto();
		
	}

	public void vModificarProducto() {
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
		
		JLabel logo = new JLabel("      Modificar Producto");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaModificarEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel nombrelabel = new JLabel("Nombre:");
		nombrelabel.setBounds(75, 14, 56, 14);
		infopanel.add(nombrelabel);
		
		NoTF = new JTextField();
		NoTF.setColumns(10);
		NoTF.setBounds(153, 11, 215, 17);
		infopanel.add(NoTF);
		
		JLabel fecchalabel = new JLabel("Fecha de lanzamiento: ");
		fecchalabel.setBounds(10, 39, 111, 14);
		infopanel.add(fecchalabel);
		
		FeTF = new JTextField();
		FeTF.setColumns(10);
		FeTF.setBounds(153, 36, 215, 17);
		infopanel.add(FeTF);
		
		JLabel preciolabel = new JLabel("Precio:");
		preciolabel.setBounds(85, 66, 46, 14);
		infopanel.add(preciolabel);
		
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
		TProducto producto = new TProducto();

		if(!NoTF.getText().equals(""))
		producto.setNombre(NoTF.getText());
		if(!FeTF.getText().equals(""))
		producto.setFechalanzamiento(Integer.parseInt(FeTF.getText()));
		if(!PrTF.getText().equals(""))
		producto.setPrecio(Double.parseDouble(PrTF.getText()));
		if(!GeTF.getText().equals(""))
		producto.setGenero(GeTF.getText());
		if(!PeTF.getText().equals(""))
		producto.setPEGI(Integer.parseInt(PeTF.getText()));
		if(!StTF.getText().equals(""))
		producto.setStock(Integer.parseInt(StTF.getText()));//terminado en el DAO
		if(!IdTF.getText().equals(""))
		producto.setIdproyecto(Integer.parseInt(IdTF.getText()));
		
		
		Controlador.getInstance().update(Eventos.ModificarProducto, producto);
		if (cerrar) 
			dispose();
		else
			cerrar = true;
	}

	public void update() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void actionPerformed(ActionEvent e) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaModificarProducto:
			setVisible(true);
			break;
		case Eventos.ModificarProductoOK:
			JOptionPane.showMessageDialog(null, "Modificado con éxito");
			Controlador.getInstance().update(Eventos.MainWindowProducto, null);
			break;
		case Eventos.ModificarProductoNombreNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el Nombre ya existe en la base de datos");
			cerrar = false;
			break;
		case Eventos.ModificarProductoActivoNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el producto no esta activo");
			cerrar = false;
			break;
		case Eventos.ModificarProductoNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el ID no existe en la base de datos");
			cerrar = false;
			break;
		
		}	
	}
}