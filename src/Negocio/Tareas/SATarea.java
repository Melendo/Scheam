/**
 * 
 */
package Negocio.Tareas;

import java.util.Set;

import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Empleado.TEmpleado;


public class SATarea implements ISATarea {
	/** 
	* (non-Javadoc)
	* @see ISATarea#altaTarea(TTarea tarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
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

	/** 
	* (non-Javadoc)
	* @see ISATarea#bajaTarea(Integer IDTarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer bajaTarea(Integer IDTarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see ISATarea#modificarTarea(Integer IDTarea)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Integer modificarTarea(Integer IDTarea) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see ISATarea#listarTareas()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
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