/**
 * 
 */
package Presentacion.Tareas;

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

import Negocio.Tareas.TTarea;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

public class VistaModificarTarea extends JFrame implements IGUI{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombretextfield;
	private JTextField equipotextfield;
	private JTextField productotextfield;
	private JTextField idtextfield;
	
	private boolean cerrar = true;
	
	public VistaModificarTarea() {
		vModificarTarea();
	}

	public void vModificarTarea() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Modificar Tarea");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaModificarTarea.class.getResource("/icons/generales/modificacion-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Modificar Tarea");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaModificarTarea.class.getResource("/icons/generales/modificacion-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
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
		productolabel.setBounds(75, 66, 56, 14);
		infopanel.add(productolabel);
		
		productotextfield = new JTextField();
		productotextfield.setColumns(10);
		productotextfield.setBounds(153, 64, 215, 17);
		infopanel.add(productotextfield);
		
		JButton okbutton = new JButton("Ok");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		okbutton.setBounds(141, 205, 90, 23);
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().update(Eventos.MainWindowTarea, e);				
				dispose();
			}
		});
		cancelbutton.setBounds(248, 205, 90, 23);
		infopanel.add(cancelbutton);
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(75, 91, 46, 14);
		infopanel.add(idlabel);
		
		idtextfield = new JTextField();
		idtextfield.setColumns(10);
		idtextfield.setBounds(153, 92, 215, 17);
		infopanel.add(idtextfield);
	}
	
	private void ok() {
		TTarea tarea = new TTarea();
		if (!idtextfield.getText().equals("")) 
			tarea.setIdTarea(Integer.parseInt(idtextfield.getText()));
		else
			tarea.setIdTarea(null);
		if (!nombretextfield.getText().equals("")) 
			tarea.setNombre(nombretextfield.getText());
		if (!equipotextfield.getText().equals("")) 
			tarea.setEquipo(Integer.parseInt(equipotextfield.getText()));
		if (!productotextfield.getText().equals("")) 
			tarea.setProducto(Integer.parseInt(productotextfield.getText()));
		Controlador.getInstance().update(Eventos.ModificarTarea, tarea);
		if (cerrar) 
			dispose();
		else
			cerrar = true;
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaModificarTarea:
			setVisible(true);
			break;
		case Eventos.ModificarTareaOK:
			JOptionPane.showMessageDialog(null, "Modificado con éxito");
			Controlador.getInstance().update(Eventos.MainWindowTarea, null);
			break;
		case Eventos.ModificarTareaNombreNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el Nombre ya existe en la base de datos");
			cerrar = false;
			break;
		case Eventos.ModificarTareaNoOK:
			JOptionPane.showMessageDialog(null, "Modificado ha fallado: el ID no existe en la base de datos");
			cerrar = false;
			break;
		}
	}
}