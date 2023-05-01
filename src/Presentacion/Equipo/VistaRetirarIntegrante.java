
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

import Negocio.Equipo.TVinculacion;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

public class VistaRetirarIntegrante extends JFrame implements IGUI {
	
	private JPanel contentPane;
	private JTextField idequipotextfield;
	private JTextField idempleadotextfield;
	
	private boolean cerrar = true;
	
	public VistaRetirarIntegrante() {
		vRetirarIntegrante();
	}
	public void vRetirarIntegrante() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Retirar integrante de Equipo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaRetirarIntegrante.class.getResource("/icons/generales/baja-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("    Retirar integrante de Equipo");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaRetirarIntegrante.class.getResource("/icons/generales/baja-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel idequipolabel = new JLabel("ID Equipo:");
		idequipolabel.setBounds(88, 74, 299, 14);
		infopanel.add(idequipolabel);
		
		idequipotextfield = new JTextField();
		idequipotextfield.setBounds(158, 72, 215, 17);
		infopanel.add(idequipotextfield);
		idequipotextfield.setColumns(10);
		
		JLabel idempleadolabel = new JLabel("ID Empleado:");
		idempleadolabel.setBounds(73, 100, 64, 14);
		infopanel.add(idempleadolabel);
		
		idempleadotextfield = new JTextField();
		idempleadotextfield.setBounds(158, 102, 215, 17);
		infopanel.add(idempleadotextfield);
		idempleadotextfield.setColumns(10);
		
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
		TVinculacion tvin = new TVinculacion();
		tvin.setId_1(Integer.parseInt(idequipotextfield.getText()));
		tvin.setId_2(Integer.parseInt(idempleadotextfield.getText()));
		tvin.setActivo(false);
		Controlador.getInstance().update(Eventos.RetirarIntegrante, tvin);
		if (cerrar) 
			dispose();
		 else 
			cerrar = true;
	}


	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaRetirarIntegrante:
			setVisible(true);
			break;			
		case Eventos.RetirarIntegranteOk:
			JOptionPane.showMessageDialog(null, "Éxito Retirando Integrante");
			Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
			break;
		case Eventos.RetirarIntegranteNoOk:
			JOptionPane.showMessageDialog(null, "Error al Retirar");
			cerrar = false;
			break;
		}
	}
}