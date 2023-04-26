
package Negocio.Equipo;

public class TEquipo {

	private String Nombre;
	private Boolean Activo;

	private Integer IdEquipo;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Boolean getActivo() {
		return Activo;
	}
	public void setActivo(Boolean activo) {
		Activo = activo;
	}
	public Integer getIdEquipo() {
		return IdEquipo;
	}
	public void setIdEquipo(Integer idEquipo) {
		IdEquipo = idEquipo;
	}
	
}