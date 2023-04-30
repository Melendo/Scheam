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
	
	public int anyadirJuego(int id, int cantidad) {	
		for (TLineaFactura s : set) {
		    if(s.getIdProducto() == id) {
		    	int cant = s.getCantidad() + cantidad;
		    	s.setCantidad(cant);
		    	return 1;
		    }
		}
		return -1;
	}
	
	public int eliminarJuego(int id, int cantidad) {	
		for (TLineaFactura s : set) {
		    if(s.getIdProducto() == id) {
		    	
		    	if(s.getCantidad()<cantidad) {
		    		return -2;
		    	}
		    	else {
		    		int cant = s.getCantidad() - cantidad;
		    		s.setCantidad(cant);
		    		return 1;
		    	}
		    }
		}
		return -1;
	}
}