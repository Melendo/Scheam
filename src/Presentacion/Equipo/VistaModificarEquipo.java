
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaModificarEmpleado;

public class VistaModificarEquipo extends JFrame implements IGUI {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField IdEquipo;
	private JTextField especializadatextfield;


	
	private boolean cerrar = true;
	private boolean esDesarrollo = true;
	
	public VistaModificarEquipo() {
		vModificarEquipo();
	}
	
	public void vModificarEquipo() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Modificar cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaModificarEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Modificar Cliente");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaModificarEmpleado.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(logo);
		
		JPanel infopanel = new JPanel();
		contentPane.add(infopanel, BorderLayout.CENTER);
		infopanel.setLayout(null);
		
		JLabel tipoequipolabel = new JLabel("Elige el tipo de equipo:");
		tipoequipolabel.setBounds(78, 37, 130, 14);
		infopanel.add(tipoequipolabel);
		
		
		JLabel nombrelabel = new JLabel("Nombre:");
		nombrelabel.setBounds(122, 79, 130, 15);
		infopanel.add(nombrelabel);
		
		nombre = new JTextField();
		nombre.setBounds(183, 79, 215, 17);
		infopanel.add(nombre);
		nombre.setColumns(10);
		
		JLabel diseniolabel = new JLabel("Campo de Diseño:");
		diseniolabel.setBounds(67, 106, 130, 14);
		infopanel.add(diseniolabel);
		
		especializadatextfield = new JTextField();
		especializadatextfield.setColumns(10);
		especializadatextfield.setBounds(183, 104, 215, 17);
		infopanel.add(especializadatextfield);
		
		JLabel desarrollolabel = new JLabel("Campo de Desarrollo:");
		desarrollolabel.setBounds(51, 106, 127, 14);
		desarrollolabel.setVisible(false);
		infopanel.add(desarrollolabel);
		
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
				Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
				dispose();
			}
		});
		cancelbutton.setBounds(249, 188, 90, 23);
		infopanel.add(cancelbutton);
		
		JSpinner fieldspinner = new JSpinner();
		fieldspinner.setModel(new SpinnerListModel(new String[] {"Equipo de Dise\u00F1o", "Equipo de Desarrollo"}));
		fieldspinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("Selected equipo: " + fieldspinner.getValue().toString());
				if (fieldspinner.getValue().toString().equals("Equipo de Desarrollo"))
					esDesarrollo = true;
				else
					esDesarrollo = false;
				
				if (esDesarrollo) {
					desarrollolabel.setVisible(true);
					diseniolabel.setVisible(false);
				}
				else {
					desarrollolabel.setVisible(false);
					diseniolabel.setVisible(true);
				}
			}
		});
		fieldspinner.setBounds(211, 34, 173, 20);
		infopanel.add(fieldspinner);
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(155, 132, 46, 14);
		infopanel.add(idlabel);
		
		IdEquipo = new JTextField();
		IdEquipo.setColumns(10);
		IdEquipo.setBounds(183, 132, 215, 17);
		infopanel.add(IdEquipo);
	}
	
	private void ok() {
		TEquipo equipo;
		if (esDesarrollo) {
			equipo = new TEquipoDesarrollo();
			equipo.setNombre(nombre.getText());
			equipo.setIdEquipo(Integer.parseInt(IdEquipo.getText()));
			((TEquipoDesarrollo) equipo).setTecnologia(especializadatextfield.getText());
			
		} else {
			equipo = new TEquipoDisenio();
			equipo.setNombre(nombre.getText());
			equipo.setIdEquipo(Integer.parseInt(IdEquipo.getText()));
			((TEquipoDisenio) equipo).setCampoDisenio(especializadatextfield.getText());
		}
		Controlador.getInstance().update(Eventos.ModificarEquipo, equipo);
		if (cerrar)
			dispose();
		else
			cerrar = true;

	}
	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaModificarEquipo:
			setVisible(true);
			break;
		case Eventos.ModificarEquipoOK:
			JOptionPane.showMessageDialog(null, "Modificado con éxito");
			Controlador.getInstance().update(Eventos.MainWindowEquipo, null);
			break;
		case Eventos.ModificarEquipoNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el ID no existe en la base de datos");
			cerrar = false;
			break;
		case Eventos.ModificarEquipoNombreNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el Nombre ya existe en la base de datos");
			cerrar = false;
			break;
		}			
	}

}