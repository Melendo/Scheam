
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
			}
		
		return null;
		// end-user-code
	}

	public Integer bajaEquipo(Integer IDEquipo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
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