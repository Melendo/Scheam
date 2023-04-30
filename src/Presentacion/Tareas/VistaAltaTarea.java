/**
 * 
 */
package Presentacion.Tareas;

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
import Presentacion.Empleado.VistaAltaEmpleado;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class VistaAltaTarea extends JFrame implements IGUI{

	private JPanel contentPane;
	private JTextField nombretextfield;
	private JTextField equipotextfield;
	private JTextField productotextfield;
	
	private boolean cerrar = true;
	
	public VistaAltaTarea() {
		vAltaTarea();
	}

	public void vAltaTarea() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Alta Tarea");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaAltaTarea.class.getResource("/icons/generales/alta-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Alta Tarea");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaAltaTarea.class.getResource("/icons/generales/alta-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
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
		
		JLabel equipolabel = new JLabel("Equipo: ");
		equipolabel.setBounds(74, 39, 69, 14);
		infopanel.add(equipolabel);
		
		equipotextfield = new JTextField();
		equipotextfield.setColumns(10);
		equipotextfield.setBounds(153, 36, 215, 17);
		infopanel.add(equipotextfield);
		
		JLabel productolabel = new JLabel("Producto:");
		productolabel.setBounds(98, 66, 33, 14);
		infopanel.add(productolabel);
		
		productotextfield = new JTextField();
		productotextfield.setColumns(10);
		productotextfield.setBounds(153, 144, 215, 17);
		infopanel.add(productotextfield);
		
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
				Controlador.getInstance().update(Eventos.MainWindowTarea, null);
				dispose();
			}
		});
		cancelbutton.setBounds(249, 188, 90, 23);
		infopanel.add(cancelbutton);
		
	}
	
	private void ok() {
		TTarea tareas = new TTarea();
		tareas.setNombre(nombretextfield.getText());
		tareas.setEquipo(Integer.parseInt(equipotextfield.getText()));
		tareas.setProducto(Integer.parseInt(productotextfield.getText()));
		Controlador.getInstance().update(Eventos.AltaTarea, tareas);
		if (cerrar) 
			dispose();
		else
			cerrar = true;
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaAltaTarea:
			setVisible(true);
			break;
		case Eventos.AltaTareaNoOK:
	        JOptionPane.showMessageDialog(null, "Error al dar de Alta");
	        cerrar = false;
	        break;
		case Eventos.AltaTareaOK:
			JOptionPane.showMessageDialog(null, "Éxito dando de Alta");
			Controlador.getInstance().update(Eventos.MainWindowTarea, null);
			break;
		case Eventos.AltaTareaOKReactivar:
			JOptionPane.showMessageDialog(null, "Éxito dando de Alta. Se ha reactivado la Tarea.");
			Controlador.getInstance().update(Eventos.MainWindowTarea, null);
			break;
		}
	}
}