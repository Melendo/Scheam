
package Negocio.Equipo;

import java.util.Set;
import Integracion.Factorias.FactoriaDAOImp;

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
		
		if(equ.getActivo()) {
			System.out.println("bajaEquipo Realizado - SAEquipo");
			return FactoriaDAOImp.getInstance().getDaoEquipo().delete(IDEquipo);
		} else{
			return -2;
		}
	}

	public Integer modificarEquipo(TEquipo equipo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set listarEquipos() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public TEquipo mostrarEquipoID(Integer IDEquipo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer anyadirIntegrante(Integer IDEmpleado, Integer IDEquipo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Integer retirarIntegrante(Integer IDEmpleado, Integer IDEquipo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	public Set<TEquipo> listarEquiposEmpleadoId(Integer IDEmpleado) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}