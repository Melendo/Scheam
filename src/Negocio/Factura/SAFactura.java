/**
 * 
 */
package Negocio.Factura;

import java.util.HashSet;
import java.util.Set;

import Integracion.Cliente.DAOCliente;
import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Producto.TProducto;

public class SAFactura implements ISAFactura {
	TCarrito carrito = null;

	public Integer crearCarrito(Integer IDCliente) {
		Set<TLineaFactura> set = new HashSet();
		carrito.setLineasFactura(set);
		carrito.setIdCliente(IDCliente);
		return 1;
	}

	public Integer eliminarCarrito() {
		carrito = null;
		return 1;
	}

	public Set listarFacturasIDCliente(Integer IDCliente) {
		DAOCliente daocln = FactoriaDAOImp.getInstance().getDaoCliente();
		Set<TFactura> lista;

		if (daocln.mostrarClienteID(IDCliente).getID() == -1) {
			System.out.println("listarFacturasIDCliente no realizado (equipo no existe o esta inactivo)- SAFactura");
			return null;
		} else {
			lista = FactoriaDAOImp.getInstance().getDaoFactura().listarIDCliente(IDCliente);
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
			if(carrito.anyadirJuego(IDProducto, cantidad) == -1) {
				TLineaFactura lf = null;
				lf.setIdProducto(IDProducto);
				lf.setCantidad(cantidad);
				lf.setPrecio(prd.getPrecio());
				carrito.addElement(lf);
			}
			System.out.println("Se ha añadido el producto al carrito - SAFactura");
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
			int n = carrito.eliminarJuego(IDProducto, cantidad);
			if(n == -1) {
				System.out.println("No se ha eliminado el producto del carrito (no esta en el carrito) - SAFactura");
				return -1;
			}else if(n == -2) {
				System.out.println("No se ha eliminado el producto del carrito (la cantidad a eliminar es mayor que la cantidad en el carrito) - SAFactura");
				return 1;
			}
			System.out.println("Se ha añadido el producto - SAFactura");
			return 1;
		}
	}

	public Integer cerrarCarrito() {
		
		if(carrito.comprobarStock() == -1) {
			System.out.println("No se ha cerrado el carrito por falta de Stock - SAFactura");
			return null;
		}
		if(carrito.reducirStock() == -1) {
			System.out.println("Ha habido un error al reducir el stock con la bd - SAFactura");
		}
		
		TFactura factura = new TFactura(carrito.getIdCliente(), carrito.getLineasFactura(), carrito.calcularImporte());
		factura.setIDCliente(carrito.getIdCliente());
		factura.setLineas(carrito.getLineasFactura());
		factura.setImporte(carrito.calcularImporte());
		if(FactoriaDAOImp.getInstance().getDaoFactura().create(factura) == 1) {
			System.out.println("Se ha cerrado el carrito correctamete - SAFactura");
			return 1;
		}
		System.out.println("No se ha cerrado el carrito correctamete - SAFactura");
		return -1;
	}
}