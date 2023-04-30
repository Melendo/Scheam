
package Integracion.Equipo;

import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;

import java.util.Set;

public interface IDAOEquipo {

	public Integer create(TEquipo equipo);

	public Integer delete(Integer idequipo);

	public Integer modify(TEquipo equipo);

	public Set<TEquipoDesarrollo> readAllDes();
	
	public Set<TEquipoDisenio> readAllDis();

	public TEquipo readByID(Integer idequipo);

	public Integer anyadirIntegrante(Integer idempleado, Integer idequipo);

	public Integer bajaIntegrante(Integer idempleado, Integer idequipo);

	public Set<TEquipo> listarEquiposEmpleadoId(Integer idempleado);
	
	public TEquipo readByNombre(String nombre);
	
	public Integer empleadoEstaEnEquipo(Integer idempleado, Integer idequipo);
}