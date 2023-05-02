/**
 * 
 */
package Integracion.Tareas;

import java.util.Set;

import Negocio.Tareas.TTarea;

public interface IDAOTarea {

	public Integer create(TTarea tarea);

	public Integer delete(Integer idtarea);

	public Integer modify(TTarea tarea);

	public Set<TTarea> readAll();

	public TTarea readById(Integer idtarea);

	public Set<TTarea> listarIdEquipo(Integer idEquipo);

	public Set<TTarea> listarIdProducto(Integer idProducto);

	public Integer closeTask(Integer idtarea);
}