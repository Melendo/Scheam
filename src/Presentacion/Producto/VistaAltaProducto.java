/**
 * 
 */
package Presentacion.Producto;

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

import Negocio.Producto.TProducto;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.VistaAltaEmpleado;


public class VistaAltaProducto extends JFrame implements IGUI, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField NoTF;
	private JTextField FeTF;
	private JTextField PrTF;
	private JTextField GeTF;
	private JTextField PeTF;
	private JTextField StTF;
	
	private boolean cerrar = true;
	
	public VistaAltaProducto() {
		vAltaProducto();
	}

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
		
		NoTF = new JTextField();
		NoTF.setColumns(10);
		NoTF.setBounds(153, 11, 215, 17);
		infopanel.add(NoTF);
		
		JLabel fecchalabel = new JLabel("Fecha de lanzamiento: ");
		fecchalabel.setBounds(10, 39, 111, 14);
		infopanel.add(fecchalabel);
		
		FeTF = new JTextField();
		FeTF.setColumns(10);
		FeTF.setBounds(153, 36, 215, 17);
		infopanel.add(FeTF);
		
		JLabel preciolabel = new JLabel("Precio:");
		preciolabel.setBounds(85, 66, 46, 14);
		infopanel.add(preciolabel);
		
		PrTF = new JTextField();
		PrTF.setColumns(10);
		PrTF.setBounds(153, 63, 215, 17);
		infopanel.add(PrTF);
		
		JLabel generolabel = new JLabel("Genero:");
		generolabel.setBounds(75, 91, 46, 14);
		infopanel.add(generolabel);
		
		GeTF = new JTextField();
		GeTF.setColumns(10);
		GeTF.setBounds(153, 91, 215, 17);
		infopanel.add(GeTF);
		
		JLabel pegilabel = new JLabel("PEGI:");
		pegilabel.setBounds(85, 118, 56, 14);
		infopanel.add(pegilabel);
		
		PeTF = new JTextField();
		PeTF.setColumns(10);
		PeTF.setBounds(153, 116, 215, 17);
		infopanel.add(PeTF);
		
		JLabel stocklabel = new JLabel("Stock:");
		stocklabel.setBounds(85, 147, 46, 14);
		infopanel.add(stocklabel);
		
		StTF = new JTextField();
		StTF.setColumns(10);
		StTF.setBounds(153, 144, 215, 17);
		infopanel.add(StTF);
		
		JButton okbutton = new JButton("Ok");
		
		okbutton.setBounds(142, 188, 90, 23);
		okbutton.addActionListener((e)->{
			ok();
		});
		infopanel.add(okbutton);
		
		JButton cancelbutton = new JButton("Cancelar");
		cancelbutton.setBounds(249, 188, 90, 23);
		cancelbutton.addActionListener((e)->{
			Controlador.getInstance().update(Eventos.MainWindowProducto, null);
			dispose();
		});
		infopanel.add(cancelbutton);
	}

	private void ok() {
		TProducto producto = new TProducto();
		producto.setNombre(NoTF.getText());
		producto.setFechalanzamiento(Integer.parseInt(FeTF.getText()));
		producto.setPrecio(Double.parseDouble(PrTF.getText()));
		producto.setGenero(GeTF.getText());
		producto.setPEGI(Integer.parseInt(PeTF.getText()));
		producto.setStock(Integer.parseInt(StTF.getText()));//activo y terminado en el DAO
		
		Controlador.getInstance().update(Eventos.AltaProducto, producto);
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