/**
 * 
 */
package Presentacion.Cliente;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import Presentacion.IGUI;
import Presentacion.Controlador.Eventos;

import java.awt.event.ActionEvent;

public class MainWindowCliente extends JFrame implements ActionListener, IGUI {

	public void vMainWindowCliente() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void actionPerformed(ActionEvent e) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void update(int event, Object object) {
		switch(event) {
		case Eventos.MainWindowEmpleado:
			setVisible(true);
			break;
		}		
	}
}