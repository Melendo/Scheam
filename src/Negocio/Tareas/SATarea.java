/**
 * 
 */
package Negocio.Tareas;

import java.util.Set;

import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Empleado.TEmpleado;


public class SATarea implements ISATarea {

	public Integer altaTarea(TTarea tarea) {
		
		System.out.println("Intentando altaEmpleado - SATarea");
		TTarea tar = FactoriaDAOImp.getInstance().getDaoTarea().readById(tarea.getIdTarea());

		if (tar.getIdTarea().equals("-1")) {
			System.out.println("altaTareaRealizado (creado) - SATarea");
			return FactoriaDAOImp.getInstance().getDaoTarea().create(tarea);
		} else {
			if (tar.getActivo()) {
				System.out.println("altaTarea No Realizado (existe y activo) - SATarea");
				return -1;
			} else {
				tarea.setActivo(true);
				tarea.setIdTarea(tar.getIdTarea());
				System.out.println("altaTarea Realizado (reactivado) - SATarea");
				FactoriaDAOImp.getInstance().getDaoTarea().modify(tarea);
				return 2;
			}
		}
	}


	public Integer bajaTarea(Integer IDTarea) {
		System.out.println("Intentando bajaTarea - SATarea");
		TTarea tar = FactoriaDAOImp.getInstance().getDaoTarea().readById(IDTarea);

		if (tar.getIdTarea() == -1) {
			System.out.println("bajaTarea No Realizado (no exite) - SATarea");
			return -1;
		}
		
		if(tar.getActivo()) {
			System.out.println("bajaTarea Realizado - SATarea");
			return FactoriaDAOImp.getInstance().getDaoTarea().delete(IDTarea);
		} else{
			return -2;
		}
	}

	
	public Integer modificarTarea(TTarea tarea) {
		
		TTarea tar = FactoriaDAOImp.getInstance().getDaoTarea().readById(tarea.getIdTarea());
		if (tar.getIdTarea() == -1 || !tar.getActivo()){
		System.out.println("modificarTarea no realizado (tarea no existe o esta inactivo)- SATarea");
			return -1;
			} else {
			if (tarea.getIdTarea() != null  && FactoriaDAOImp.getInstance().getDaoTarea().readById(tarea.getIdTarea()).getIdTarea() != -1){
				System.out.println("modificarTarea no realizado (tarea tiene un ID coincidente)- SATarea");
				return -2;
				}
			else {
					
				if (tarea.getIdTarea() == null)
					tarea.setIdTarea(tar.getIdTarea());
				if (tarea.getNombre() == null)
					tarea.setNombre(tar.getNombre());
				if (tarea.getProducto() == null)
					tarea.setProducto(tar.getProducto());
				if (tarea.getEquipo() == null)
					tarea.setEquipo(tar.getEquipo());
				if (tarea.getTerminada() == null)
					tarea.setTerminada(tar.getTerminada());
				if(tarea.getActivo() == null) {
					tarea.setActivo(true);
				}
				System.out.println("modificarTarea Realizado - SATarea");
				return FactoriaDAOImp.getInstance().getDaoTarea().modify(tarea);
			}				
		}
	}


	public Set listarTareas() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see ISATarea#listarTareasEquipo(Integer IDEquipo)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set listarTareasEquipo(Integer IDEquipo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see ISATarea#listarTareasProducto(Integer IDProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Set listarTareasProducto(Integer IDProducto) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see ISATarea#mostrarTareaID(Integer IDTarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TTarea mostrarTareaID(Integer IDTarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see ISATarea#cerrarTarea(Integer IDTarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer cerrarTarea(Integer IDTarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}