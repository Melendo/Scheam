/**
 * 
 */
package Negocio.Factura;

import java.util.HashSet;
import java.util.Set;

public class TCarrito {

	private Set<TLineaFactura> set;
	
	private int idCliente;

	public Set getLineasFactura() {
		return set;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public TCarrito( int IDCliente) {
		this.idCliente = IDCliente;
		set = new HashSet<>();
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