/**
 * 
 */
package Presentacion.Equipo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaBajaEmpleado;

public class VistaBajaEquipo extends JFrame implements IGUI{
	
	private JPanel contentPane;
	private JTextField idtextfield;
	
	private boolean cerrar = true;
	public VistaBajaEquipo() {
		vBajaEquipo();
	}
	public void vBajaEquipo() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Baja Equipo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaBajaEquipo.class.getResource("/icons/generales/baja-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Baja Equipo");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaBajaEmpleado.class.getResource("/icons/generales/baja-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(111, 94, 37, 14);
		infopanel.add(idlabel);
		
		idtextfield = new JTextField();
		idtextfield.setBounds(158, 92, 215, 17);
		infopanel.add(idtextfield);
		idtextfield.setColumns(10);
		
		JButton okbutton = new JButton("Ok");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		okbutton.setBounds(143, 144, 90, 23);
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
				dispose();
			}
		});
		cancelbutton.setBounds(250, 144, 90, 23);
		infopanel.add(cancelbutton);
	}
	
	private void ok() {
		Integer id_equipo = Integer.parseInt(idtextfield.getText());
		Controlador.getInstance().update(Eventos.BajaEquipo, id_equipo);
		if (cerrar) 
			dispose();
		 else 
			cerrar = true;
	}
	

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaBajaEquipo:
			setVisible(true);
			break;			
		case Eventos.BajaEquipoOK:
			JOptionPane.showMessageDialog(null, "Éxito dando de Baja");
			Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
			break;
		case Eventos.BajaEquipoNoOK:
			JOptionPane.showMessageDialog(null, "Error al dar de Baja");
			cerrar = false;
			break;
		case Eventos.BajaEquipoNoOK2:
			JOptionPane.showMessageDialog(null, "Error al dar de Baja. Equipo ya dado de Baja");
			cerrar = false;
			break;
		case Eventos.BajaEquipoNoOK3:
			JOptionPane.showMessageDialog(null, "Error al dar de Baja. Equipo con Empleados Vinculados");
			cerrar = false;
			break;
		case Eventos.BajaEquipoNoOK4:
			JOptionPane.showMessageDialog(null, "Error al dar de Baja. Equipo con Tareas pendientes");
			cerrar = false;
			break;
		}
	}
}