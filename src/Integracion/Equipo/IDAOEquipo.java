
package Integracion.Equipo;

import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TVinculacion;

import java.util.Set;

public interface IDAOEquipo {

	public Integer create(TEquipo equipo);

	public Integer delete(Integer idequipo);

	public Integer modify(TEquipo equipo);
	
	public Set<TEquipo> readAll();

	public TEquipo readByID(Integer idequipo);

	public Integer anyadirIntegrante(TVinculacion pert);

	public Integer bajaIntegrante(TVinculacion pert);

	public Set<TEquipo> listarEquiposEmpleadoId(Integer idempleado);
	
	public TEquipo readByNombre(String nombre);
	
	public boolean pertenece(Integer idempleado, Integer idequipo);
}