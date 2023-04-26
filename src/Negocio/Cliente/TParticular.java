/**
 * 
 */
package Negocio.Cliente;

public class TParticular extends TCliente {
	
	private String DNI;
	private Integer telefono;
	
	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String dNI) {
		this.DNI = dNI;
	}
	
	public Integer getTelefono() {
		return telefono;
	}
	
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
}