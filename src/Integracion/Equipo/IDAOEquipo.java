
package Integracion.Equipo;

import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;

import java.util.Set;

public interface IDAOEquipo {

	public Integer create(TEquipoDesarrollo equipo);
	
	public Integer create(TEquipoDisenio equipo);

	public Integer delete(Integer idequipo);

	public Integer modify(TEquipo equipo);

	public Set<TEquipo> readAll();

	public TEquipo readByID(Integer idequipo);

	public Integer anyadirIntegrante(Integer idempleado, Integer idequipo);

	public Integer bajaIntegrante(Integer idempleado, Integer idequipo);

	public Set<TEquipo> listarEquiposEmpleadoId(Integer idempleado);
}