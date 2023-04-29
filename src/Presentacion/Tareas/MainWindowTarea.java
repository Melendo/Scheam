/**
 * 
 */
package Presentacion.Tareas;

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

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class MainWindowTarea extends JFrame implements ActionListener, IGUI {
	
	public MainWindowTarea() {		
		vMainWindowTarea();	
	}

	public void vMainWindowTarea() {
		
		setBounds(100, 100, 994, 515);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Scheam - Tarea");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindowTarea.class.getResource("/icons/logo.png")));
		setMinimumSize(new Dimension(1000, 800));
		getContentPane().setMinimumSize(new Dimension(1000, 800));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel toppanel = new JPanel();
		getContentPane().add(toppanel, BorderLayout.NORTH);
		
		JLabel tarlogo = new JLabel("   Tarea");
		tarlogo.setFont(new Font("Tahoma", Font.BOLD, 25));
		ImageIcon logotaricon = new ImageIcon(MainWindowTarea.class.getResource("/icons/tarea.png"));
		Image modlogotaricon = logotaricon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		toppanel.setLayout(new BorderLayout(0, 0));
		tarlogo.setIcon(new ImageIcon(modlogotaricon));
		toppanel.add(tarlogo, BorderLayout.WEST);
		
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
		
		JButton altabutton = new JButton("Alta Tarea");
		altabutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		altabutton.setHorizontalTextPosition(SwingConstants.CENTER);
		altabutton.setIcon(new ImageIcon(new ImageIcon(MainWindowTarea.class.getResource("/icons/generales/alta-removebg-preview.png")).getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		altabutton.setBackground(Color.WHITE);
		altabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //TODO
				Controlador.getInstance().update(Eventos.VistaAltaTarea, null);
				dispose();
			}
		});
		buttonpanel.setLayout(new GridLayout(0, 3, 0, 0));
		buttonpanel.add(altabutton);
		
		JButton bajabutton = new JButton("Baja Tarea");
		bajabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaBajaTarea, null);
				dispose();
			}
		});
		bajabutton.setHorizontalTextPosition(SwingConstants.CENTER);
		bajabutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		bajabutton.setIcon(new ImageIcon(new ImageIcon(MainWindowTarea.class.getResource("/icons/generales/baja-removebg-preview.png")).getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		bajabutton.setBackground(Color.WHITE);
		buttonpanel.add(bajabutton);
		
		JButton modbutton = new JButton("Modificar Tarea");
		modbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowTarea.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		modbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		modbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		modbutton.setBackground(Color.WHITE);
		modbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaModificarTarea, null);
				dispose();
			}
		});
		buttonpanel.add(modbutton);
		
		JButton listallbutton = new JButton("Listado de todas las tareas");
		listallbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowTarea.class.getResource("/icons/generales/listar_todos-removebg-preview.png")).getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		listallbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		listallbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listallbutton.setBackground(Color.WHITE);
		listallbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.ListarTareas, null);
				dispose();
			}
		});
		buttonpanel.add(listallbutton);
		
		JButton listidbutton = new JButton("Listado de tarea por ID"); 
		listidbutton.setIcon(new ImageIcon(new ImageIcon(MainWindowTarea.class.getResource("/icons/generales/listar_uno-removebg-preview.png")).getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH)));
		listidbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
		listidbutton.setHorizontalTextPosition(SwingConstants.CENTER);
		listidbutton.setBackground(Color.WHITE);
		listidbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.VistaMostrarTareasID, null);
				dispose();
			}
		});
		buttonpanel.add(listidbutton);

		
		
		
	}



	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.MainWindowTarea:
			setVisible(true);
			break;
		}
		
	}
}