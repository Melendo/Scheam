package Integracion.Empleado;

import Negocio.Empleado.TEmpleado;
import java.util.Set;

public interface IDAOEmpleado {

	public Integer create(TEmpleado empleado);

	public Integer delete(Integer idempleado);

	public Integer modify(TEmpleado empleado);

	public Set<TEmpleado> readAll();

	public TEmpleado readById(Integer idempleado);

	public Set<TEmpleado> listarIdEquipo(Integer idequipo);
}