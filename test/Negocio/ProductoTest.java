package Negocio;

import java.util.Set;

import Integracion.Factorias.FactoriaDAOImp;
import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Factorias.FactoriaSA;
import Negocio.Producto.TProducto;
import Negocio.Tareas.TTarea;
import junit.framework.TestCase;

public class ProductoTest extends TestCase{
	
	public ProductoTest() {
		/*
		TProducto producto = new TProducto();
		producto.setActivo(true);
		producto.setFechalanzamiento(17102003);
		producto.setGenero("Aventura");
		producto.setIdproyecto(null);
		producto.setNombre("TestNormal");
		producto.setPEGI(18);
		producto.setPrecio(15.98);
		producto.setStock(3);
		producto.setTerminado(false);
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
		producto = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
		
		TProducto producto2 = new TProducto();
		producto2.setActivo(true);
		producto2.setFechalanzamiento(17102003);
		producto2.setGenero("Aventura");
		producto2.setIdproyecto(null);
		producto2.setNombre("TestBaja");
		producto2.setPEGI(18);
		producto2.setPrecio(15.98);
		producto2.setStock(3);
		producto2.setTerminado(false);
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto2);
		producto2 = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto2.getNombre());
		FactoriaSA.getInstance().getSAProducto().bajaProducto(producto2.getIdproyecto());
		
		TProducto producto3 = new TProducto();
		producto3.setActivo(true);
		producto3.setFechalanzamiento(17102003);
		producto3.setGenero("Aventura");
		producto3.setIdproyecto(null);
		producto3.setNombre("TestCerrar");
		producto3.setPEGI(18);
		producto3.setPrecio(15.98);
		producto3.setStock(3);
		producto3.setTerminado(false);
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto3);
		producto3 = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto3.getNombre());
		FactoriaSA.getInstance().getSAProducto().cerrarProducto(producto3.getIdproyecto());
		
		TProducto producto4 = new TProducto();
		producto4.setActivo(true);
		producto4.setFechalanzamiento(17102003);
		producto4.setGenero("Aventura");
		producto4.setIdproyecto(null);
		producto4.setNombre("TestConTarea");
		producto4.setPEGI(18);
		producto4.setPrecio(15.98);
		producto4.setStock(3);
		producto4.setTerminado(false);
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto3);
		producto4 = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto4.getNombre());
		*/
		
		
	}
	
	
	
	
	public void testAltaProducto() {
		TProducto producto = new TProducto();
		producto.setActivo(true);
		producto.setFechalanzamiento(17102003);
		producto.setGenero("Aventura");
		producto.setIdproyecto(null);
		producto.setNombre("AltaProdN");
		producto.setPEGI(18);
		producto.setPrecio(15.98);
		producto.setStock(3);
		producto.setTerminado(false);
	
		int resultado = FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
        assertEquals("Todo bien, todo correcto...", 1, resultado);
		
		
        resultado = FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
        assertEquals("existe y activo", -1, resultado);
		
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
			producto.setNombre("TestBajaN");
			producto.setPEGI(18);
			producto.setPrecio(15.98);
			producto.setStock(3);
			producto.setTerminado(false);
			
			FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
			producto = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
			
			int resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(producto.getIdproyecto());		
	        assertEquals("bajaProducto Realizado - SAProducto", 1, resultado);
		
	        resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(producto.getIdproyecto());	
	        assertEquals("bajaProducto ya desactivo", -2, resultado);
	        
	        resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(10000);			
	        assertEquals("no existe", -1, resultado);
	        
	    
	        
	        TEquipoDesarrollo equipo = new TEquipoDesarrollo();
	        equipo.setActivo(null);
	        equipo.setIdEquipo(null);
	        equipo.setNombre("EPrueba");
	        equipo.setTecnologia("iuuh");

	        FactoriaSA.getInstance().getSAEquipo().altaEquipo(equipo);
			
	        
	        TEquipo equipoAux = FactoriaDAOImp.getInstance().getDaoEquipo().readByNombre(equipo.getNombre());
	        
	        TTarea tarea = new TTarea();
	        tarea.setActivo(true);
	        tarea.setEquipo(equipoAux.getIdEquipo());
	        tarea.setIdTarea(null);
	        tarea.setNombre("TPrueba");
	        tarea.setProducto(producto.getIdproyecto());
	        tarea.setTerminada(false);
	        
	        FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
	        
	        resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(producto.getIdproyecto());		
	        assertEquals("bajaProducto No Realizado (en tarea activa)", -3, resultado);
	        
	        
	        
		
	}
	
	public void testModificarProducto() {
		
		TProducto producto = new TProducto();
		producto.setActivo(true);
		producto.setFechalanzamiento(17102003);
		producto.setGenero("Aventura");
		producto.setIdproyecto(null);
		producto.setNombre("PakimoneModificar");
		producto.setPEGI(18);
		producto.setPrecio(15.98);
		producto.setStock(3);
		producto.setTerminado(false);
		
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
		
		//-------------
		producto.setIdproyecto(1000);
		int resultado = FactoriaSA.getInstance().getSAProducto().modificarProducto(producto);
		assertEquals("Producto no exite", -1, resultado);
		//-------------
		producto = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());//pone bn el id
		FactoriaDAOImp.getInstance().getDaoProducto().delete(producto.getIdproyecto());

