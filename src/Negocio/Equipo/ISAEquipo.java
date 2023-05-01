
package Negocio.Equipo;

import java.util.Set;

public interface ISAEquipo {

	public Integer altaEquipo(TEquipo equipo);

	public Integer bajaEquipo(Integer IDEquipo);

	public Integer modificarEquipo(TEquipo equipo);

	public Set<TEquipo> listarEquipos();

	public TEquipo mostrarEquipoID(Integer IDEquipo);

	public Integer anyadirIntegrante(TVinculacion pert);

	public Integer retirarIntegrante(TVinculacion pert);

	public Set<TEquipo> listarEquiposEmpleadoId(Integer IDEmpleado);
}