/**
 * 
 */
package Integracion.Tareas;

import Negocio.Tareas.TTarea;
import java.util.Set;

public interface IDAOTarea {

	public Integer create(TTarea tarea);


	public Integer delete(Integer idtarea);


	public Integer modify(TTarea tarea);


	public Set<TTarea> readAll();


	public TTarea readById(Integer idtarea);


	public Set<TTarea> listarIdEquipo(Integer idEquipo);


	//public TProducto listarIdProducto(Integer idtarea);

	public Set<TTarea> listarIdProducto(Integer idProducto);

	public Integer closeTask(Integer idtarea);
}