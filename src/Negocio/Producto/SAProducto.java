package Negocio.Producto;

import java.util.Set;

import Integracion.Equipo.DAOEquipo;
import Integracion.Factorias.FactoriaDAOImp;
import Integracion.Producto.DAOProducto;
import Negocio.Empleado.TEmpleado;

public class SAProducto implements ISAProducto {

	public Integer altaProducto(TProducto producto) {
		
		System.out.println("Intentando altaProducto - SAProducto");
		TProducto emp = FactoriaDAOImp.getInstance().getDaoProducto().readById(producto.getIdproyecto());

		if (emp.getIdproyecto() == -1) {
			System.out.println("altaProducto Realizado (creado) - SAProducto");
			return FactoriaDAOImp.getInstance().getDaoProducto().create(producto);
		} else {
			if (emp.getActivo()) {
				System.out.println("altaProducto No Realizado (existe y activo) - SAProducto");
				return -1;
			} else {
				producto.setActivo(true);
				producto.setIdproyecto(emp.getIdproyecto());
				System.out.println("altaProducto Realizado (reactivado) - SAProducto");
				FactoriaDAOImp.getInstance().getDaoProducto().modify(producto);
				return 2;
			}
		}
	}

	public Integer bajaProducto(Integer IDProducto) {
		
		System.out.println("Intentando bajaProducto - SAProducto");
		TProducto emp = FactoriaDAOImp.getInstance().getDaoProducto().readById(IDProducto);

		if (emp.getIdproyecto() == -1) {
			System.out.println("bajaProducto No Realizado (no exite) - SAProducto");
			return -1;
		}
		
		if(emp.getActivo()) {
			System.out.println("bajaProducto Realizado - SAProducto");
			return FactoriaDAOImp.getInstance().getDaoProducto().delete(IDProducto);
		} else{
			return -2;
		}
	}

	public Integer modificarProducto(TProducto producto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TProducto> listarProductos() {
		Set<TProducto> lista = FactoriaDAOImp.getInstance().getDaoProducto().readAll();
		return lista;
	}

	public TProducto mostrarProductoID(Integer IDProducto) {
		TProducto emp = FactoriaDAOImp.getInstance().getDaoProducto().readById(IDProducto);
		if (emp.getIdproyecto() != -1)
			return emp;
		else { 
			emp.setIdproyecto(-1);
			return emp;
		}
	}

	public Integer cerrarProducto(Integer IDProducto) {
		//TODO
		return null;
	}
}