/**
 * 
 */
package Negocio.Factura;

public class TLineaFactura {

	private int idFactura;

	private int idProducto;
	
	private int cantidad;
	
	private double precio;

	public int getIdFactura() {		
		return idFactura;
	}
	
	public void setIdFactura(int id) {
		idFactura = id;
	}

	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int id) {
		idProducto = id;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cant) {
		cantidad = cant;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double prec) {
		precio = prec;
	}
}