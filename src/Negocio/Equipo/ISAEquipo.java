
package Negocio.Equipo;

import java.util.Set;

public interface ISAEquipo {

	public Integer altaEquipo(TEquipo equipo);

	public Integer bajaEquipo(Integer IDEquipo);

	public Integer modificarEquipo(TEquipo equipo);

	public Set<TEquipo> listarEquipos();

	public TEquipo mostrarEquipoID(Integer IDEquipo);

	public Integer anyadirIntegrante(Integer IDEmpleado, Integer IDEquipo);

	public Integer retirarIntegrante(Integer IDEmpleado, Integer IDEquipo);

	public Set<TEquipo> listarEquiposEmpleadoId(Integer IDEmpleado);
}