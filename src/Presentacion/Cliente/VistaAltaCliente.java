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
			((TDistribuidor) cliente).setDireccion(direcciontextfield.getText());
			
		} else {
			cliente = new TParticular();
			cliente.setNombre(nombretextfield.getText());
			//((TParticular) cliente).setTelefono(telefonotextfield.getText());
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