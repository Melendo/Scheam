/**
 * 
 */
package Negocio.Factura;

import java.sql.Date;
import java.util.Set;

public class TFactura {

	private Integer IDFactura;

	private Boolean Activo;

	private Double Importe;

	private Date fecha;

	private Integer IDCliente;

	private Set<TLineaFactura> set;
	

	public Integer getIdFactura() {
		return IDFactura;
	}
	
	public void setIdFactura(int id) {
		this.IDFactura = id;
	}
	
	public Boolean isActivo() {
		return Activo;
	}
	
	public void setActivo(Boolean activo) {
		Activo = activo;
	}

	public Double getImporte() {
		return Importe;
	}
	
	public void setImporte(Double importe) {
		Importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(Integer IDClienteFactura) {
		IDCliente = IDClienteFactura;
	}
	
	public Set<TLineaFactura> getLineas(){
		return set;
	}
	
	public void setLineas(Set<TLineaFactura> lf) {
		set = lf;
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