package Negocio.Producto;

import java.util.Set;

import Integracion.Equipo.DAOEquipo;
import Integracion.Factorias.FactoriaDAOImp;
import Integracion.Producto.DAOProducto;
import Negocio.Empleado.TEmpleado;

public class SAProducto implements ISAProducto {

	public Integer altaProducto(TProducto producto) {
		
		System.out.println("Intentando altaProducto - SAProducto");
		TProducto emp = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());

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
				
				if(producto.getTerminado() == null) {
					producto.setTerminado(false);
				}
				
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
		TProducto emp = FactoriaDAOImp.getInstance().getDaoProducto().readById(producto.getIdproyecto());
		TProducto empxnombre = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
		if (emp.getIdproyecto() == -1)
			return -1;
		else {
			if(!emp.getActivo())
				return -3;
			else {
				
			if(empxnombre.getIdproyecto() != -1) {								
				if (empxnombre.getIdproyecto() != producto.getIdproyecto())
					return -2;
			}
					
				if (producto.getNombre() == null)
					producto.setNombre(emp.getNombre());
				if (producto.getFechalanzamiento() == null)
					producto.setFechalanzamiento(emp.getFechalanzamiento());
				if (producto.getPrecio() == null)
					producto.setPrecio(emp.getPrecio());
				if (producto.getGenero() == null)
					producto.setGenero(emp.getGenero());
				if (producto.getPEGI() == null)
					producto.setPEGI(emp.getPEGI());
				if (producto.getTerminado() == null)
					producto.setTerminado(emp.getTerminado());
				if (producto.getActivo() == null)
					producto.setActivo(emp.getActivo());
				if (producto.getStock() == null)
					producto.setStock(emp.getStock());
				
				return FactoriaDAOImp.getInstance().getDaoProducto().modify(producto);
			
				
			}				
		}
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
		System.out.println("Intentando cerrarProducto - SAProducto");
		TProducto emp = FactoriaDAOImp.getInstance().getDaoProducto().readById(IDProducto);
		if (emp.getIdproyecto() == -1) {
			System.out.println("cerrarProducto No Realizado (no exite) - SAProducto");
			return -1;
			}
		if (!emp.getActivo()) {
			System.out.println("cerrarProducto No Realizado (ya cerrado) - SAProducto");
			return 2;
		}
		
		return FactoriaDAOImp.getInstance().getDaoProducto().cerrarProducto(IDProducto);
	}
}