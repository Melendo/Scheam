/**
 * 
 */
package Negocio.Factura;

import java.util.HashSet;
import java.util.Set;
import java.util.Calendar;
import java.sql.Date;

import Integracion.Cliente.DAOCliente;
import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Producto.TProducto;

public class SAFactura implements ISAFactura {
	TCarrito carrito ;

	public Integer crearCarrito(Integer IDCliente) {
		Set<TLineaFactura> set = new HashSet<TLineaFactura>();
		carrito = new TCarrito();
		carrito.setLineasFactura(set);
		carrito.setIdCliente(IDCliente);
		return 1;
	}

	public Integer eliminarCarrito() {
		carrito = null;
		return 1;
	}

	public Set<TFactura> listarFacturasIDCliente(Integer IDCliente) {
		DAOCliente daocln = FactoriaDAOImp.getInstance().getDaoCliente();
		Set<TFactura> lista;

		if (daocln.readByID(IDCliente).getID() == -1) {
			System.out.println("listarFacturasIDCliente no realizado (equipo no existe o esta inactivo)- SAFactura");
			return null;
		} else {
			lista = FactoriaDAOImp.getInstance().getDaoFactura().listarFacturasIDCliente(IDCliente);
			System.out.println("listarFacturasIDCliente - SAFactura");
			return lista;
		}
	}

	public TFactura mostrarFacturaID(Integer IDFactura) {
		TFactura fct = FactoriaDAOImp.getInstance().getDaoFactura().readById(IDFactura);
		if (fct.getIdFactura() != -1 && fct.isActivo()) {
			System.out.println("mostrarFacturaID Realizado - SAFactura");
			return fct;
		}
		else { 
			fct.setIdFactura(-1);;
			System.out.println("mostrarFacturaID no realizado (factura no existe o no esta activa) - SAFactura");
			return fct;
		}
	}

	public Integer anyadirProductoaCarrito(Integer IDProducto, Integer cantidad) {
		
		System.out.println("Intentando añadirProductoCarrito - SAFactura");
		TProducto prd = FactoriaDAOImp.getInstance().getDaoProducto().readById(IDProducto);
		
		if(prd.getIdproyecto() == -1 || !prd.getActivo()) {
			System.out.println("No se ha podido añadir el producto al carrito (no existe o esta desactivado) - SAFactura");
			return -1;
		}
		else {
			Set<TLineaFactura> set = carrito.getLineasFactura();
			
			for (TLineaFactura s : set) {
			    if(s.getIdProducto() == IDProducto) {
			    	int cant = s.getCantidad() + cantidad;
			    	s.setCantidad(cant);
			    	carrito.setLineasFactura(set);
			    	System.out.println("Se ha aumentado el num de productos en el pedido - SAFactura");
					return 1;
			    }
			  
			}
			TLineaFactura lf = null;
			lf.setIdProducto(IDProducto);
			lf.setCantidad(cantidad);
			lf.setPrecio(prd.getPrecio());
			carrito.addElement(lf);
			System.out.println("Se ha anyadido el numero de productos al carrito - SAFactura");
			return 1;
			}
			
		}

	public Integer eliminarProductodeCarrito(Integer IDProducto, Integer cantidad) {
		
		System.out.println("Intentando eliminarProductoCarrito - SAFactura");
		TProducto prd = FactoriaDAOImp.getInstance().getDaoProducto().readById(IDProducto);
		
		if(prd.getIdproyecto() == -1 || !prd.getActivo()) {
			System.out.println("No se ha podido eliminar el producto del carrito (no existe o esta desactivado) - SAFactura");
			return -1;
		}
		else {
			
			Set<TLineaFactura> set = carrito.getLineasFactura();
			
			for (TLineaFactura s : set) {
			    if(s.getIdProducto() == IDProducto) {
			    	
			    	if(s.getCantidad()<cantidad) {
			    		System.out.println("No se ha eliminado el producto del carrito (la cantidad a eliminar es mayor que la cantidad en el carrito) - SAFactura");
			    		return -1;
			    	}
			    	else {
			    		int cant = s.getCantidad() - cantidad;
			    		s.setCantidad(cant);
			    		carrito.setLineasFactura(set);
			    		System.out.println("Se ha eliminado correctamente el numero de productos - SAFactura");
			    		return 1;
			    	}
			    }
			}
			System.out.println("No se ha eliminado el producto del carrito (no esta en el carrito) - SAFactura");
			return -1;
		}
	}

	public Integer cerrarCarrito() {
		
		Set<TLineaFactura> set = carrito.getLineasFactura();
		TProducto prd = null;
		Integer stk;
		
		//Comprobamos que haya stock para todos los productos del carrito
		for (TLineaFactura s : set) {
			prd = FactoriaDAOImp.getInstance().getDaoProducto().readById(s.getIdProducto());
			if(s.getCantidad()>prd.getStock()) {
				System.out.println("No se ha cerrado el carrito por falta de Stock - SAFactura");
				return -1;
			}
		}
	
		//Reducimos el stock de todos los productos del carrito
		for (TLineaFactura s : set) {
			prd = FactoriaDAOImp.getInstance().getDaoProducto().readById(s.getIdProducto());
			stk = prd.getStock() - s.getCantidad();
			prd.setStock(stk);
			if(FactoriaDAOImp.getInstance().getDaoProducto().modify(prd) == -1) {
				System.out.println("Ha habido un error al reducir el stock con la bd - SAFactura");
				return -1;
			}
		}
		
		//Creamos la factura
		double imp = 0, aux;
		
		for (TLineaFactura s : set) {
			aux = s.getPrecio() * s.getCantidad();
			imp += aux;
		}
		Calendar calendar = Calendar.getInstance();
		Date sqlDate = new Date((calendar.getTime()).getTime());
		
		TFactura factura = new TFactura();
		factura.setIDCliente(carrito.getIdCliente());
		factura.setLineas(carrito.getLineasFactura());
		factura.setImporte(imp);
		factura.setFecha(sqlDate);
		
		if(FactoriaDAOImp.getInstance().getDaoFactura().create(factura) == 1) {
			System.out.println("Se ha cerrado el carrito correctamete - SAFactura");
			return 1;
		}
		System.out.println("No se ha cerrado el carrito correctamete - SAFactura");
		return -1;
	}
}