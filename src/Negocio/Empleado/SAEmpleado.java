package Negocio.Empleado;

import java.util.Set;
import Integracion.Factorias.FactoriaDAOImp;
import Integracion.Empleado.DAOEmpleado;
import Integracion.Equipo.DAOEquipo;


public class SAEmpleado implements ISAEmpleado {
	
	
	DAOEmpleado daoe = FactoriaDAOImp.getInstance().getDaoEmpleado();

	
	public Integer altaEmpleado(TEmpleado empleado) {
		
		System.out.println("Intentando altaEmpleado - SAEmpleado");
		TEmpleado emp = daoe.readByDNI(empleado.getDNI());
		
		if(emp.getDNI().equals("-1")){
			System.out.println("altaEmpleado Realizado (creado) - SAEmpleado");
			return daoe.create(empleado);
		}else{
			if(emp.getActivo()) {
				System.out.println("altaEmpleado No Realizado (existe y activo) - SAEmpleado");
				return -1;
			}
			else{
				empleado.setActivo(true);
				System.out.println("altaEmpleado Realizado (reactivado) - SAEmpleado");
				return daoe.modify(empleado);
			}
		}
	}

	public Integer bajaEmpleado(Integer id) {
		
		System.out.println("Intentando bajaEmpleado - SAEmpleado");
		
		if(daoe.readById(id).getIdEmpleado()== -1) {
			System.out.println("bajaEmpleado No Realizado (no exite) - SAEmpleado");
			return -1;
		}
		else {
			System.out.println("bajaEmpleado Realizado - SAEmpleado");
			return daoe.delete(id);	
		}
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


