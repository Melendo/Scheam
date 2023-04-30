/**
 * 
 */
package Negocio.Factura;

import java.util.Set;

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
		
		return null;
	}

	public TFactura mostrarFacturaID(Integer IDFactura) {
		
		return null;
	}

	public Integer anyadirProductoaCarrito(Integer IDProducto, Integer cantidad) {
		
		return null;
	}

	public Integer eliminarProductodeCarrito(Integer IDProducto, Integer cantidad) {
		
		return null;
	}

	public TFactura cerrarCarrito() {
		
		return null;
	}
}