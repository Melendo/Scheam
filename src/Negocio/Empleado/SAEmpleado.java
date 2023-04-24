package Negocio.Empleado;

import java.util.Set;
import Integracion.Factorias.FactoriaDAOImp;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Equipo.DAOEquipo;

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
				System.out.println("altaEmpleado Realizado (reactivado) - SAEmpleado");
				FactoriaDAOImp.getInstance().getDaoEmpleado().modify(empleado);
				return 2;
			}
		}
	}

	public Integer bajaEmpleado(Integer id) {

		System.out.println("Intentando bajaEmpleado - SAEmpleado");

		if (FactoriaDAOImp.getInstance().getDaoEmpleado().readById(id).getIdEmpleado() == -1) {
			System.out.println("bajaEmpleado No Realizado (no exite) - SAEmpleado");
			return -1;
		} else {
			System.out.println("bajaEmpleado Realizado - SAEmpleado");
			return FactoriaDAOImp.getInstance().getDaoEmpleado().delete(id);
		}
	}

	public Integer modificarEmpleado(TEmpleado empleado) {

		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readById(empleado.getIdEmpleado());
		if (emp.getIdEmpleado() == -1)
			return -1;
		else {
			if (empleado.getDNI() == null || (empleado.getDNI() != null && FactoriaDAOImp.getInstance().getDaoEmpleado().readByDNI(empleado.getDNI()).getDNI() != empleado.getDNI())) {
				
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
			}
			else
				return -2;

			return FactoriaDAOImp.getInstance().getDaoEmpleado().modify(empleado);
		}
	}

	public Set<TEmpleado> listarEmpleados() {
		Set<TEmpleado> lista = FactoriaDAOImp.getInstance().getDaoEmpleado().readAll();
		return lista;
	}

	public TEmpleado mostrarEmpleadoID(Integer Id) {
		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readById(Id);
		if (emp.getIdEmpleado() != -1)
			return emp;
		else
			return null;
	}

	public Set<TEmpleado> listarIntegrantesIdEquipo(Integer idEquipo) {
		DAOEquipo daoeq = FactoriaDAOImp.getInstance().getDaoEquipo();
		Set<TEmpleado> lista;

		if (daoeq.readByID(idEquipo).getIdEquipo() == -1) {
			return null;
		} else {
			lista = FactoriaDAOImp.getInstance().getDaoEmpleado().listarIdEquipo(idEquipo);
			return lista;
		}
	}

}
