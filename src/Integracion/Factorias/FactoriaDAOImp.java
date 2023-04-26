/**
 * 
 */
package Integracion.Factorias;

import Integracion.Empleado.DAOEmpleado;
import Integracion.Cliente.DAOCliente;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOFactura getDaoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOProducto getDaoProducto() {
		return new DAOProducto();
	}

	@Override
	public DAOTarea getDaoTarea() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}