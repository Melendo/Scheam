/**
 * 
 */
package Negocio.Factura;

import java.util.HashSet;
import java.util.Set;

import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Producto.TProducto;

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
	
	public int comprobarStock() {
		
		for (TLineaFactura s : set) {
			TProducto prd = FactoriaDAOImp.getInstance().getDaoProducto().readById(s.getIdProducto());
		   if(s.getCantidad()>prd.getStock()) {
			   return -1;
		   }
		}
		
		return 1;
	}
	
	public int reducirStock() {
		
		int stk;
		for (TLineaFactura s : set) {
			TProducto prd = FactoriaDAOImp.getInstance().getDaoProducto().readById(s.getIdProducto());
			stk = prd.getStock() - s.getCantidad();
			prd.setStock(stk);
			if(FactoriaDAOImp.getInstance().getDaoProducto().modify(prd) == -1) {
				return -1;
			}
		}
		
		return 1;
	
	}
	
	public double calcularImporte() {
		double imp = 0, aux;
		
		for (TLineaFactura s : set) {
			aux = s.getPrecio() * s.getCantidad();
			imp += aux;
		}
		
		return imp;
	}
	
}