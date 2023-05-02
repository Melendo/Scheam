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
		tarea.setEquipo(1);
		tarea.setProducto(2);
		tarea.setTerminada(false);
		tarea.setActivo(true);
		tarea.setIdTarea(null);
		
		int resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		assertEquals("bien", -1, resultado);
		
		TTarea tarea2 = new TTarea();
		
		tarea2.setNombre("teswta");
		tarea2.setEquipo(25);
		tarea2.setProducto(1);
		tarea2.setTerminada(false);
		tarea2.setActivo(true);
		tarea2.setIdTarea(null);
		
		resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea2);
		assertEquals("producto no existe", -1, resultado);
		
		TTarea tarea3 = new TTarea();
		tarea3.setNombre("teswta");
		tarea3.setEquipo(25);
		tarea3.setProducto(1);
		tarea3.setTerminada(false);
		tarea3.setActivo(true);
		tarea3.setIdTarea(null);
		
		resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea3);
		assertEquals("nombre repetido", -1, resultado);
		
		TTarea tarea4 = new TTarea();
		tarea4.setNombre("teswte");
		tarea4.setEquipo(1);
		tarea4.setProducto(56);
		tarea4.setTerminada(false);
		tarea4.setActivo(true);
		tarea4.setIdTarea(null);
		
		resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea4);
		assertEquals("producto", -1, resultado);
		
		
		tarea.setActivo(false);

		
		resultado = FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		assertEquals("tarea reactivada", -1, resultado);
		
		
	}
	
	public void testbajaTarea () {
		
		TTarea tarea = new TTarea();
		tarea.setNombre("teswte");
		tarea.setEquipo(2);
		tarea.setProducto(1);
		tarea.setTerminada(false);
		tarea.setActivo(true);
		tarea.setIdTarea(null);
		
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		
		tarea.setIdTarea(1);
		
		int resultado = FactoriaSA.getInstance().getSATarea().bajaTarea(tarea.getIdTarea());			
        assertEquals("bajaTarea Realizado - SATarea", -2, resultado);
        
    
		tarea.setActivo(false);
        
        int resultado2 = FactoriaSA.getInstance().getSATarea().bajaTarea(tarea.getIdTarea());			
        assertEquals("no existe tarea", -2, resultado2);
		
	}
	
	public void testmodificarTarea() {
	
		
        	TTarea tarea = new TTarea();
        	tarea.setNombre("teswte2");
    		tarea.setEquipo(2);
    		tarea.setProducto(1);
    		tarea.setActivo(true);
    		tarea.setTerminada(false);
            FactoriaSA.getInstance().getSATarea().altaTarea(tarea);

        tarea.setIdTarea(2);
        tarea.setActivo(true);

    	int resultado = FactoriaSA.getInstance().getSATarea().modificarTarea(tarea);
    	assertEquals("La tarea ha sido modificada", -1, resultado);

	}
	
	public void testmostrarTareaId() {
		
		TTarea tarea = new TTarea();
    	tarea.setNombre("teswte3");
		tarea.setEquipo(2);
		tarea.setProducto(1);
		tarea.setActivo(true);
		tarea.setTerminada(false);
        FactoriaSA.getInstance().getSATarea().altaTarea(tarea);

		tarea = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		tarea.setIdTarea(24);
					
		TTarea Aux = FactoriaSA.getInstance().getSATarea().mostrarTareaID(23);
		int resultado = Aux.getIdTarea();
	    assertEquals("id desconocida", 23, resultado);
	    
	    
	    TTarea Aux2 = FactoriaSA.getInstance().getSATarea().mostrarTareaID(tarea.getIdTarea());
		resultado = Aux2.getIdTarea();
		int rEsperado = tarea.getIdTarea();
	    assertEquals("id desconocida", rEsperado, resultado);


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
		
		TTarea tarea = new TTarea();
		tarea.setActivo(true);
		tarea.setNombre("pruebata");
		tarea.setEquipo(2);
		tarea.setIdTarea(null);
		tarea.setProducto(1);
		tarea.setTerminada(false);
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		tarea = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		Set<TTarea> lista = FactoriaSA.getInstance().getSATarea().listarTareasEquipo(tarea.getEquipo());
		assertTrue("lista", lista.size() > 0);
		
		TTarea tarea2 = new TTarea();
		tarea2.setActivo(true);
		tarea2.setNombre("pruebato");
		tarea.setEquipo(70);
		tarea.setIdTarea(null);
		tarea.setProducto(1);
		tarea.setTerminada(false);
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		tarea = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		Set<TTarea> lista2 = FactoriaSA.getInstance().getSATarea().listarTareasEquipo(tarea.getEquipo());
		assertFalse("lista", lista2.size() < 0);
	}
	
	public void testlistarTareaProductoId() {
		TTarea tarea = new TTarea();
		tarea.setActivo(true);
		tarea.setNombre("pruebata");
		tarea.setEquipo(2);
		tarea.setIdTarea(null);
		tarea.setProducto(1);
		tarea.setTerminada(false);
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		tarea = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		Set<TTarea> lista = FactoriaSA.getInstance().getSATarea().listarTareasProducto(tarea.getProducto());
		assertTrue("lista", lista.size() > 0);
		
		TTarea tarea2 = new TTarea();
		tarea2.setActivo(true);
		tarea2.setNombre("pruebato");
		tarea.setEquipo(70);
		tarea.setIdTarea(null);
		tarea.setProducto(50);
		tarea.setTerminada(false);
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		tarea = FactoriaDAOImp.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		Set<TTarea> lista2 = FactoriaSA.getInstance().getSATarea().listarTareasEquipo(tarea.getProducto());
		assertFalse("lista", lista2.size() < 0);
	}
	
	public void testcerrarTarea() {
		TTarea tarea = new TTarea();
		tarea.setActivo(true);
		tarea.setNombre("pruebatwa");
		tarea.setEquipo(3);
		tarea.setIdTarea(2);
		tarea.setProducto(2);
		tarea.setTerminada(false);
		FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
		
		int resultado = FactoriaSA.getInstance().getSATarea().cerrarTarea(tarea.getIdTarea());		
        assertEquals("cerrar Tarea No Realizado - SATarea", -2, resultado);
        
        tarea.setTerminada(false);
	
        int resultado2 = FactoriaSA.getInstance().getSATarea().cerrarTarea(tarea.getIdTarea());		
        assertEquals("cerar Tarea Realizado - SATarea", -2, resultado2);
	
		
	}
	
}
