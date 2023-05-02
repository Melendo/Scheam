package Negocio.Empleado;

import java.util.Set;

public interface ISAEmpleado {

	public Integer altaEmpleado(TEmpleado empleado);

	public Integer bajaEmpleado(Integer IDEmpleado);

	public Integer modificarEmpleado(TEmpleado empleado);

	public Set<TEmpleado> listarEmpleados();

	public TEmpleado mostrarEmpleadoID(Integer IDEmpleado);

	public Set<TEmpleado> listarIntegrantesIdEquipo(Integer IDEquipo);

}