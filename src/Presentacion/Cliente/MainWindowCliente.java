package Presentacion.Cliente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.MainWindowEmpleado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class MainWindowCliente extends JFrame implements IGUI {

	public MainWindowCliente() {
		vMainWindowCliente();
	}
	
	public void vMainWindowCliente() {
		setBounds(100, 100, 994, 515);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Scheam - Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindowEmpleado.class.getResource("/icons/logo.png")));
		setMinimumSize(new Dimension(1000, 800));
		getContentPane().setMinimumSize(new Dimension(1000, 800));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel toppanel = new JPanel();
		getContentPane().add(toppanel, BorderLayout.NORTH);
		
		JLabel clilogo = new JLabel("   Cliente");
		clilogo.setFont(new Font("Tahoma", Font.BOLD, 25));
		ImageIcon logocliicon = new ImageIcon(MainWindowEmpleado.class.getResource("/icons/cliente.png"));
		Image modlogocliicon = logocliicon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		toppanel.setLayout(new BorderLayout(0, 0));
		clilogo.setIcon(new ImageIcon(modlogocliicon));
		toppanel.add(clilogo, BorderLayout.WEST);
		
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
		
		JButton altabutton = new JButton("Alta Cliente");
		altabutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		altabutton.setHorizontalTextPosition(SwingConstants.CENTER);
		altabutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/alta-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		altabutton.setBackground(Color.WHITE);
		altabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaAltaCliente, null);
				dispose();
			}
		});
		buttonpanel.setLayout(new GridLayout(0, 3, 0, 0));
		buttonpanel.add(altabutton);
		
		JButton bajabutton = new JButton("Baja Cliente");
		bajabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaBajaCliente, null);
				dispose();
			}
		});
		bajabutton.setHorizontalTextPosition(SwingConstants.CENTER);
		bajabutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		bajabutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/baja-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		bajabutton.setBackground(Color.WHITE);
		buttonpanel.add(bajabutton);
		
		JButton modbutton = new JButton("Modificar Cliente");
		modbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		modbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		modbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		modbutton.setBackground(Color.WHITE);
		modbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaModificarCliente, null);
				dispose();
			}
		});
		buttonpanel.add(modbutton);
		
		JButton listallbutton = new JButton("Listado de todos los clientes");
		listallbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/listar_todos-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		listallbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		listallbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listallbutton.setBackground(Color.WHITE);
		listallbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.ListarCliente, null);
				dispose();
			}
		});
		buttonpanel.add(listallbutton);
		
		JButton listidbutton = new JButton("Listado de cliente por ID"); 
		listidbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/listar_uno-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		listidbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		listidbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listidbutton.setBackground(Color.WHITE);
		listidbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaFormMostrarClienteID, null);
				dispose();
			}
		});
		buttonpanel.add(listidbutton);
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.MainWindowCliente:
			setVisible(true);
			break;
		}		
	}
}