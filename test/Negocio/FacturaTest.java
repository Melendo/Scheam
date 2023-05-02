package Negocio;

import java.util.HashSet;
import java.util.Set;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Cliente.TCliente;
import Negocio.Cliente.TParticular;
import Negocio.Factorias.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.Factura.TFactura;
import Negocio.Factura.TLineaFactura;
import Negocio.Producto.TProducto;
import junit.framework.TestCase;

public class FacturaTest extends TestCase{
	
	public SAFactura safactura = FactoriaSA.getInstance().getSAFactura();
	
	public void testCrearCarrito () {
		//Se crea un carrito con un id que no pertence a un cliente
		int resultado = safactura.crearCarrito(987654322);
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
		
		resultado = safactura.crearCarrito(cln.getID());
		assertEquals("Carrito creado", 1, resultado);
		
		//Se crea un carrito cuando ya hay otro creado
		resultado = safactura.crearCarrito(cln.getID());
		assertEquals("Carrito no creado (ya hay otro creado)", -1, resultado);
		
		safactura.eliminarCarrito();
	}
	
	public void testEliminarCarrito () {
		//Se intenta eliminar el carrito cuando no hay ninguno creado
		int resultado = safactura.eliminarCarrito();
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
		safactura.crearCarrito(cln.getID());
		
		resultado = safactura.eliminarCarrito();
		assertEquals("Carrito eliminado ", 1, resultado);
	}
	
	public void testListarFacturasCliente () {
		//Listar factura de un cliente que no existe
		Set<TFactura> resultado = safactura.listarFacturasIDCliente(987654322);
		assertEquals("No se ha listado (no existe cliente)", null, resultado);
		resultado = null;
		
	}
	
	
	public void testAnyadirProductoCarrito () {
		//Añadir producto cuando no hay carrito
		TProducto producto = new TProducto();
		producto.setFechalanzamiento(123456);
		producto.setGenero("Terror");
		producto.setNombre("Buscaminas");
		producto.setPEGI(98);
		producto.setPrecio(99.98);
		producto.setStock(4);
		producto.setTerminado(true);
		FactoriaDAO.getInstance().getDaoProducto().create(producto);
		producto = FactoriaDAO.getInstance().getDaoProducto().readByNombre("Buscaminas");
		int resultado = safactura.anyadirProductoaCarrito(producto.getIdproyecto(), 2);
		assertEquals("No se ha añadido el producto (no hay carrito)", -2, resultado);
		
		//Añadir producto que no existe con carrito abierto
		TParticular cliente = new TParticular();
		TCliente cln;
		cliente.setNombre("Mariano");
		cliente.setEmail("marianorajollas@gmail.com");
		cliente.setDNI("2342345M");
		cliente.setTelefono(32432432);
		FactoriaSA.getInstance().getSACliente().altaCliente(cliente);
		cln = FactoriaDAO.getInstance().getDaoCliente().readByEmail("marianorajollas@gmail.com");
		safactura.crearCarrito(cln.getID());
		resultado = safactura.anyadirProductoaCarrito(221312, 2);
		assertEquals("No se ha añadido el producto (no existe el producto)", -1, resultado);
		
		//Añadir un producto que existe a un carrito activo
		resultado = safactura.anyadirProductoaCarrito(producto.getIdproyecto(), 2);
		assertEquals("Se ha añadido el producto ", 1, resultado);
	}
	
	public void testEliminarProductoCarrito () {
		//Eliminar producto cuando no hay carrito
		TProducto producto = new TProducto();
		producto.setFechalanzamiento(123456);
		producto.setGenero("Terror");
		producto.setNombre("Buscaminas");
		producto.setPEGI(98);
		producto.setPrecio(99.98);
		producto.setStock(4);
		producto.setTerminado(true);
		FactoriaDAO.getInstance().getDaoProducto().create(producto);
		producto = FactoriaDAO.getInstance().getDaoProducto().readByNombre("Buscaminas");
		int resultado = safactura.eliminarProductodeCarrito(producto.getIdproyecto(), 2);
		assertEquals("No se ha eliminado el producto (no hay carrito)", -2, resultado);
		
		//Eliminar producto que no existe con carrito abierto
		TParticular cliente = new TParticular();
		TCliente cln;
		cliente.setNombre("Mariano");
		cliente.setEmail("marianorajollas@gmail.com");
		cliente.setDNI("2342345M");
		cliente.setTelefono(32432432);
		FactoriaSA.getInstance().getSACliente().altaCliente(cliente);
		cln = FactoriaDAO.getInstance().getDaoCliente().readByEmail("marianorajollas@gmail.com");
		safactura.crearCarrito(cln.getID());
		
		resultado = safactura.eliminarProductodeCarrito(221312, 2);
		assertEquals("No se ha eliminado el producto (no existe el producto)", -1, resultado);
		
		//Añadir un producto que existe a un carrito activo
		safactura.anyadirProductoaCarrito(producto.getIdproyecto(), 3);
		resultado = safactura.eliminarProductodeCarrito(producto.getIdproyecto(), 2);
		assertEquals("Se ha eliminado el producto ", 1, resultado);
	}
	
	public void testCerrarCarrito () {
		//Cerrar carrito si no hay carrito
		int resultado = safactura.cerrarCarrito();
		assertEquals("No se ha cerrado el carrito (no hay carrito)", -2, resultado);
		
		//Cerrar el carrito si esta vacio
		
		TParticular cliente = new TParticular();
		TCliente cln;
		cliente.setNombre("Mariano");
		cliente.setEmail("marianorajollas@gmail.com");
		cliente.setDNI("2342345M");
		cliente.setTelefono(32432432);
		FactoriaSA.getInstance().getSACliente().altaCliente(cliente);
		cln = FactoriaDAO.getInstance().getDaoCliente().readByEmail("marianorajollas@gmail.com");
		safactura.crearCarrito(cln.getID());
		
		resultado = safactura.cerrarCarrito();
		assertEquals("No se ha cerrado el carrito (no hay carrito)", -1, resultado);
		
		
	}
	
	public void testMostrarCarrito () {
		//Mostrar carrito si no hay carrito
		Set<TLineaFactura> resultado = safactura.mostrarCarrito();
		assertEquals("No se ha cerrado el carrito (no hay carrito)", null , resultado);
		
		//MostrarCarrito si esta abieto
		TParticular cliente = new TParticular();
		TCliente cln;
		cliente.setNombre("Mariano");
		cliente.setEmail("marianorajollas@gmail.com");
		cliente.setDNI("2342345M");
		cliente.setTelefono(32432432);
		FactoriaSA.getInstance().getSACliente().altaCliente(cliente);
		cln = FactoriaDAO.getInstance().getDaoCliente().readByEmail("marianorajollas@gmail.com");
		
		safactura.crearCarrito(cln.getID());
		Set<TLineaFactura> rs = new HashSet<TLineaFactura>();
		
		resultado = safactura.mostrarCarrito();
		assertEquals("Se muestra el carrito ", rs, resultado);
		
	}
	
}
