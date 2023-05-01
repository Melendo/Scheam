
package Presentacion.Factura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.MainWindowEmpleado;

public class MainWindowFactura extends JFrame implements IGUI {
	
	public MainWindowFactura() {
		vMainWindowFactura();
	}

	public void vMainWindowFactura() {
		setBounds(100, 100, 994, 515);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Scheam - Factura y Carrito");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindowEmpleado.class.getResource("/icons/logo.png")));
		setMinimumSize(new Dimension(1000, 800));
		getContentPane().setMinimumSize(new Dimension(1000, 800));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel toppanel = new JPanel();
		getContentPane().add(toppanel, BorderLayout.NORTH);
		
		JLabel emplogo = new JLabel("   Factura y Carrito");
		emplogo.setFont(new Font("Tahoma", Font.BOLD, 25));
		ImageIcon logoemplicon = new ImageIcon(MainWindowEmpleado.class.getResource("/icons/factura.png"));
		Image modlogoemplicon = logoemplicon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		toppanel.setLayout(new BorderLayout(0, 0));
		emplogo.setIcon(new ImageIcon(modlogoemplicon));
		toppanel.add(emplogo, BorderLayout.WEST);
		
		JButton backbutton = new JButton("Volver");
		backbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.MainWindow, null);
				dispose();
			}
		});
		toppanel.add(backbutton, BorderLayout.EAST);
		
		JPanel buttonpanel = new JPanel();
		getContentPane().add(buttonpanel, BorderLayout.CENTER);
		
		JButton crearcarritobutton = new JButton("Crear Carrito");
		crearcarritobutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		crearcarritobutton.setHorizontalTextPosition(SwingConstants.CENTER);
		crearcarritobutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/factura/abrir_carrito-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		crearcarritobutton.setBackground(Color.WHITE);
		crearcarritobutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.CerrarCarrito, null);
				dispose();
			}
		});
		buttonpanel.setLayout(new GridLayout(0, 3, 0, 0));
		buttonpanel.add(crearcarritobutton);
		
		JButton cerrarcarritobutton = new JButton("Cerrar Carrito");
		cerrarcarritobutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaBajaEmpleado, null);
				dispose();
			}
		});
		cerrarcarritobutton.setHorizontalTextPosition(SwingConstants.CENTER);
		cerrarcarritobutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		cerrarcarritobutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/factura/cerrar_carrito-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		cerrarcarritobutton.setBackground(Color.WHITE);
		buttonpanel.add(cerrarcarritobutton);
		
		JButton eliminarcarritobutton = new JButton("Eliminar Carrito");
		eliminarcarritobutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/baja-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		eliminarcarritobutton.setHorizontalTextPosition(SwingConstants.CENTER);
		eliminarcarritobutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		eliminarcarritobutton.setBackground(Color.WHITE);
		eliminarcarritobutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaModificarEmpleado, null);
				dispose();
			}
		});
		buttonpanel.add(eliminarcarritobutton);
		
		JButton mostrarcarritobutton = new JButton("Mostrar Carrito");
		mostrarcarritobutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/listar_todos-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		mostrarcarritobutton.setHorizontalTextPosition(SwingConstants.CENTER);
		mostrarcarritobutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		mostrarcarritobutton.setBackground(Color.WHITE);
		mostrarcarritobutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaModificarEmpleado, null);
				dispose();
			}
		});
		buttonpanel.add(mostrarcarritobutton);
		
		JButton aniadirproductobutton = new JButton("Añadir Producto a Carrito");
		aniadirproductobutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/factura/añadir_producto_carrito-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		aniadirproductobutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		aniadirproductobutton.setHorizontalTextPosition(SwingConstants.CENTER);
		aniadirproductobutton.setBackground(Color.WHITE);
		aniadirproductobutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.ListarEmpleado, null);
				dispose();
			}
		});
		buttonpanel.add(aniadirproductobutton);
		
		JButton quitarproductobutton = new JButton("Quitar Producto de Carrito"); 
		quitarproductobutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/factura/quitar_producto_carrito-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		quitarproductobutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		quitarproductobutton.setHorizontalTextPosition(SwingConstants.CENTER);
		quitarproductobutton.setBackground(Color.WHITE);
		quitarproductobutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaFormMostrarEmpleadoID, null);
				dispose();
			}
		});
		buttonpanel.add(quitarproductobutton);
		
		JButton listfacturasbutton = new JButton("Mostrar Facturas Cliente");
		listfacturasbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listfacturasbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		Image modintequipoimg = new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/listar_todos-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		listfacturasbutton.setIcon(new ImageIcon(modintequipoimg));
		listfacturasbutton.setBackground(Color.WHITE);
		listfacturasbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaFormListarIntegrantesEquipoId, null);
				dispose();
			}
		});
		buttonpanel.add(listfacturasbutton);
		
		JButton mostrarfacturasidbutton = new JButton("Mostrar Facturas por ID");
		mostrarfacturasidbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		mostrarfacturasidbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		Image modimg = new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/listar_uno-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		mostrarfacturasidbutton.setIcon(new ImageIcon(modimg));
		mostrarfacturasidbutton.setBackground(Color.WHITE);
		mostrarfacturasidbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaFormListarIntegrantesEquipoId, null);
				dispose();
			}
		});
		buttonpanel.add(mostrarfacturasidbutton);
		
		
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.MainWindowFactura:
			setVisible(true);
			break;
		}
	}
}