package Negocio;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Factorias.FactoriaSA;

import junit.framework.TestCase;

public class ClienteTest {

	public void testAltaCliente() {
		// Cliente Distribuidor
		TDistribuidor distribuidor = new TDistribuidor();

		distribuidor.setNombre("PruebaDis");
		distribuidor.setEmail("PruebaEmail");
		distribuidor.setCIF("PruebaCIF");
		distribuidor.setDireccion("PruebaDireccion");

		int resultadoADis = FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);
		assertEquals("El cliente se ha dado de alta", 1, resultadoADis);

		TCliente testCliente = new TDistribuidor();
		testCliente = FactoriaDAO.getInstance().getDaoCliente().readByEmail(distribuidor.getEmail());

		FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		int resultadoADistri2 = FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);
		assertEquals("El cliente se ha dado de alta. Reactivado", 2, resultadoADistri2);

		int resultadoADistri3 = FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);
		assertEquals("El equipo NO se ha dado de alta. Ya existe", -1, resultadoADistri3);

		// CLIENTE PARTICULAR
		TParticular particular = new TParticular();

		particular.setNombre("PruebaPar");
		particular.setEmail("PruebaEmailP");
		particular.setDNI("PruebaDNIP");
		particular.setTelefono(123456789);

		int resultadoAPar = FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);
		assertEquals("El cliente se ha dado de alta", 1, resultadoAPar);

		TCliente tCl1 = new TParticular();

		tCl1 = FactoriaDAO.getInstance().getDaoCliente().readByEmail(particular.getEmail());
		FactoriaDAO.getInstance().getDaoCliente().delete(tCl1.getID());
		
		int resultadoAPar2 = FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);
		assertEquals("El cliente se ha dado de alta. Reactivado", 2, resultadoAPar2);

		int resultadoAPar3 = FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);
		assertEquals("El cliente NO se ha dado de alta. Ya existe", -1, resultadoAPar3);

	}

	public void testBajaProducto() {

		/*
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
	*/
	}

}
