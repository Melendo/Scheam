package Presentacion.Equipo;

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

public class MainWindowEquipo extends JFrame implements IGUI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindowEquipo() {
		vMainWindowEquipo();
	}

	public void vMainWindowEquipo() {
		setBounds(100, 100, 994, 515);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Scheam - Equipo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindowEmpleado.class.getResource("/icons/logo.png")));
		setMinimumSize(new Dimension(1000, 800));
		getContentPane().setMinimumSize(new Dimension(1000, 800));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel toppanel = new JPanel();
		getContentPane().add(toppanel, BorderLayout.NORTH);
		
		JLabel emplogo = new JLabel("   Equipo");
		emplogo.setFont(new Font("Tahoma", Font.BOLD, 25));
		ImageIcon logoemplicon = new ImageIcon(MainWindowEmpleado.class.getResource("/icons/equipo.png"));
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
		
		JButton altabutton = new JButton("Alta Equipo");
		altabutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		altabutton.setHorizontalTextPosition(SwingConstants.CENTER);
		altabutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/alta-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		altabutton.setBackground(Color.WHITE);
		altabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaAltaEquipo, null);
				dispose();
			}
		});
		buttonpanel.setLayout(new GridLayout(0, 3, 0, 0));
		buttonpanel.add(altabutton);
		
		JButton bajabutton = new JButton("Baja Equipo");
		bajabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaBajaEquipo, null);
				dispose();
			}
		});
		bajabutton.setHorizontalTextPosition(SwingConstants.CENTER);
		bajabutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		bajabutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/baja-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		bajabutton.setBackground(Color.WHITE);
		buttonpanel.add(bajabutton);
		
		JButton modbutton = new JButton("Modificar Equipo");
		modbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		modbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		modbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		modbutton.setBackground(Color.WHITE);
		modbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaModificarEquipo, null);
				dispose();
			}
		});
		buttonpanel.add(modbutton);
		
		JButton listallbutton = new JButton("Listado de todos los equipos");
		listallbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/listar_todos-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		listallbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		listallbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listallbutton.setBackground(Color.WHITE);
		listallbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.ListarEquipos, null);
				dispose();
			}
		});
		buttonpanel.add(listallbutton);
		
		JButton listidbutton = new JButton("Listado de equipo por ID"); 
		listidbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/generales/listar_uno-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		listidbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		listidbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listidbutton.setBackground(Color.WHITE);
		listidbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaFormMostrarEquipoID, null);
				dispose();
			}
		});
		buttonpanel.add(listidbutton);
		
		JButton listarequipodeintbutton = new JButton("Listar equipos de un empleado");
		listarequipodeintbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listarequipodeintbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		listarequipodeintbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/equipo/mostrar_equipos_empleado-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		listarequipodeintbutton.setBackground(Color.WHITE);
		listarequipodeintbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaFormListarEquiposDeIntegranteId, null);
				dispose();
			}
		});
		buttonpanel.add(listarequipodeintbutton);
		
		JButton addintegrantebutton = new JButton("Añadir integrante a un equipo");
		addintegrantebutton.setHorizontalTextPosition(SwingConstants.CENTER);
		addintegrantebutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		addintegrantebutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/equipo/aniadir_integrante-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		addintegrantebutton.setBackground(Color.WHITE);
		addintegrantebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaAnyadirIntegrante, null);
				dispose();
			}
		});
		buttonpanel.add(addintegrantebutton);
		
		JButton removeintegrantebutton = new JButton("Quitar integrante de un equipo");
		removeintegrantebutton.setHorizontalTextPosition(SwingConstants.CENTER);
		removeintegrantebutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		removeintegrantebutton.setIcon(new ImageIcon(new ImageIcon(MainWindowEmpleado.class.getResource("/icons/equipo/quitar_integrante-removebg-preview.png")).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
		removeintegrantebutton.setBackground(Color.WHITE);
		removeintegrantebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaRetirarIntegrante, null);
				dispose();
			}
		});
		buttonpanel.add(removeintegrantebutton);
		
		
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.MainWindowEquipo:
			setVisible(true);
			break;
		}
	}
}