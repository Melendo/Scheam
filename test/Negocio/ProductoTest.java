package Negocio;

import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Equipo.TEquipo;
import Negocio.Factorias.FactoriaSA;
import Negocio.Producto.TProducto;
import Negocio.Tareas.TTarea;
import junit.framework.TestCase;

public class ProductoTest extends TestCase{
	public void testAltaProducto() {
		TProducto producto = new TProducto();
		producto.setActivo(true);
		producto.setFechalanzamiento(17102003);
		producto.setGenero("Aventura");
		producto.setIdproyecto(null);
		producto.setNombre("Pakimone");
		producto.setPEGI(18);
		producto.setPrecio(15.98);
		producto.setStock(3);
		producto.setTerminado(false);
	
		int resultado = FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
        assertEquals("Todo bien, todo correcto...", 1, resultado);
		
		
        resultado = FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
        assertEquals("existe y activo", -1, resultado);
		
        /*TEquipo equipo = new TEquipo();
        equipo.setActivo(null);
        equipo.setIdEquipo(null);
        equipo.setNombre("EPrueba");

        FactoriaSA.getInstance().getSAEquipo().altaEquipo(equipo);
		
        TTarea tarea = new TTarea();
        tarea.setActivo(true);
        tarea.setEquipo(null);
        tarea.setIdTarea(null);
        tarea.setNombre("aaaaaaaaaaaaaaaaaaaaaaaa");
        tarea.setProducto(1);
        tarea.setTerminada(false);*/
        TProducto productoAux = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
        FactoriaSA.getInstance().getSAProducto().bajaProducto(productoAux.getIdproyecto());
        
        resultado = FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
        assertEquals("altaProducto Realizado (reactivado)", 2, resultado);
        
	}
	public void testBajaProducto() {
		
			TProducto producto = new TProducto();
			producto.setActivo(true);
			producto.setFechalanzamiento(17102003);
			producto.setGenero("Aventura");
			producto.setIdproyecto(null);
			producto.setNombre("Pakimone");
			producto.setPEGI(18);
			producto.setPrecio(15.98);
			producto.setStock(3);
			producto.setTerminado(false);
			
			FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
			
			TProducto productoAux = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
			
			int resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(productoAux.getIdproyecto());			
	        assertEquals("bajaProducto Realizado - SAProducto", 1, resultado);
		
	        resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(productoAux.getIdproyecto());			
	        assertEquals("bajaProducto ya desactivo", -2, resultado);
	        
	        resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(10000);			
	        assertEquals("no existe", -1, resultado);
	        
	        
	        FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
	        
	        TEquipo equipo = new TEquipo();
	        equipo.setActivo(null);
	        equipo.setIdEquipo(null);
	        equipo.setNombre("EPrueba");

	        FactoriaSA.getInstance().getSAEquipo().altaEquipo(equipo);
			
	        TTarea tarea = new TTarea();
	        tarea.setActivo(true);
	        tarea.setEquipo(null);
	        tarea.setIdTarea(null);
	        tarea.setNombre("aaaaaaaaaaaaaaaaaaaaaaaa");
	        tarea.setProducto(1);
	        tarea.setTerminada(false);
	        
	        FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
	        
	        resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(1);		
	        assertEquals("bajaProducto No Realizado (en tarea activa)", -3, resultado);
	        
	        
	        
		
	}

}
