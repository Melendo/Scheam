/**
 * 
 */
package Negocio.Factura;

import java.util.Set;

import Integracion.Cliente.DAOCliente;
import Integracion.Equipo.DAOEquipo;
import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Empleado.TEmpleado;
import Negocio.Producto.TProducto;

public class SAFactura implements ISAFactura {
	TCarrito carrito;

	public Integer crearCarrito(Integer IDCliente) {
		carrito = new TCarrito(IDCliente);
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
			System.out.println("listarIntegrantesIdEquipo Realizado - SAEmpleado");
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
				TLineaFactura lf = new TLineaFactura(IDProducto, cantidad, prd.getPrecio());
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

	public TFactura cerrarCarrito() {
		
		return null;
	}
}