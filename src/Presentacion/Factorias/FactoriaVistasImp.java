
package Presentacion.Factorias;

import Presentacion.IGUI;
import Presentacion.VistaPrincipal.MainWindow;

public class FactoriaVistasImp extends FactoriaVistas {
	public FactoriaVistasImp() {
		
	}
	
	public IGUI generateMainWindow() {
		return new MainWindow();
	}
}