		resultado = FactoriaSA.getInstance().getSAProducto().modificarProducto(producto);
		assertEquals("no activo", -3, resultado);
		//-------------
		 
		 
		TProducto producto2 = new TProducto();
		producto2.setActivo(true);
		producto2.setFechalanzamiento(17102003);
		producto2.setGenero("Aventura");
		producto2.setIdproyecto(null);
		producto2.setNombre("CopiaEsto");
		producto2.setPEGI(18);
		producto2.setPrecio(15.98);
		producto2.setStock(3);
		producto2.setTerminado(false);
		
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto2);
		producto2 = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto2.getNombre());
		
		TProducto producto3 = new TProducto();
		producto3.setActivo(true);
		producto3.setFechalanzamiento(17102003);
		producto3.setGenero("Aventura");
		producto3.setIdproyecto(null);
		producto3.setNombre("VoyACopiar");
		producto3.setPEGI(18);
		producto3.setPrecio(15.98);
		producto3.setStock(3);
		producto3.setTerminado(false);
		
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto3);
		producto3 = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto3.getNombre());
		
		producto3.setNombre(producto2.getNombre());
		resultado = FactoriaSA.getInstance().getSAProducto().modificarProducto(producto3);
		assertEquals("nombre repe", -2, resultado);
		 
		 
		 
		producto3.setNombre("OtroNom");
		resultado = FactoriaSA.getInstance().getSAProducto().modificarProducto(producto3);
		assertEquals("nombre repe", 1, resultado);
		 
	}
	
	public void testListarProductos() {	
		
		TProducto producto = new TProducto();
		producto.setActivo(true);
		producto.setFechalanzamiento(17102003);
		producto.setGenero("Aventura");
		producto.setIdproyecto(null);
		producto.setNombre("TestListar");
		producto.setPEGI(18);
		producto.setPrecio(15.98);
		producto.setStock(3);
		producto.setTerminado(false);
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
		producto = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
		
		Set<TProducto> lista = FactoriaSA.getInstance().getSAProducto().listarProductos();
    	assertTrue("Como hemos metido datos, el listar debe tener al menos un producto", lista.size() > 0);
	}
	
	public void testMostrarProductoID() {
		
		TProducto producto = new TProducto();
		producto.setActivo(true);
		producto.setFechalanzamiento(17102003);
		producto.setGenero("Aventura");
		producto.setIdproyecto(null);
		producto.setNombre("TestMostrarId");
		producto.setPEGI(18);
		producto.setPrecio(15.98);
		producto.setStock(3);
		producto.setTerminado(false);
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
		producto = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
					
		TProducto Aux = FactoriaSA.getInstance().getSAProducto().mostrarProductoID(10000);
		int resultado = Aux.getIdproyecto();
	    assertEquals("id desconocida", -1, resultado);
	    
	    
	    TProducto Aux2 = FactoriaSA.getInstance().getSAProducto().mostrarProductoID(producto.getIdproyecto());
		resultado = Aux2.getIdproyecto();
		int rEsperado = producto.getIdproyecto();
	    assertEquals("id desconocida", rEsperado, resultado);
	}
	
	public void testCerrarProducto() {
		
		TProducto producto = new TProducto();
		producto.setActivo(true);
		producto.setFechalanzamiento(17102003);
		producto.setGenero("Aventura");
		producto.setIdproyecto(null);
		producto.setNombre("TestCerrarN");
		producto.setPEGI(18);
		producto.setPrecio(15.98);
		producto.setStock(3);
		producto.setTerminado(false);
		
		FactoriaSA.getInstance().getSAProducto().altaProducto(producto);
		producto = FactoriaDAOImp.getInstance().getDaoProducto().readByNombre(producto.getNombre());
		
		int resultado = FactoriaSA.getInstance().getSAProducto().cerrarProducto(producto.getIdproyecto());		
        assertEquals("cerar Producto Realizado - SAProducto", 1, resultado);
	
        resultado = FactoriaSA.getInstance().getSAProducto().cerrarProducto(producto.getIdproyecto());	
        assertEquals("cerrar Producto ya desactivo", -2, resultado);
        
        resultado = FactoriaSA.getInstance().getSAProducto().cerrarProducto(10000);			
        assertEquals("no existe", -1, resultado);
        
    
        
        TEquipoDesarrollo equipo = new TEquipoDesarrollo();
        equipo.setActivo(null);
        equipo.setIdEquipo(null);
        equipo.setNombre("EPrueba");
        equipo.setTecnologia("iuuh");

        FactoriaSA.getInstance().getSAEquipo().altaEquipo(equipo);
		
        
        TEquipo equipoAux = FactoriaDAOImp.getInstance().getDaoEquipo().readByNombre(equipo.getNombre());
        
        TTarea tarea = new TTarea();
        tarea.setActivo(true);
        tarea.setEquipo(equipoAux.getIdEquipo());
        tarea.setIdTarea(null);
        tarea.setNombre("TPrueba");
        tarea.setProducto(producto.getIdproyecto());
        tarea.setTerminada(false);
        
        FactoriaSA.getInstance().getSATarea().altaTarea(tarea);
        
        resultado = FactoriaSA.getInstance().getSAProducto().bajaProducto(producto.getIdproyecto());		
        assertEquals("cerrarProducto No Realizado (en tarea activa)", -3, resultado);
		
		
		
	}
	
	

}
