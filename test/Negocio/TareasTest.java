package Negocio;

import java.util.Set;

import Integracion.Factorias.FactoriaDAO;
import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Empleado.TEmpleado;
import Negocio.Factorias.FactoriaSA;
import Negocio.Producto.TProducto;
import Negocio.Tareas.TTarea;
import junit.framework.TestCase;

public class TareasTest extends TestCase{
	
	public void testaltaTarea () {
		TTarea tarea = new TTarea();
		
		tarea.setNombre("teswt");
		tarea.setEquipo(12);
		tarea.setProducto(30);
		tarea.setTerminada(false);
		tarea.setActivo(true);
		tarea.setIdTarea(null);
		
		int resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		assertEquals("bien", -1, resultado);
		
		resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		assertEquals("existe y activa", -1, resultado);
		
		
		TTarea tarea2 = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		FactoriaSA.getInstance().getSATarea().bajaTarea(tarea2.getIdTarea());
		
		 resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
	     assertEquals("altaProducto Realizado (reactivado)", 2, resultado);
	}
	
	public void testbajaTarea () {
		
		TTarea tarea = new TTarea();
		tarea.setNombre("teswte");
		tarea.setEquipo(12);
		tarea.setProducto(30);
		tarea.setTerminada(false);
		tarea.setActivo(true);
		tarea.setIdTarea(null);
		
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		
		TTarea tarea2 = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		int resultado = FactoriaSA.getInstance().getSATarea().bajaTarea(tarea2.getIdTarea());			
        assertEquals("bajaTarea Realizado - SATarea", 1, resultado);
	
        resultado = FactoriaSA.getInstance().getSATarea().bajaTarea(tarea2.getIdTarea());			
        assertEquals("bajaProducto ya desactivo", -2, resultado);
        
        resultado = FactoriaSA.getInstance().getSATarea().bajaTarea(20);			
        assertEquals("no existe", -1, resultado);
        
		
	}
	
	public void testmodificarTarea() {
		
		if (FactoriaDAO.getInstance().getDaoTarea().readById(2).getIdTarea() == -1) {
        	TTarea tarea = new TTarea();
        	tarea.setNombre("teswte2");
    		tarea.setEquipo(34);
    		tarea.setProducto(91);
    		tarea.setTerminada(false);
            FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
    	}
    	
    	TTarea tarea = FactoriaDAO.getInstance().getDaoTarea().readById(2);
    	tarea.setProducto(2);
    	tarea.setEquipo(1);
    	int resultado = FactoriaSA.getInstance().getSATarea().modificarTarea(tarea);
    	assertEquals("La tarea ha sido modificada", 1, resultado);
    	
    	TTarea tarea2 = new TTarea();
    	tarea2.setIdTarea(99);
    	resultado = FactoriaSA.getInstance().getSATarea().modificarTarea(tarea2);
    	assertEquals("La tarea no existe en la base de datos", -1, resultado);
	}
	
	public void testmostrarTareaId() {
		
	}
	
	public void testlistarTareas() {
		
		TTarea tarea = new TTarea();
		tarea.setActivo(true);
		tarea.setNombre("pruebata");
		tarea.setEquipo(2);
		tarea.setIdTarea(null);
		tarea.setProducto(1);
		tarea.setTerminada(false);
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		tarea = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		Set<TTarea> lista = FactoriaSA.getInstance().getSATarea().listarTareas();
    	assertTrue("lista", lista.size() > 0);
	}
	
	public void testlistarTareaEquipoId() {
		
	}
	
	public void testlistarTareaProductoId() {
		
	}
	
	public void testcerrarTarea() {
		
	}
	
}
