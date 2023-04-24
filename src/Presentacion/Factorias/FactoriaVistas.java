/**
 * 
 */
package Presentacion.Factorias;

import Presentacion.IGUI;
import Presentacion.Controlador.Eventos;
import Presentacion.VistaPrincipal.MainWindow;

public abstract class FactoriaVistas {

	private static FactoriaVistas instance;
	
	public static FactoriaVistas getInstance() {
		if (instance == null) {
			instance = new FactoriaVistasImp();
		}
		return instance;
	}

	public abstract IGUI generateFrame(int event, Object object);
	
}