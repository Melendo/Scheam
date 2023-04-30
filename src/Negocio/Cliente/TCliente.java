package Negocio.Cliente;

public class TCliente {

	private Integer ID;
	private String email;
	private String nombre;
	private Boolean activo;
	private Boolean distribuidor = false;
	
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		this.ID = iD;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	public Boolean getTipo() {
		return distribuidor;
	}

	
}