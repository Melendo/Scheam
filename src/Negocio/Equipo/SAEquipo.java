
package Negocio.Equipo;

import java.util.Set;
import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Empleado.TEmpleado;

public class SAEquipo implements ISAEquipo {

	public Integer altaEquipo(TEquipo equipo) {
		
		System.out.println("Intentando altaEquipo - SAEquipo");
		TEquipo equ = FactoriaDAOImp.getInstance().getDaoEquipo().readByNombre(equipo.getNombre());
		
		if (equ.getNombre().equals("-1")) {
			System.out.println("altaEquipo Realizado (creado) - SAEquipo");
			return FactoriaDAOImp.getInstance().getDaoEquipo().create(equipo);
		} else {
			if (equ.getActivo()) {
				System.out.println("altaEquipo No Realizado (existe y activo) - SAEquipo");
				return -1;
			}else {
				equipo.setActivo(true);
				equipo.setIdEquipo(equ.getIdEquipo());
				System.out.println("altaEquipo Realizado (reactivado) - SAEquipo");
				FactoriaDAOImp.getInstance().getDaoEquipo().modify(equipo);
				return 2;
			}
		}
	}

	public Integer bajaEquipo(Integer IDEquipo) {
		
		System.out.println("Intentando bajaEquipo - SAEquipo");
		TEquipo equ = FactoriaDAOImp.getInstance().getDaoEquipo().readByID(IDEquipo);

		if (equ.getIdEquipo() == -1) {
			System.out.println("bajaEquipo No Realizado (no exite) - SAEquipo");
			return -1;
		}
		
		if(!equ.getActivo()) {
			System.out.println("bajaEquipo No Realizado (ya dado de baja) - SAEquipo");
			return -2;
		} else{
			System.out.println("bajaEquipo Realizado - SAEquipo");
			return FactoriaDAOImp.getInstance().getDaoEquipo().delete(IDEquipo);
		}
	}

	public Integer modificarEquipo(TEquipo equipo) {
		TEquipo equ = FactoriaDAOImp.getInstance().getDaoEquipo().readByID(equipo.getIdEquipo());
		if (equ.getIdEquipo() == -1 || !equ.getActivo()){
		System.out.println("modificarEquipo no realizado (equipo no existe o esta inactivo)- SAEquipo");
			return -1;
		} else {
			if (equipo.getNombre() != null  && FactoriaDAOImp.getInstance().getDaoEquipo().readByNombre(equipo.getNombre()).getNombre() != "-1"){
				System.out.println("modificarEquipo no realizado (equipo tiene un Nombre coincidente)- SAEquipo");
				return -2;
			}
			else {
				if (equipo.getNombre() == null)
					equipo.setNombre(equ.getNombre());
				if (equipo.getActivo() == null)
					equipo.setActivo(true);
				
				if (equipo instanceof TEquipoDesarrollo) {
					if(((TEquipoDesarrollo) equipo).getTecnologia()== null) {
						((TEquipoDesarrollo) equipo).setTecnologia(((TEquipoDesarrollo) equ).getTecnologia());
					}
				}
				else {
					if (((TEquipoDisenio) equipo).getCampoDisenio()== null) {
						((TEquipoDisenio) equipo).setCampoDisenio(((TEquipoDisenio) equ).getCampoDisenio());
					}
				}
			
			}
			System.out.println("modificarEquipo Realizado - SAEquipo");
			return FactoriaDAOImp.getInstance().getDaoEquipo().modify(equipo);
		}				
	}

	public Set<TEquipo> listarEquipos() {
		Set<TEquipo> lista = FactoriaDAOImp.getInstance().getDaoEquipo().readAll();
		System.out.println("listarEquipo Realizado - SAEquipo");
		return lista;
	}

	public TEquipo mostrarEquipoID(Integer IDEquipo) {
		TEquipo equ = FactoriaDAOImp.getInstance().getDaoEquipo().readByID(IDEquipo);
		if (equ.getIdEquipo() != -1 && equ.getActivo()){
		System.out.println("mostrarEquipo Realizado - SAEquipo");
			return equ;
			}
		else { 
			equ.setIdEquipo(-1);
			System.out.println("mostrarEquipo no Realizado - SAEquipo");
			return equ;
		}
	}

	public Integer anyadirIntegrante(Integer IDEmpleado, Integer IDEquipo) {
		
		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readById(IDEmpleado);
		if (emp.getIdEmpleado() == -1 || !emp.getActivo()){
			System.out.println("AñadirIntegrante no realizado (empleado no existe o esta inactivo)- SAEquipo");
			return -1;
		}
		else {
			TEquipo equ = FactoriaDAOImp.getInstance().getDaoEquipo().readByID(IDEquipo);
			if (equ.getIdEquipo() == -1 || !equ.getActivo()){
				System.out.println("AñadirIntegrante no realizado (equipo no existe o esta inactivo)- SAEquipo");
				return -2;
			}
			else {
				if(FactoriaDAOImp.getInstance().getDaoEquipo().pertenece(IDEmpleado, IDEquipo)) {
					System.out.println("AñadirIntegrante no realizado (El empleado ya esta en el equipo)- SAEquipo");
					return -3;
				}
				else {
					System.out.println("AñadirIntegrante realizado - SAEquipo");
					return FactoriaDAOImp.getInstance().getDaoEquipo().anyadirIntegrante(IDEmpleado, IDEquipo);
				}
			}
		}
	}

	public Integer retirarIntegrante(Integer IDEmpleado, Integer IDEquipo) {
		if(!FactoriaDAOImp.getInstance().getDaoEquipo().pertenece(IDEmpleado, IDEquipo)) {
			System.out.println("retirarIntegrante no realizado (El empleado no esta en el equipo)- SAEquipo");
			return -1;
		}
		else {
			System.out.println("retirarIntegrante realizado - SAEquipo");
			return FactoriaDAOImp.getInstance().getDaoEquipo().bajaIntegrante(IDEmpleado, IDEquipo);
		}
	}
	public Set<TEquipo> listarEquiposEmpleadoId(Integer IDEmpleado) {
		TEmpleado emp = FactoriaDAOImp.getInstance().getDaoEmpleado().readById(IDEmpleado);
		if (emp.getIdEmpleado() == -1 || !emp.getActivo()){
			System.out.println("ListarEquiposEmpleado no realizado (empleado no existe o esta inactivo)- SAEquipo");
			return null;
		}
		Set<TEquipo> lista = FactoriaDAOImp.getInstance().getDaoEquipo().listarEquiposEmpleadoId(IDEmpleado);
		System.out.println("listarEquiposEmpleadoId Realizado - SAEquipo");
		return lista;
	}
}