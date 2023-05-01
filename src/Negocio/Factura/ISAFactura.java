/**
 * 
 */
package Negocio.Factura;

import java.util.Set;


public interface ISAFactura {
	
	public Integer crearCarrito(Integer IDCliente);

	public Integer eliminarCarrito();

	public Set listarFacturasIDCliente(Integer IDCliente);

	public TFactura mostrarFacturaID(Integer IDFactura);

	public Integer anyadirProductoaCarrito(Integer IDProducto, Integer cantidad);

	public Integer eliminarProductodeCarrito(Integer IDProducto, Integer cantidad);

	public Integer cerrarCarrito();
	
	public Set<TLineaFactura> mostrarCarrito();
}