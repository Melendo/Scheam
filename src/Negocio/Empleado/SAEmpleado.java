package Negocio.Empleado;

import java.util.Set;

import Integracion.Equipo.DAOEquipo;
import Integracion.Factorias.FactoriaDAOImp;

public class SAEmpleado implements ISAEmpleado {

	public Integer altaEmpleado(TEmpleado empleado) {

		System.out.println("Intentando altaEmpleado - SAEmpleado");
		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readByDNI(empleado.getDNI());

		if (emp.getDNI().equals("-1")) {
			System.out.println("altaEmpleado Realizado (creado) - SAEmpleado");
			return FactoriaDAOImp.getInstance().getDaoEmpleado().create(empleado);
		} else {
			if (emp.getActivo()) {
				System.out.println("altaEmpleado No Realizado (existe y activo) - SAEmpleado");
				return -1;
			} else {
				empleado.setActivo(true);
				empleado.setIdEmpleado(emp.getIdEmpleado());
				System.out.println("altaEmpleado Realizado (reactivado) - SAEmpleado");
				FactoriaDAOImp.getInstance().getDaoEmpleado().modify(empleado);
				return 2;
			}
		}
	}

	public Integer bajaEmpleado(Integer id) {

		System.out.println("Intentando bajaEmpleado - SAEmpleado");
		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readById(id);

		if (emp.getIdEmpleado() == -1) {
			System.out.println("bajaEmpleado No Realizado (no exite) - SAEmpleado");
			return -1;
		}
		if (!FactoriaDAOImp.getInstance().getDaoEmpleado().pertenece(id)) {
			if (emp.getActivo()) {
				System.out.println("bajaEmpleado Realizado - SAEmpleado");
				return FactoriaDAOImp.getInstance().getDaoEmpleado().delete(id);
			} else {
				return -2;
			}
		} else {
			return -3;
		}
	}

	public Integer modificarEmpleado(TEmpleado empleado) {

		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readById(empleado.getIdEmpleado());
		if (emp.getIdEmpleado() == -1 || !emp.getActivo()) {
			System.out.println("modificarEmpleado no realizado (empleado no existe o esta inactivo)- SAEmpleado");
			return -1;
		} else {
			if (empleado.getDNI() != null
					&& FactoriaDAOImp.getInstance().getDaoEmpleado().readByDNI(empleado.getDNI()).getDNI() != "-1") {
				System.out.println("modificarEmpleado no realizado (empleado tiene un DNI coincidente)- SAEmpleado");
				return -2;
			} else {

				if (empleado.getDNI() == null)
					empleado.setDNI(emp.getDNI());
				if (empleado.getNombre() == null)
					empleado.setNombre(emp.getNombre());
				if (empleado.getApellidos() == null)
					empleado.setApellidos(emp.getApellidos());
				if (empleado.getE_mail() == null)
					empleado.setE_mail(emp.getE_mail());
				if (empleado.getTlfn() == null)
					empleado.setTlfn(emp.getTlfn());
				if (empleado.getSueldo() == null)
					empleado.setSueldo(emp.getSueldo());
				if (empleado.getActivo() == null) {
					empleado.setActivo(true);
				}
				System.out.println("modificarEmpleado Realizado - SAEmpleado");
				return FactoriaDAOImp.getInstance().getDaoEmpleado().modify(empleado);
			}
		}
	}

	public Set<TEmpleado> listarEmpleados() {
		Set<TEmpleado> lista = FactoriaDAOImp.getInstance().getDaoEmpleado().readAll();
		System.out.println("listarEmpleados Realizado - SAEmpleado");
		return lista;
	}

	public TEmpleado mostrarEmpleadoID(Integer Id) {
		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readById(Id);
		if (emp.getIdEmpleado() != -1 && emp.getActivo()) {
			System.out.println("mostrarEmpleadoID Realizado - SAEmpleado");
			return emp;
		} else {
			emp.setIdEmpleado(-1);
			System.out.println("mostrarEmpleadoID no realizado (empleado no existe o no esta activo) - SAEmpleado");
			return emp;
		}
	}

	public Set<TEmpleado> listarIntegrantesIdEquipo(Integer idEquipo) {
		DAOEquipo daoeq = FactoriaDAOImp.getInstance().getDaoEquipo();
		Set<TEmpleado> lista;

		if (daoeq.readByID(idEquipo).getIdEquipo() == -1) {
			System.out.println("ListarEquiposEmpleado no realizado (equipo no existe o esta inactivo)- SAEmpleado");
			return null;
		} else {
			lista = FactoriaDAOImp.getInstance().getDaoEmpleado().listarIdEquipo(idEquipo);
			System.out.println("listarIntegrantesIdEquipo Realizado - SAEmpleado");
			return lista;
		}
	}

}
