package Negocio.Factorias;

import Negocio.Cliente.SACliente;
import Negocio.Empleado.SAEmpleado;
import Negocio.Equipo.SAEquipo;
import Negocio.Factura.SAFactura;
import Negocio.Producto.SAProducto;
import Negocio.Tareas.SATarea;

public abstract class FactoriaSA {

	private static FactoriaSA instance;

	public static FactoriaSA getInstance() {
		if (instance == null) instance = new FactoriaSAImp();
		return instance;
	}
	
	public abstract SAEmpleado getSAEmpleado();
	public abstract SACliente getSACliente();
	public abstract SAEquipo getSAEquipo();
	public abstract SAFactura getSAFactura();
	public abstract SAProducto getSAProducto();
	public abstract SATarea getSATarea();
}