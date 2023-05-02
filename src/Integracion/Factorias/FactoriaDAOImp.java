/**
 * 
 */
package Integracion.Factorias;

import Integracion.Cliente.DAOCliente;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Equipo.DAOEquipo;
import Integracion.Factura.DAOFactura;
import Integracion.Producto.DAOProducto;
import Integracion.Tareas.DAOTarea;

public class FactoriaDAOImp extends FactoriaDAO {

	@Override
	public DAOEmpleado getDaoEmpleado() {
		return new DAOEmpleado();
	}

	@Override
	public DAOEquipo getDaoEquipo() {
		return new DAOEquipo();
	}

	@Override
	public DAOCliente getDaoCliente() {
		return new DAOCliente();
	}

	@Override
	public DAOFactura getDaoFactura() {
		return new DAOFactura();
	}

	@Override
	public DAOProducto getDaoProducto() {
		return new DAOProducto();
	}

	@Override
	public DAOTarea getDaoTarea() {
		return new DAOTarea();
	}

}