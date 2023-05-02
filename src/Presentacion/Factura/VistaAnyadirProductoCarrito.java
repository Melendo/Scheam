
package Presentacion.Factura;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Tareas.TTarea;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Tareas.VistaAltaTarea;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaAnyadirProductoCarrito extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTextField productotextfield;
	private JTextField cantidadtextfield;
	
	private boolean cerrar = true;
	
	public VistaAnyadirProductoCarrito() {
		vAnyadirProductoCarrito();
	}
	
	public void vAnyadirProductoCarrito() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("A�adir Producto a Carrito");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaAltaTarea.class.getResource("/icons/factura/aniadir_producto_carrito-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Añadir Producto a Carrito");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaAltaTarea.class.getResource("/icons/factura/aniadir_producto_carrito-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel nombrelabel = new JLabel("Producto:");
		nombrelabel.setBounds(76, 56, 56, 14);
		infopanel.add(nombrelabel);
		
		productotextfield = new JTextField();
		productotextfield.setBounds(154, 53, 215, 17);
		infopanel.add(productotextfield);
		productotextfield.setColumns(10);
		
		JLabel equipolabel = new JLabel("Cantidad:");
		equipolabel.setBounds(76, 81, 69, 14);
		infopanel.add(equipolabel);
		
		cantidadtextfield = new JTextField();
		cantidadtextfield.setColumns(10);
		cantidadtextfield.setBounds(154, 78, 215, 17);
		infopanel.add(cantidadtextfield);
		
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
				Controlador.getInstance().update(Eventos.MainWindowFactura, null);
				dispose();
			}
		});
		cancelbutton.setBounds(249, 188, 90, 23);
		infopanel.add(cancelbutton);
		
	}
	
	private void ok() {
		int idproducto = (Integer.parseInt(productotextfield.getText()));
		int cantidad = (Integer.parseInt(cantidadtextfield.getText()));
		List<Integer> pair = new ArrayList<Integer>();
		pair.add(idproducto); pair.add(cantidad);
		Controlador.getInstance().update(Eventos.AnyadirProductoCarrito, pair);
		if (cerrar) 
			dispose();
		else
			cerrar = true;
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaAnyadirProductoCarrito:
			setVisible(true);
			break;
		case Eventos.AnyadirProductoCarritoOk:
			JOptionPane.showMessageDialog(null, "�xito a�adiendo producto");
			Controlador.getInstance().update(Eventos.MainWindowFactura, null);
			break;
		case Eventos.AnyadirProductoCarritoNoOk:
			JOptionPane.showMessageDialog(null, "Error a�adiendo producto");
			cerrar = false;
			break;
		case Eventos.NecesitasCarrito:
			JOptionPane.showMessageDialog(null, "Necesitas un Carrito abierto para hacer esto.");
			Controlador.getInstance().update(Eventos.MainWindowFactura, null);
			break; 
		}
	}
}