/**
 * 
 */
package Presentacion.Producto;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaBajaEmpleado;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author 34601
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class VistaCerrarProducto extends JFrame implements IGUI, ActionListener {

	private JPanel contentPane;
	private JTextField idtextfield;
	
	private boolean cerrar = true;
	
	public VistaCerrarProducto() {
		vCerrarProducto();
	}
	
	public void vCerrarProducto() {
		setMinimumSize(new Dimension(500, 360));
		setTitle("Cerrar Producto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaBajaEmpleado.class.getResource("/icons/productos/cerrar_producto-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel titlepanel = new JPanel();
		contentPane.add(titlepanel, BorderLayout.NORTH);
		
		JLabel logo = new JLabel("      Cerrar Producto");
		logo.setFont(new Font("Tahoma", Font.BOLD, 25));
		logo.setIcon(new ImageIcon(new ImageIcon(VistaBajaEmpleado.class.getResource("/icons/productos/cerrar_producto-removebg-preview.png")).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));
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
				Controlador.getInstance().update(Eventos.MainWindowProducto, null);
				dispose();
			}
		});
		cancelbutton.setBounds(250, 144, 90, 23);
		infopanel.add(cancelbutton);
	}

	public void ok() {
		Integer id_proyecto = Integer.parseInt(idtextfield.getText());
		Controlador.getInstance().update(Eventos.CerrarProducto, id_proyecto);
		if (cerrar) 
			dispose();
		 else 
			cerrar = true;
	}
	
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
		// TODO Auto-generated method stub
		
	}
}