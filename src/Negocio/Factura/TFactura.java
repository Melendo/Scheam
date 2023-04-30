/**
 * 
 */
package Negocio.Factura;

import java.util.Date;
import java.util.Set;

public class TFactura {

	private Integer IDFactura;

	private Boolean Activo;

	private Double Importe;

	private Date fecha;

	private Integer IDCliente;

	private Set<TLineaFactura> set;
	
	public TFactura( int idcliente, Set<TLineaFactura> lineas, Double importe) {
		this.IDCliente = idcliente;
		this.set = lineas;
		this.Importe = importe;
		this.Activo = true;
	}

	public Integer getIdFactura() {
		return IDFactura;
	}
	
	public void setIdFactura(int id) {
		this.IDFactura = id;
	}

	public Double getImporte() {
		return Importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setActivo(Boolean activo) {
		Activo = activo;
	}

	public void setImporte(Double importe) {
		Importe = importe;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean isActivo() {
		return Activo;
	}

	public Integer getIDClienteFactura() {
		return IDCliente;
	}

	public void setIDClienteFactura(Integer IDClienteFactura) {
		IDCliente = IDClienteFactura;
	}
}