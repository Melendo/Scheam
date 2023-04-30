/**
 * 
 */
package Negocio.Factura;

import java.util.Date;
import java.util.Set;

public class TFactura {

	private Integer IDFactura;

	private Boolean Activo;

	private Integer Importe;

	private Date fecha;

	private Integer IDCliente;

	private Set<TLineaFactura> set;

	public Integer getIdFactura() {
		return IDFactura;
	}

	public Integer getImporte() {
		return Importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setActivo(Boolean activo) {
		Activo = activo;
	}

	public void setImporte(Integer importe) {
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