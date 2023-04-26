/**
 * 
 */
package Negocio.Cliente;

public class TDistribuidor extends TCliente {

	private String CIF;
	private String direccion;
	
	public String getCIF() {
		return CIF;
	}
	
	public void setCIF(String cIF) {
		this.CIF = cIF;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}