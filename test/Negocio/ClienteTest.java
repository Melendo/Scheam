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

		// CREO EL CLIENTE arriba

		int resultadoADis = FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);
		assertEquals("El cliente se ha dado de alta D", 1, resultadoADis);

		TCliente testCliente = new TDistribuidor();
		testCliente = FactoriaDAO.getInstance().getDaoCliente().readByEmail(distribuidor.getEmail());

		FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		int resultadoADistri2 = FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);
		assertEquals("El cliente se ha dado de alta. Reactivado D", 2, resultadoADistri2);

		int resultadoADistri3 = FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);
		assertEquals("El equipo NO se ha dado de alta. Ya existe D", -1, resultadoADistri3);

		// CLIENTE PARTICULAR
		TParticular particular = new TParticular();

		particular.setNombre("PruebaPar");
		particular.setEmail("PruebaEmailP");
		particular.setDNI("PruebaDNIP");
		particular.setTelefono(123456789);

		// CREO EL CLIENTE arriba

		int resultadoAPar = FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);
		assertEquals("El cliente se ha dado de alta P", 1, resultadoAPar);

		TCliente tCl1 = new TParticular();

		tCl1 = FactoriaDAO.getInstance().getDaoCliente().readByEmail(particular.getEmail());
		FactoriaDAO.getInstance().getDaoCliente().delete(tCl1.getID());

		int resultadoAPar2 = FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);
		assertEquals("El cliente se ha dado de alta. Reactivado P", 2, resultadoAPar2);

		int resultadoAPar3 = FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);
		assertEquals("El cliente NO se ha dado de alta. Ya existe P", -1, resultadoAPar3);

	}

	public void testBajaProducto() {

		// Cliente Distribuidor
		TDistribuidor distribuidor = new TDistribuidor();

		distribuidor.setNombre("PruebaDisB");
		distribuidor.setEmail("PruebaEmailB");
		distribuidor.setCIF("PruebaCIFB");
		distribuidor.setDireccion("PruebaDireccionB");

		FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);

		// CREO EL CLIENTE arriba

		TCliente testCliente = new TDistribuidor();
		testCliente = FactoriaDAO.getInstance().getDaoCliente().readByEmail(distribuidor.getEmail());

		int resultadoBDis = FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		assertEquals("bajaCliente Realizado D - SACliente", 1, resultadoBDis);

		resultadoBDis = FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		assertEquals("bajaCliente ya desactivado D", -2, resultadoBDis);

		resultadoBDis = FactoriaDAO.getInstance().getDaoCliente().delete(100000);
		assertEquals("no existe", -1, resultadoBDis);

		// CLIENTE PARTICULAR
		TParticular particular = new TParticular();

		particular.setNombre("PruebaPar");
		particular.setEmail("PruebaEmail");
		particular.setDNI("PruebaDNI");
		particular.setTelefono(123456789);

		FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);

		// CREO EL CLIENTE arriba

		TCliente testClientePar = new TDistribuidor();
		testClientePar = FactoriaDAO.getInstance().getDaoCliente().readByEmail(particular.getEmail());

		int resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(testClientePar.getID());
		assertEquals("bajaCliente Realizado - SACliente P", 1, resultadoAPar);

		resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(testClientePar.getID());
		assertEquals("bajaCliente ya desactivado P", -2, resultadoAPar);

		resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(100000);
		assertEquals("no existe P", -1, resultadoAPar);
	}

	public void testModificarCliente() {

		// Cliente Distribuidor
		TDistribuidor distribuidor = new TDistribuidor();

		distribuidor.setNombre("PruebaDisM");
		distribuidor.setEmail("PruebaEmailM");
		distribuidor.setCIF("PruebaCIFM");
		distribuidor.setDireccion("PruebaDireccionM");

		FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);

		// CREA EL CLIENTE arriba

		TCliente testCliente = new TDistribuidor();
		testCliente = FactoriaDAO.getInstance().getDaoCliente().readByEmail(distribuidor.getEmail());

		testCliente.setNombre("Modificado1");

		int resultadoMDis = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente);
		assertEquals("modificarCliente Realizado D - SACliente", 1, resultadoMDis);

		TCliente testCliente2 = new TDistribuidor();
		testCliente2.setID(9999);
		resultadoMDis = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente2);
		assertEquals("cliente no existe D", -1, resultadoMDis);

		TCliente testCliente3 = new TDistribuidor();
		testCliente3.setEmail("EmailM");
		testCliente3.setNombre("NombreM");

		FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) testCliente3);
		testCliente3.setEmail("Email2M");
		testCliente3.setID(FactoriaDAO.getInstance().getDaoCliente().readByEmail("EmailM").getID());

		resultadoMDis = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente3);
		assertEquals("El Email ya existe D", -2, resultadoMDis);

		// Cliente Distribuidor
		TParticular particular = new TParticular();

		particular.setNombre("PruebaDisMP");
		particular.setEmail("PruebaEmailMP");
		particular.setDNI("PruebaDNIMP");
		particular.setTelefono(987654321);

		FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);

		// CREA EL CLIENTE arriba

		TCliente testClienteP = new TParticular();
		testClienteP = FactoriaDAO.getInstance().getDaoCliente().readByEmail(particular.getEmail());

		testClienteP.setNombre("Modificado2");

		int resultadoMPar = FactoriaDAO.getInstance().getDaoCliente().modify(testClienteP);
		assertEquals("modificarCliente Realizado P - SACliente", 1, resultadoMDis);

		TCliente testCliente2P = new TParticular();
		testCliente2P.setID(9999);
		resultadoMPar = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente2);
		assertEquals("cliente no existe P", -1, resultadoMPar);

		TCliente testCliente3P = new TParticular();
		testCliente3P.setEmail("EmailMP");
		testCliente3P.setNombre("NombreMP");

		FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) testCliente3P);
		testCliente3.setEmail("Email2MP");
		testCliente3.setID(FactoriaDAO.getInstance().getDaoCliente().readByEmail("EmailMP").getID());

		resultadoMPar = FactoriaDAO.getInstance().getDaoCliente().modify(testCliente3P);
		assertEquals("El Email ya existe P", -2, resultadoMPar);
	}

}
