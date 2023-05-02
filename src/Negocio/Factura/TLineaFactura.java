
package Negocio.Factura;

public class TLineaFactura {

	private Integer idFactura;

	private Integer idProducto;

	private Integer cantidad;

	private Double precio;

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int id) {
		idFactura = id;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int id) {
		idProducto = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cant) {
		cantidad = cant;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(double prec) {
		precio = prec;
	}
}