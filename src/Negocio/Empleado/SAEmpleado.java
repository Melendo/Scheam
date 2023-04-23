package Negocio.Empleado;

import java.util.Set;
import Integracion.Factorias.FactoriaDAOImp;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Equipo.DAOEquipo;


public class SAEmpleado implements ISAEmpleado {
	
	
	DAOEmpleado daoe = FactoriaDAOImp.getInstance().getDaoEmpleado();

	
	public Integer altaEmpleado(TEmpleado empleado) {
	
		
		TEmpleado emp = daoe.readById(empleado.getIdEmpleado());
		if(emp.getIdEmpleado() == -1){
			return daoe.create(empleado);
		}else{
			if(emp.getActivo()) return -1;
			else{
				empleado.setActivo(true);
				return daoe.modify(empleado);
			}
		}
	}

	public Integer bajaEmpleado(Integer id) {
		if(daoe.readById(id).getIdEmpleado()==-1) return -1;
		else return daoe.delete(id);	
	}

	public Integer ModificarEmpleado(TEmpleado empleado) {
		if(daoe.readById(empleado.getIdEmpleado()).getIdEmpleado() == -1) return -1;
		else return daoe.modify(empleado);		
	}

	public Set<TEmpleado> listarEmpleados() {	
		Set<TEmpleado> lista = daoe.readAll();
		return lista;
	}

	public TEmpleado mostrarEmpleadoID(Integer Id) {
		TEmpleado emp = daoe.readById(Id);
		if(emp.getIdEmpleado() != -1)
			return emp;
		else return null;
	}

	public Set<TEmpleado> listarIntegrantesIdEquipo(Integer idEquipo) {
		DAOEquipo daoeq = FactoriaDAOImp.getInstance().getDaoEquipo();
		Set<TEmpleado> lista;
		
		if(daoeq.readByID(idEquipo).getIdEquipo() == -1){
			return null;
		}else{
			lista = daoe.listarIdEquipo(idEquipo);
			return lista;
		}
	}

}


