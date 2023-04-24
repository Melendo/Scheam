/**
 * 
 */
package Presentacion.Factorias;

import Presentacion.IGUI;

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