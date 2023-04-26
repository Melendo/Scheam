package Negocio.Producto;

public class TProducto {
	
	private Integer idproyecto;
	private String nombre;
	private Integer fechalanzamiento;
	private Double precio;
	private String genero;
	private Integer PEGI;
	private Boolean terminado;
	private Boolean activo;
	private Integer stock;
	
	public Integer getIdproyecto() {
		return idproyecto;
	}
	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getFechalanzamiento() {
		return fechalanzamiento;
	}
	public void setFechalanzamiento(Integer fechalanzamiento) {
		this.fechalanzamiento = fechalanzamiento;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getPEGI() {
		return PEGI;
	}
	public void setPEGI(Integer pegi) {
		this.PEGI = pegi;
	}
	public Boolean getTerminado() {
		return terminado;
	}
	public void setTerminado(Boolean terminado) {
		this.terminado = terminado;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	
}