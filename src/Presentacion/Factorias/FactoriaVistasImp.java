package Presentacion.Factorias;

import Presentacion.IGUI;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.MainWindowEmpleado;
import Presentacion.Empleado.VistaAltaEmpleado;
import Presentacion.Empleado.VistaBajaEmpleado;
import Presentacion.Empleado.VistaFormMostrarEmpleadoID;
import Presentacion.Empleado.VistaListarEmpleado;
import Presentacion.Empleado.VistaModificarEmpleado;
import Presentacion.Empleado.VistaMostrarEmpleadoID;
import Presentacion.Equipo.MainWindowEquipo;
import Presentacion.Equipo.VistaAltaEquipo;
import Presentacion.Producto.MainWindowProducto;
import Presentacion.Producto.VistaAltaProducto;
import Presentacion.Producto.VistaBajaProducto;
import Presentacion.Producto.VistaListarProductos;
import Presentacion.Producto.VistaModificarProducto;
import Presentacion.Producto.VistaMostrarProductoID;
import Presentacion.VistaPrincipal.MainWindow;

public class FactoriaVistasImp extends FactoriaVistas {
	
	public FactoriaVistasImp() {}

	@Override
	public IGUI generateFrame(int event, Object object) {
		switch(event) {
		case Eventos.MainWindow:
			System.out.println("Entrando a MainWindow - FactoriaVistasImp");
			return new MainWindow();
		case Eventos.MainWindowEmpleado:
			System.out.println("Entrando a MainWindowEmpleado - FactoriaVistasImp");
			return new MainWindowEmpleado();
		case Eventos.VistaAltaEmpleado:
			System.out.println("Entrando a VistaAltaEmpleado - FactoriaVistasImp");
			return new VistaAltaEmpleado();
		case Eventos.VistaBajaEmpleado:
			System.out.println("Entrando a VistaBajaEmpleado - FactoriaVistasImp");
			return new VistaBajaEmpleado();
		case Eventos.VistaListarEmpleado:
			System.out.println("Entrando a VistaListarEmpleado - FactoriaVistasImp");
			return new VistaListarEmpleado();
		case Eventos.VistaModificarEmpleado:
			System.out.println("Entrando a ModificarEmpleado - FactoriaVistasImp");
			return new VistaModificarEmpleado();
		case Eventos.VistaFormMostrarEmpleadoID:
			System.out.println("Entrando a VistaFormMostrarEmpleadoID - FactoriaVistasImp");
			return new VistaFormMostrarEmpleadoID();
		case Eventos.VistaMostrarEmpleadoID:
			System.out.println("Entrando a VistaMostrarEmpleadoID - FactoriaVistasImp");
			return new VistaMostrarEmpleadoID();
		case Eventos.MainWindowEquipo:
			System.out.println("Entrando a MainWindowEquipo - FactoriaVistasImp");
			return new MainWindowEquipo();
		case Eventos.VistaAltaEquipo:
			System.out.println("Entrando a VistaAltaEquipo - FactoriaVistasImp");
			return new VistaAltaEquipo();
		case Eventos.MainWindowProducto:// <----------------------------------------------------------------------------
			System.out.println("Entrando a MainWindowProducto - FactoriaVistasImp");
			return new MainWindowProducto();
		case Eventos.VistaAltaProducto:
			System.out.println("Entrando a VistaAltaProducto - FactoriaVistasImp");
			return new VistaAltaProducto();
		case Eventos.VistaBajaProducto:
			System.out.println("Entrando a VistaBajaProducto - FactoriaVistasImp");
			return new VistaBajaProducto();
		case Eventos.VistaListarProducto:
			System.out.println("Entrando a VistaListarProducto - FactoriaVistasImp");
			return new VistaListarProductos();
		case Eventos.VistaModificarProducto:
			System.out.println("Entrando a ModificarProducto - FactoriaVistasImp");
			return new VistaModificarProducto();
		case Eventos.VistaFormMostrarProductoID:
			System.out.println("Entrando a VistaFormMostrarProductoID - FactoriaVistasImp");
			return new VistaMostrarProductoID();
		case Eventos.VistaMostrarProductoID:
			System.out.println("Entrando a VistaMostrarProductoID - FactoriaVistasImp");
			return new VistaMostrarProductoID();
			
		default:
			return null;
		}
	}
}