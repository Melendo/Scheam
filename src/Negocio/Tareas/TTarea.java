/**
 * 
 */
package Negocio.Tareas;

public class TTarea {

	private Integer idTarea;

	private String nombre;

	private Integer equipo;

	private Integer producto;

	private Boolean terminada;

	private Boolean activo;

	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEquipo() {
		return equipo;
	}

	public void setEquipo(Integer equipo) {
		this.equipo = equipo;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public Boolean getTerminada() {
		return terminada;
	}

	public void setTerminada(Boolean terminada) {
		this.terminada = terminada;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}