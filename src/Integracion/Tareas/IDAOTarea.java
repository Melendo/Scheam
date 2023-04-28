/**
 * 
 */
package Integracion.Tareas;

import Negocio.Tareas.TTarea;
import java.util.Set;
import Negocio.Producto.TProducto;

public interface IDAOTarea {

	public Integer create(TTarea tarea);


	public Integer delete(Integer idtarea);


	public Integer modify(TTarea tarea);


	public Set readAll();


	public TTarea readById(Integer idtarea);


	public Set listarIdEquipo(Integer idtarea);


	public TProducto listarIdProducto(Integer idtarea);


	public Integer closeTask(Integer idtarea);
}