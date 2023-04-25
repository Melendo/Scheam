
package Presentacion.Controlador;

import java.util.Set;

import Negocio.Empleado.TEmpleado;
import Negocio.Factorias.FactoriaSA;
import Presentacion.IGUI;
import Presentacion.Factorias.FactoriaVistas;

public class ControladorImp extends Controlador {
	
	private IGUI gui;

    public void update(int event, Object objeto) {
    	int res;
    	
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
        	res = FactoriaSA.getInstance().getSAEmpleado().altaEmpleado((TEmpleado) objeto);
        	if (res == -1) gui.update(Eventos.AltaEmpleadoNoOK, null); 
        	else if (res == 2) gui.update(Eventos.AltaEmpleadoOKReactivar, null);
        	else gui.update(Eventos.AltaEmpleadoOK, null);
        	break;
        case Eventos.VistaBajaEmpleado:
        	System.out.println("Entrando a VistaBajaEmpleado - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
        	break;
        case Eventos.BajaEmpleado:
        	System.out.println("Entrando a BajaEmpleado - Controlador");
        	res = FactoriaSA.getInstance().getSAEmpleado().bajaEmpleado((Integer) objeto);
        	if (res == -1) gui.update(Eventos.BajaEmpleadoNoOK, null);
        	else if(res == -2) gui.update(Eventos.BajaEmpleadoNoOK2, null);
        	else gui.update(Eventos.BajaEmpleadoOK, objeto);
        	break;
        case Eventos.ListarEmpleado:
        	System.out.println("Entrando a ListarEmpleados - Controlador");
        	Set<TEmpleado> lista = FactoriaSA.getInstance().getSAEmpleado().listarEmpleados();
        	gui = FactoriaVistas.getInstance().generateFrame(Eventos.VistaListarEmpleado, null);
        	gui.update(event, lista);
        	gui.update(Eventos.VistaListarEmpleado, null);
        	break;
        case Eventos.VistaModificarEmpleado:
        	System.out.println("Entrando a VistaModificarEmpleados - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
        	break;
        case Eventos.ModificarEmpleado:
        	System.out.println("Entrando a ModificarEmpleados - Controlador");
        	res = FactoriaSA.getInstance().getSAEmpleado().modificarEmpleado((TEmpleado) objeto);
        	if (res == -1) gui.update(Eventos.ModificarEmpleadoNoOK, null);
        	else if (res == -2) gui.update(Eventos.ModificarEmpleadoDNINoOK, null);
        	else gui.update(Eventos.ModificarEmpleadoOK, null);
        	break;
        }
    }
}