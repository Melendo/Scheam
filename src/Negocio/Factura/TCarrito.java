/**
 * 
 */
package Negocio.Factura;

import java.util.Set;


public class TCarrito {

	private Set<TLineaFactura> set;
	
	private Integer idCliente;

	public Set<TLineaFactura> getLineasFactura() {
		return set;
	}
	
	public void setLineasFactura(Set<TLineaFactura> lf) {
		set = lf;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int id) {
		this.idCliente= id;
	}
	
	public Integer addElement (TLineaFactura lf) {
		if(set.add(lf)) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public Integer removeElement (TLineaFactura lf) {
		if(set.remove(lf)) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}