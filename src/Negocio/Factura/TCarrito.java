/**
 * 
 */
package Negocio.Factura;

import java.util.Set;


public class TCarrito {

	private Set<TLineaFactura> set;
	
	private int idCliente;

	public Set getLineasFactura() {
		return set;
	}
	
	public void setLineasFactura(Set<TLineaFactura> lf) {
		set = lf;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int id) {
		this.idCliente= id;
	}
	
	public int addElement (TLineaFactura lf) {
		if(set.add(lf)) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public int removeElement (TLineaFactura lf) {
		if(set.remove(lf)) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}