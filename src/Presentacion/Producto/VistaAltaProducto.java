/**
 * 
 */
package Presentacion.Producto;

import javax.swing.JFrame;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaAltaEmpleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author 34601
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class VistaAltaProducto extends JFrame implements IGUI, ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	private boolean cerrar = true;
	
	public VistaAltaProducto() {
		vAltaProducto();
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void vAltaProducto() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Alta Producto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaAltaProducto.class.getResource("/icons/generales/alta-removebg-preview.png")));
		
		JPanel titlepanel = new JPanel();
		getContentPane().add(titlepanel, BorderLayout.NORTH);
		
		JLabel lblAltaProducto = new JLabel("      Alta Producto");
		lblAltaProducto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAltaProducto.setIcon(new ImageIcon(new ImageIcon(VistaAltaEmpleado.class.getResource("/icons/generales/alta-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
		titlepanel.add(lblAltaProducto);
		
		JPanel infopanel = new JPanel();
		infopanel.setLayout(null);
		getContentPane().add(infopanel, BorderLayout.CENTER);
		
		JLabel nombrelabel = new JLabel("Nombre:");
		nombrelabel.setBounds(75, 14, 56, 14);
		infopanel.add(nombrelabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(153, 11, 215, 17);
		infopanel.add(textField);
		
		JLabel apellidoslabel = new JLabel("Fecha de lanzamiento: ");
		apellidoslabel.setBounds(10, 39, 111, 14);
		infopanel.add(apellidoslabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 36, 215, 17);
		infopanel.add(textField_1);
		
		JLabel dnilabel = new JLabel("Precio:");
		dnilabel.setBounds(85, 66, 46, 14);
		infopanel.add(dnilabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(153, 63, 215, 17);
		infopanel.add(textField_2);
		
		JLabel emaillabel = new JLabel("Genero:");
		emaillabel.setBounds(75, 91, 46, 14);
		infopanel.add(emaillabel);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(153, 91, 215, 17);
		infopanel.add(textField_3);
		
		JLabel telefonolabel = new JLabel("PEGI:");
		telefonolabel.setBounds(75, 119, 56, 14);
		infopanel.add(telefonolabel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(153, 116, 215, 17);
		infopanel.add(textField_4);
		
		JLabel sueldolabel = new JLabel("Stock:");
		sueldolabel.setBounds(85, 147, 46, 14);
		infopanel.add(sueldolabel);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(153, 144, 215, 17);
		infopanel.add(textField_5);
		
		JButton okbutton = new JButton("Ok");
		okbutton.setBounds(142, 188, 90, 23);
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.setBounds(249, 188, 90, 23);
		infopanel.add(cancelbutton);
	}

	/** 
	* (non-Javadoc)
	* @see IGUI#update()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see ActionListener#actionPerformed(ActionEvent e)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void actionPerformed(ActionEvent e) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaAltaProducto:
			setVisible(true);
			break;
		case Eventos.AltaProductoNoOK:
	        JOptionPane.showMessageDialog(null, "Error al dar de Alta");
	        cerrar = false;
	        break;
		case Eventos.AltaProductoOK:
			JOptionPane.showMessageDialog(null, "Éxito dando de Alta");
			Controlador.getInstance().update(Eventos.MainWindowProducto, null);
			break;
		case Eventos.AltaProductoOKReactivar:
			JOptionPane.showMessageDialog(null, "Éxito dando de Alta. Se ha reactivado el Producto.");
			Controlador.getInstance().update(Eventos.MainWindowProducto, null);
			break;
		}
		
	}
}