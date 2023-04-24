
package Presentacion.Controlador;

import Negocio.Empleado.TEmpleado;
import Negocio.Factorias.FactoriaSA;
import Presentacion.IGUI;
import Presentacion.Factorias.FactoriaVistas;

public class ControladorImp extends Controlador {
	
	private IGUI gui;

    public void update(int event, Object objeto) {
    	
        switch (event){
        case Eventos.MainWindow:
        	System.out.println("Entrando a MainWindowOpen - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
        	break;
        case Eventos.MainWindowEmpleado:
        	System.out.println("Entrando a MainWindowEmpleadoOpen - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
            break;
        case Eventos.VistaAltaEmpleado:
        	System.out.println("Entrando a VistaAltaEmpleado - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
            break;
        case Eventos.AltaEmpleado:
        	System.out.println("Entrando a AltaEmpleado - Controlador");
        	int res = FactoriaSA.getInstance().getSAEmpleado().altaEmpleado((TEmpleado) objeto);
        	if (res == -1) gui.update(Eventos.VistaAltaEmpleadoNoOK, null); 
        	else gui.update(Eventos.VistaAltaEmpleadoOK, null);
        }
    }
}