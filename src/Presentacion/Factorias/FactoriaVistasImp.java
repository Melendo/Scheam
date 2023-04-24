package Presentacion.Factorias;

import Presentacion.IGUI;
import Presentacion.Controlador.Eventos;
import Presentacion.Empleado.MainWindowEmpleado;
import Presentacion.Empleado.VistaAltaEmpleado;
import Presentacion.Empleado.VistaBajaEmpleado;
import Presentacion.Empleado.VistaListarEmpleado;
import Presentacion.Empleado.VistaModificarEmpleado;
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
		default:
			return null;
		}
	}
}