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

public abstract class FactoriaDAO{
	
	private static FactoriaDAOImp instance;


	public static FactoriaDAOImp getInstance() {
		if(instance == null) instance = new FactoriaDAOImp();
		
		return instance;
	}
	
	public abstract DAOEmpleado getDaoEmpleado();
	public abstract DAOEquipo getDaoEquipo();
	public abstract DAOCliente getDaoCliente();
	public abstract DAOFactura getDaoFactura();
	public abstract DAOProducto getDaoProducto();
	public abstract DAOTarea getDaoTarea();



}