package Negocio;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Cliente.TCliente;
import Negocio.Cliente.TDistribuidor;
import Negocio.Cliente.TParticular;
import Negocio.Factorias.FactoriaSA;
import junit.framework.TestCase;

public class ClienteTest extends TestCase {

	public void testAltaCliente() {
		// CLIENTE Distribuidor
		TDistribuidor distribuidor = new TDistribuidor();

		distribuidor.setNombre("PruebaDisA");
		distribuidor.setEmail("PruebaEmailA");
		distribuidor.setCIF("PruebaCIFA");
		distribuidor.setDireccion("PruebaDireccionA");

		//CREO EL CLIENTE arriba
		
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

		//CREO EL CLIENTE arriba
		
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

		// Cliente Distribuidor
		TDistribuidor distribuidor = new TDistribuidor();

		distribuidor.setNombre("PruebaDisB");
		distribuidor.setEmail("PruebaEmailB");
		distribuidor.setCIF("PruebaCIFB");
		distribuidor.setDireccion("PruebaDireccionB");
		
		FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);

		//CREO EL CLIENTE arriba
		
		TCliente testCliente = new TDistribuidor();
		testCliente = FactoriaDAO.getInstance().getDaoCliente().readByEmail(distribuidor.getEmail());

		int resultadoBDis = FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		assertEquals("bajaCliente Realizado - SACliente", 1, resultadoBDis);

		resultadoBDis = FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		assertEquals("bajaCliente ya desactivado", -2, resultadoBDis);

		resultadoBDis = FactoriaDAO.getInstance().getDaoCliente().delete(100000);
		assertEquals("no existe", -1, resultadoBDis);

		// CLIENTE PARTICULAR
		TParticular particular = new TParticular();

		particular.setNombre("PruebaDis");
		particular.setEmail("PruebaEmail");
		particular.setDNI("PruebaDNI");
		particular.setTelefono(123456789);

		FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);

		//CREO EL CLIENTE arriba
		
		TCliente testClientePar = new TDistribuidor();
		testClientePar = FactoriaDAO.getInstance().getDaoCliente().readByEmail(particular.getEmail());

		int resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(testClientePar.getID());
		assertEquals("bajaCliente Realizado - SACliente", 1, resultadoAPar);

		resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(testClientePar.getID());
		assertEquals("bajaCliente ya desactivado", -2, resultadoAPar);

		resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(100000);
		assertEquals("no existe", -1, resultadoAPar);
	}

	public void testModificarCliente() {

		// Cliente Distribuidor
		TDistribuidor distribuidor = new TDistribuidor();

		distribuidor.setNombre("PruebaDisM");
		distribuidor.setEmail("PruebaEmailM");
		distribuidor.setCIF("PruebaCIFM");
		distribuidor.setDireccion("PruebaDireccionM");

		FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);

		//CREA EL CLIENTE arriba
		
		TCliente testCliente = new TDistribuidor();
		testCliente = FactoriaDAO.getInstance().getDaoCliente().readByEmail(distribuidor.getEmail());

		testCliente.setNombre("Modificado1");
		
		int resultadoMDis = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente);
		assertEquals("modificarCliente Realizado - SACliente", 1, resultadoMDis);

		TCliente testCliente2 = new TDistribuidor();
		testCliente2.setID(9999);
		resultadoMDis = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente2);
		assertEquals("cliente no existe", -1, resultadoMDis);

		TCliente testCliente3 = new TDistribuidor();
		testCliente3.setEmail("EmailM");
		testCliente3.setNombre("NombreM");
		
		FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) testCliente3);
		testCliente3.setEmail("Email2M");
		testCliente3.setID(FactoriaDAO.getInstance().getDaoCliente().readByEmail("EmailM").getID());
		
		resultadoMDis = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente3);
		assertEquals("El Email ya existe", -2, resultadoMDis);		
	}

	
	
}
