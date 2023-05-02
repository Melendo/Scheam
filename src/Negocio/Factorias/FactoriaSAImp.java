/**
 * 
 */
package Negocio.Factorias;

import Negocio.Cliente.SACliente;
import Negocio.Empleado.SAEmpleado;
import Negocio.Equipo.SAEquipo;
import Negocio.Factura.SAFactura;
import Negocio.Producto.SAProducto;
import Negocio.Tareas.SATarea;

public class FactoriaSAImp extends FactoriaSA {

	@Override
	public SAEmpleado getSAEmpleado() {
		return new SAEmpleado();
	}

	@Override
	public SACliente getSACliente() {
		return new SACliente();
	}

	@Override
	public SAEquipo getSAEquipo() {
		return new SAEquipo();
	}

	@Override
	public SAFactura getSAFactura() {
		return new SAFactura();
	}

	@Override
	public SAProducto getSAProducto() {
		return new SAProducto();
	}

	@Override
	public SATarea getSATarea() {
		return new SATarea();
	}

}