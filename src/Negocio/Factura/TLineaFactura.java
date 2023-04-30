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

	public int getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setIdProducto(int id) {
		idProducto = id;
	}
	
	public void setIdFactura(int id) {
		idFactura = id;
	}

	public void setCantidad(int cant) {
		cantidad = cant;
	}
	
	public void setPrecio(double prec) {
		precio = prec;
	}
}