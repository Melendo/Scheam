
package Presentacion.Controlador;

import java.util.Set;

import Negocio.Empleado.TEmpleado;
import Negocio.Equipo.TEquipo;
import Negocio.Factorias.FactoriaSA;
import Negocio.Producto.TProducto;
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
        case Eventos.VistaFormMostrarEmpleadoID:
        	System.out.println("Entrando a VistaFormMostrarEmpleadoID - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event,null);
        	break;
        case Eventos.VistaMostrarEmpleadoID:
        	System.out.println("Entrando a VistaMostrarEmpleadoID - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
        	break;
        case Eventos.MostrarEmpleadoID:
        	System.out.println("Entrando a MostrarEmpleadoID - Controlador");
        	TEmpleado emp = FactoriaSA.getInstance().getSAEmpleado().mostrarEmpleadoID((int) objeto);
        	if(emp.getIdEmpleado() == -1) {
        		gui = FactoriaVistas.getInstance().generateFrame(Eventos.VistaMostrarEmpleadoID, null);
        		gui.update(Eventos.MostrarEmpleadoIDNoOK, null);
        	}
        	else {
            	gui = FactoriaVistas.getInstance().generateFrame(Eventos.VistaMostrarEmpleadoID, null);
	        	gui.update(event,  emp);
	        	gui.update(Eventos.VistaMostrarEmpleadoID, null);
        	}
        	break;
        case Eventos.MainWindowEquipo:
        	System.out.println("Entrando a MainWindowEquipo - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
        	break;
        case Eventos.VistaAltaEquipo:
        	System.out.println("Entrando a VistaAltaEquipo - Controlador");
        	gui = FactoriaVistas.getInstance().generateFrame(event, null);
        	gui.update(event, null);
        	break;
        case Eventos.AltaEquipo:
        	System.out.println("Entrando a AltaEquipo - Controlador");
        	res = FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipo) objeto);
        	if (res == -1) gui.update(Eventos.AltaEquipoNoOK, null); 
        	else if (res == 2) gui.update(Eventos.AltaEquipoOKReactivar, null);
        	else gui.update(Eventos.AltaEquipoOK, null);
        	break;
        //TODO
	    case Eventos.MainWindowProducto:
	    	System.out.println("Entrando a MainWindowProductoOpen - Controlador");
	    	gui = FactoriaVistas.getInstance().generateFrame(event, null);
	    	gui.update(event, null);
	        break;
	    case Eventos.VistaAltaProducto:
	    	System.out.println("Entrando a VistaAltaProducto - Controlador");
	    	gui = FactoriaVistas.getInstance().generateFrame(event, null);
	    	gui.update(event, null);
	        break;
	    case Eventos.AltaProducto:
	    	System.out.println("Entrando a AltaProducto - Controlador");
	    	res = FactoriaSA.getInstance().getSAProducto().altaProducto((TProducto) objeto);
	    	if (res == -1) gui.update(Eventos.AltaProductoNoOK, null); 
	    	else if (res == 2) gui.update(Eventos.AltaProductoOKReactivar, null);
	    	else gui.update(Eventos.AltaProductoOK, null);
	    	break;
	    case Eventos.VistaBajaProducto:
	    	System.out.println("Entrando a VistaBajaProducto - Controlador");
	    	gui = FactoriaVistas.getInstance().generateFrame(event, null);
	    	gui.update(event, null);
	    	break;
	    case Eventos.BajaProducto:
	    	System.out.println("Entrando a BajaProducto - Controlador");
	    	res = FactoriaSA.getInstance().getSAProducto().bajaProducto((Integer) objeto);
	    	if (res == -1) gui.update(Eventos.BajaProductoNoOK, null);
	    	else if(res == -2) gui.update(Eventos.BajaProductoNoOK2, null);
	    	else gui.update(Eventos.BajaProductoOK, objeto);
	    	break;
	    case Eventos.ListarProducto:
	    	System.out.println("Entrando a ListarProductos - Controlador");
	    	Set<TProducto> listaPr = FactoriaSA.getInstance().getSAProducto().listarProductos();
	    	gui = FactoriaVistas.getInstance().generateFrame(Eventos.VistaListarProducto, null);
	    	gui.update(event, listaPr);
	    	gui.update(Eventos.VistaListarProducto, null);
	    	break;
	    case Eventos.VistaModificarProducto:
	    	System.out.println("Entrando a VistaModificarProductos - Controlador");
	    	gui = FactoriaVistas.getInstance().generateFrame(event, null);
	    	gui.update(event, null);
	    	break;
	    case Eventos.ModificarProducto:
	    	System.out.println("Entrando a ModificarProductos - Controlador");
	    	res = FactoriaSA.getInstance().getSAProducto().modificarProducto((TProducto) objeto);
	    	if (res == -1) gui.update(Eventos.ModificarProductoNoOK, null);
	    	else if (res == -2) gui.update(Eventos.ModificarProductoNombreNoOK, null);
	    	else if (res == -3) gui.update(Eventos.ModificarProductoActivoNoOK, null);
	    	else gui.update(Eventos.ModificarProductoOK, null);
	    	break;
	    case Eventos.VistaFormMostrarProductoID:
	    	System.out.println("Entrando a VistaFormMostrarProductoID - Controlador");
	    	gui = FactoriaVistas.getInstance().generateFrame(event, null);
	    	gui.update(event,null);
	    	break;
	    case Eventos.VistaMostrarProductoID:
	    	System.out.println("Entrando a VistaMostrarProductoID - Controlador");
	    	gui = FactoriaVistas.getInstance().generateFrame(event, null);
	    	gui.update(event, null);
	    	break;
	    case Eventos.MostrarProductoID:
	    	System.out.println("Entrando a MostrarProductoID - Controlador");
	    	TProducto pro = FactoriaSA.getInstance().getSAProducto().mostrarProductoID((int) objeto);
	    	if(pro.getIdproyecto() == -1) {
	    		gui = FactoriaVistas.getInstance().generateFrame(Eventos.VistaMostrarProductoID, null);
	    		gui.update(Eventos.MostrarProductoIDNoOK, null);
	    	}
	    	else {
	        	gui = FactoriaVistas.getInstance().generateFrame(Eventos.VistaMostrarProductoID, null);
	        	gui.update(event,  pro);
	        	gui.update(Eventos.VistaMostrarProductoID, null);
	    	}
	    	break;
	    }
    }
}