package Negocio;

import java.util.Set;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Factorias.FactoriaSA;
import Negocio.Factura.TFactura;
import junit.framework.TestCase;

public class FacturaTest extends TestCase{
	
	public void testCrearCarrito () {
		//Se crea un carrito con un id que no pertence a un cliente
		int resultado = FactoriaSA.getInstance().getSAFactura().crearCarrito(987654322);
		 assertEquals("Carrito no creado(no hay cliente con ese id", -1, resultado);
		 
		//Se crea un carrito con un cliente existente
		TParticular cliente = new TParticular();
		TCliente cln;
		cliente.setNombre("Mariano");
		cliente.setEmail("marianorajollas@gmail.com");
		cliente.setDNI("2342345M");
		cliente.setTelefono(32432432);
		FactoriaSA.getInstance().getSACliente().altaCliente(cliente);
		cln = FactoriaDAO.getInstance().getDaoCliente().readByEmail("marianorajollas@gmail.com");
		
		resultado = FactoriaSA.getInstance().getSAFactura().crearCarrito(cln.getID());
		assertEquals("Carrito creado", 1, resultado);
		
		//Se crea un carrito cuando ya hay otro creado
		resultado = FactoriaSA.getInstance().getSAFactura().crearCarrito(cln.getID());
		assertEquals("Carrito no creado (ya hay otro creado)", -1, resultado);
		
		FactoriaSA.getInstance().getSAFactura().eliminarCarrito();
	}
	
	public void testEliminarCarrito () {
		//Se intenta eliminar el carrito cuando no hay ninguno creado
		int resultado = FactoriaSA.getInstance().getSAFactura().eliminarCarrito();
		assertEquals("Carrito no eliminado (no esta abierto)", -2, resultado);
		
		//Se elimina el carrito cuando esta creado
		
		TParticular cliente = new TParticular();
		TCliente cln;
		cliente.setNombre("Mariano");
		cliente.setEmail("marianorajollas@gmail.com");
		cliente.setDNI("2342345M");
		cliente.setTelefono(32432432);
		FactoriaSA.getInstance().getSACliente().altaCliente(cliente);
		cln = FactoriaDAO.getInstance().getDaoCliente().readByEmail("marianorajollas@gmail.com");
		FactoriaSA.getInstance().getSAFactura().crearCarrito(cln.getID());
		
		resultado = FactoriaSA.getInstance().getSAFactura().eliminarCarrito();
		assertEquals("Carrito eliminado ", 1, resultado);
	}
	
	public void testListarFacturasCliente () {
		//Listar factura de un cliente que no existe
		Set<TFactura> resultado = FactoriaSA.getInstance().getSAFactura().listarFacturasIDCliente(987654322);
		assertEquals("Carrito eliminado ", 1, resultado);
		
		//Listar factura de 
	}
	
	public void testMostrarFacturaID () {
		
	}
	
	public void testAnyadirProductoCarrito () {
		
	}
	
	public void testEliminarProductoCarrito () {
		
	}
	
	public void testCerrarCarrito () {
		
	}
	
	public void testMostrarCarrito () {
		
	}
	
}
