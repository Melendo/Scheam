package Presentacion.Factorias;

import Presentacion.IGUI;
import Presentacion.Cliente.MainWindowCliente;
import Presentacion.Cliente.VistaAltaCliente;
import Presentacion.Cliente.VistaBajaCliente;
import Presentacion.Cliente.VistaModificarCliente;
import Presentacion.Cliente.VistaMostrarClienteID;
import Presentacion.Cliente.VistaMostrarClientes;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.MainWindowEmpleado;
import Presentacion.Empleado.VistaAltaEmpleado;
import Presentacion.Empleado.VistaBajaEmpleado;
import Presentacion.Empleado.VistaFormMostrarEmpleadoID;
import Presentacion.Empleado.VistaListarEmpleado;
import Presentacion.Empleado.VistaListarIntegrantesEquipoId;
import Presentacion.Empleado.VistaModificarEmpleado;
import Presentacion.Empleado.VistaMostrarEmpleadoID;
import Presentacion.Equipo.MainWindowEquipo;
import Presentacion.Equipo.VistaAltaEquipo;
import Presentacion.Equipo.VistaBajaEquipo;
import Presentacion.Equipo.VistaModificarEquipo;
import Presentacion.Producto.MainWindowProducto;
import Presentacion.Producto.VistaAltaProducto;
import Presentacion.Producto.VistaBajaProducto;
import Presentacion.Producto.VistaCerrarProducto;
import Presentacion.Producto.VistaFormMostrarProductoID;
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
		case Eventos.VistaListarIntegrantesEquipo:
			System.out.println("Entrando a VistaListarIntegrantesEquipo - FactoriaVistasImp");
			return new VistaListarIntegrantesEquipoId();
		case Eventos.MainWindowEquipo:
			System.out.println("Entrando a MainWindowEquipo - FactoriaVistasImp");
			return new MainWindowEquipo();
		case Eventos.VistaAltaEquipo:
			System.out.println("Entrando a VistaAltaEquipo - FactoriaVistasImp");
			return new VistaAltaEquipo();
		case Eventos.VistaBajaEquipo:
			System.out.println("Entrando a VistaBajaEquipo - FactoriaVistasImp");
			return new VistaBajaEquipo();
		case Eventos.VistaModificarEquipo:
			System.out.println("Entrando a VistaModificarEquipo - FactoriaVistasImp");
			return new VistaModificarEquipo();
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
			return new VistaFormMostrarProductoID();
		case Eventos.VistaMostrarProductoID:
			System.out.println("Entrando a VistaMostrarProductoID - FactoriaVistasImp");
			return new VistaMostrarProductoID();
		case Eventos.VistaCerrarProducto:
			System.out.println("Entrando a VistaCerrarProducto - FactoriaVistasImp");
			return new VistaCerrarProducto();
		case Eventos.MainWindowCliente:// <----------------------------------------------------------------------------
			System.out.println("Entrando a MainWindowCliente - FactoriaVistasImp");
			return new MainWindowCliente();
		case Eventos.VistaAltaCliente:
			System.out.println("Entrando a VistaAltaCliente - FactoriaVistasImp");
			return new VistaAltaCliente();
		case Eventos.VistaBajaCliente:
			System.out.println("Entrando a VistaBajaCliente - FactoriaVistasImp");
			return new VistaBajaCliente();
		case Eventos.VistaListarCliente:
			System.out.println("Entrando a VistaListarProducto - FactoriaVistasImp");
			return new VistaMostrarClientes();
		case Eventos.VistaModificarCliente:
			System.out.println("Entrando a ModificarProducto - FactoriaVistasImp");
			return new VistaModificarCliente();
		case Eventos.VistaFormMostrarClienteID:
			System.out.println("Entrando a VistaFormMostrarProductoID - FactoriaVistasImp");
			return new VistaMostrarClienteID();
		case Eventos.VistaMostrarClienteID:
			System.out.println("Entrando a VistaMostrarProductoID - FactoriaVistasImp");
			return new VistaMostrarClienteID();	
		default:
			return null;
		}
	}
}