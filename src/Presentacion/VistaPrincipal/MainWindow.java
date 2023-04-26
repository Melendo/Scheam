/**
 * 
 */
package Presentacion.VistaPrincipal;

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame implements IGUI {
	
	public MainWindow() {
		vMainWindow();
	}
	
	public void vMainWindow() {
		setMinimumSize(new Dimension(1000, 800));
		getContentPane().setBackground(Color.WHITE);
		setTitle("Scheam");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/icons/logo.png")));
		setFont(new Font("Arial Nova", Font.PLAIN, 12));
		setBounds(100, 100, 1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		titlepanel.setBackground(Color.WHITE);
		getContentPane().add(titlepanel, BorderLayout.NORTH);
		
		JLabel logoimage = new JLabel("");
		logoimage.setToolTipText("Scheam Logo");
		logoimage.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/scheam_claro.png")));
		titlepanel.add(logoimage);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton clienteButton = new JButton("Cliente");
		clienteButton.setHorizontalTextPosition(SwingConstants.CENTER);
		clienteButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		clienteButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		clienteButton.setToolTipText("Abrir Cliente");
		clienteButton.setBackground(Color.WHITE);
		ImageIcon clienteimgicon = new ImageIcon(MainWindow.class.getResource("/icons/cliente.png"));
		Image modclienteimg = clienteimgicon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		clienteButton.setIcon(new ImageIcon(modclienteimg));
		//TODO actionlistener a mainwindowcliente
		buttonPanel.add(clienteButton);
		
		JButton empleadoButton = new JButton("Empleado");
		empleadoButton.setBackground(Color.WHITE);
		empleadoButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		empleadoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		empleadoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		empleadoButton.setToolTipText("Abrir Empleado");
		ImageIcon empleadoimgicon = new ImageIcon(MainWindow.class.getResource("/icons/empleado.png"));
		Image modempleadoimg = empleadoimgicon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		empleadoButton.setIcon(new ImageIcon(modempleadoimg));
		empleadoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				Controlador.getInstance().update(Eventos.MainWindowEmpleado, null);
				dispose();
			}
		});
		buttonPanel.add(empleadoButton);
		
		JButton equipoButton = new JButton("Equipo");
		equipoButton.setBackground(Color.WHITE);
		equipoButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		equipoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		equipoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		equipoButton.setToolTipText("Abrir Equipo");
		ImageIcon equipoimgicon = new ImageIcon(MainWindow.class.getResource("/icons/equipo.png"));
		Image modequipoimg = equipoimgicon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		equipoButton.setIcon(new ImageIcon(modequipoimg));
		equipoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
				dispose();
			}
		});
		buttonPanel.add(equipoButton);
		
		JButton productoButton = new JButton("Producto");
		productoButton.setBackground(Color.WHITE);
		productoButton.setToolTipText("Abrir Producto");
		productoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		productoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		productoButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ImageIcon productoimgicon = new ImageIcon(MainWindow.class.getResource("/icons/producto.png"));
		Image modproductoimg = productoimgicon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		productoButton.setIcon(new ImageIcon(modproductoimg));
		//TODO actionlistener a mainwindowproducto
		buttonPanel.add(productoButton);
		
		JButton facturaButton = new JButton("Factura y Carrito");
		facturaButton.setBackground(Color.WHITE);
		facturaButton.setToolTipText("Abrir Factura y Carrito");
		facturaButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		facturaButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		facturaButton.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon facturaimgicon = new ImageIcon(MainWindow.class.getResource("/icons/factura.png"));
		Image modfacturaimg = facturaimgicon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		facturaButton.setIcon(new ImageIcon(modfacturaimg));
		//TODO actionlistener a mainwindowfactura
		buttonPanel.add(facturaButton);
		
		JButton tareasButton = new JButton("Tareas");
		tareasButton.setBackground(Color.WHITE);
		tareasButton.setToolTipText("Abrir Tareas");
		tareasButton.setHorizontalTextPosition(SwingConstants.CENTER);
		tareasButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tareasButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		ImageIcon tareasimgicon = new ImageIcon(MainWindow.class.getResource("/icons/tarea.png"));
		Image modtareasimg = tareasimgicon.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		tareasButton.setIcon(new ImageIcon(modtareasimg));
		//TODO actionlistener a mainwindowtareas
		buttonPanel.add(tareasButton);
		
		setVisible(false);
	}

	@Override
	public void update(int event, Object object) {
		switch (event) {
		case Eventos.MainWindow:
			setVisible(true);
			break;
		}
	}
}