package Presentacion.Cliente;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TDistribuidor;
import Negocio.Equipo.TEquipoDisenio;
import Presentacion.IGUI;
import Presentacion.Controlador.Controlador;
import Presentacion.Controlador.Eventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VistaAltaCliente extends JFrame implements IGUI {

	private JPanel contentPane;
	private JTextField nombretextfield;
	private JTextField direcciontextfield;
	private JTextField telefonotextfield;
	private JTextField ciftextfield;
	private JTextField emailtextfield;
	
	private boolean esDistribuidor = false;
	private boolean cerrar = true;
	
	public VistaAltaCliente() {
		vAltaCliente();
	}
	
	public void vAltaCliente() {
		return;
	}

	private void ok() {
		TCliente cliente;
		if (esDistribuidor) {
			cliente = new TDistribuidor();
			cliente.setNombre(nombretextfield.getText());
			cliente.setEmail(emailtextfield.getText());
			((TDistribuidor) cliente).setDireccion(direcciontextfield.getText());
			((TDistribuidor) cliente).setCIF(ciftextfield.getText());
		} else {
			cliente = new TParticular();
			cliente.setNombre(nombretextfield.getText());
			cliente.setEmail(emailtextfield.getText());
			((TParticular) cliente).settelefono(Integer.parseInt(telefonotextfield.getText()));
			((TParticular) cliente).setCIF(ciftextfield.getText());
			
		}
		Controlador.getInstance().update(Eventos.AltaEquipo, cliente);
		if (cerrar)
			dispose();
		else
			cerrar = true;
	}	

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.VistaAltaCliente:
			setVisible(true);
			break;
		}
	}
}