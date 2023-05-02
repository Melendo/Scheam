/**
 * 
 */
package Negocio.Tareas;

import java.util.Set;

public interface ISATarea {

	public Integer altaTarea(TTarea tarea);

	public Integer bajaTarea(Integer IDTarea);

	public Integer modificarTarea(TTarea tarea);

	public Set<TTarea> listarTareas();

	public Set<TTarea> listarTareasEquipo(Integer IDEquipo);

	public Set<TTarea> listarTareasProducto(Integer IDProducto);

	public TTarea mostrarTareaID(Integer IDTarea);

	public Integer cerrarTarea(Integer IDTarea);
}