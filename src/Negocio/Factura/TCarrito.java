/**
 * 
 */
package Negocio.Factura;

import java.util.Set;

public class TCarrito {

	private Set LineasFactura;
	
	private int idCliente;

	public Set getLineasFactura() {
		return LineasFactura;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}