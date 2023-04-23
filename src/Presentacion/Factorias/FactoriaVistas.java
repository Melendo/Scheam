/**
 * 
 */
package Presentacion.Factorias;

import Presentacion.IGUI;
import Presentacion.VistaPrincipal.MainWindow;

public abstract class FactoriaVistas {

	private static FactoriaVistas instance;
	
	public static FactoriaVistas getInstance() {
		if (instance == null) {
			instance = new FactoriaVistasImp();
		}
		return instance;
	}

	public IGUI generateFrame() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
	
	public abstract IGUI generateMainWindow();
}