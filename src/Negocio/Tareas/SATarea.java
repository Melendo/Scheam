/**
 * 
 */
package Negocio.Tareas;

import java.util.Set;

import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Producto.TProducto;

import java.util.HashSet;


public class SATarea implements ISATarea {

	public Integer altaTarea(TTarea tarea) {
		
		System.out.println("Intentando altaEmpleado - SATarea");
		TTarea tar = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		if (tarea.getIdTarea() == -1) {
			System.out.println("altaTarea Realizado (creado) - SATarea");
			return FactoriaDAOImp.getInstance().getDaoTarea().create(tarea);
		}
		else {
			
			if (tarea.getProducto() == null) {
				
				System.out.println("altaTarea No Realizado (producto no existe) - SATarea");
				return -1;
			}
			
			if (tarea.getEquipo() == null) {
				System.out.println("altaTarea No Realizado (equipo no existe) - SATarea");
				return -1;
			}
			if (tarea.getActivo()) {
				System.out.println("altaTarea No Realizado (existe y activo) - SATarea");
				return -1;
			} else {
				tarea.setActivo(true);
				tarea.setIdTarea(tar.getIdTarea());
				System.out.println("altaTarea Realizado (reactivado) - SATarea");
				
				if(tarea.getTerminada() == null) {
					tarea.setTerminada(false);
				}
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
		TTarea tareaxnombre = FactoriaDAOImp.getInstance().getDaoTarea().readById(tarea.getIdTarea());
		if (tar.getIdTarea() == -1 || !tar.getActivo()){
			System.out.println("modificarTarea no realizado (tarea no existe o esta inactiva)- SATarea");
				return -1;
				}
		else {
				
			if(tareaxnombre.getIdTarea() != -1) {								
				if (tareaxnombre.getIdTarea() != tarea.getIdTarea())
					return -2;
			}
					
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

	public Set<TTarea> listarTareas() {
		Set<TTarea> lista = FactoriaDAOImp.getInstance().getDaoTarea().readAll();
		System.out.println("mostrarTareas Realizado - SATarea");
		return lista;
	}

	public Set<TTarea> listarTareasEquipo(Integer IDEquipo) {
	    
	    System.out.println("mostrarTareasEquipo Realizado - SATarea");
	    return FactoriaDAOImp.getInstance().getDaoTarea().listarIdEquipo(IDEquipo);
	}

	public Set<TTarea> listarTareasProducto(Integer IDProducto) {
	    System.out.println("listarTareasProducto Realizado - SATarea");
	    return FactoriaDAOImp.getInstance().getDaoTarea().listarIdProducto(IDProducto);
	}

	public TTarea mostrarTareaID(Integer IDTarea) {
		TTarea tar = FactoriaDAOImp.getInstance().getDaoTarea().readById(IDTarea);
		if (tar.getIdTarea() != -1 && tar.getActivo()){
		System.out.println("mostrarTarea Realizado - SATarea");
			return tar;
			}
		else { 
			tar.setIdTarea(-1);
			System.out.println("mostrarTarea no Realizado - SATarea");
			return tar;
		}
	}

	public Integer cerrarTarea(Integer IDTarea) {
	    System.out.println("Intentando cerrarTarea - SATarea");
	    TTarea tar = FactoriaDAOImp.getInstance().getDaoTarea().readById(IDTarea);

	    if (tar.getIdTarea() == -1) {
	        System.out.println("cerrarTarea No Realizado (no existe) - SATarea");
	        return -1;
	    }

	    if (tar.getTerminada()) {
	        System.out.println("cerrarTarea No Realizado (ya estaba cerrada) - SATarea");
	        return -2;
	    }

	    tar.setTerminada(true);
	    int res = FactoriaDAOImp.getInstance().getDaoTarea().modify(tar);

	    if (res == 1) {
	        System.out.println("cerrarTarea Realizado - SATarea");
	        return 1;
	    } else {
	        System.out.println("cerrarTarea No Realizado - SATarea");
	        return -3;
	    }
	}



}