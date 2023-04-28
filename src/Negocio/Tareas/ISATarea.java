/**
 * 
 */
package Negocio.Tareas;

import java.util.Set;


public interface ISATarea {

	public Integer altaTarea(TTarea tarea);


	public Integer bajaTarea(Integer IDTarea);


	public Integer modificarTarea(Integer IDTarea);


	public Set listarTareas();


	public Set listarTareasEquipo(Integer IDEquipo);


	public Set listarTareasProducto(Integer IDProducto);


	public TTarea mostrarTareaID(Integer IDTarea);


	public Integer cerrarTarea(Integer IDTarea);
}