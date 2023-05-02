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

		// Cliente Distribuidor
		TDistribuidor distribuidor = new TDistribuidor();

		distribuidor.setNombre("PruebaDis");
		distribuidor.setEmail("PruebaEmail");
		distribuidor.setCIF("PruebaCIF");
		distribuidor.setDireccion("PruebaDireccion");

		FactoriaSA.getInstance().getSACliente().altaCliente((TDistribuidor) distribuidor);

		TCliente testCliente = new TDistribuidor();
		testCliente = FactoriaDAO.getInstance().getDaoCliente().readByEmail(distribuidor.getEmail());
		
		int resultadoADis = FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		assertEquals("bajaCliente Realizado - SACliente", 1, resultadoADis);
		
		resultadoADis = FactoriaDAO.getInstance().getDaoCliente().delete(testCliente.getID());
		assertEquals("bajaCliente ya desactivado", -2, resultadoADis);

		resultadoADis = FactoriaDAO.getInstance().getDaoCliente().delete(100000);
		assertEquals("no existe", -1, resultadoADis);
		
		// CLIENTE PARTICULAR
		TParticular particular = new TParticular();

		particular.setNombre("PruebaDis");
		particular.setEmail("PruebaEmail");
		particular.setDNI("PruebaDNI");
		particular.setTelefono(123456789);

		FactoriaSA.getInstance().getSACliente().altaCliente((TParticular) particular);

		TCliente testClientePar = new TDistribuidor();
		testClientePar = FactoriaDAO.getInstance().getDaoCliente().readByEmail(particular.getEmail());
		
		int resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(testClientePar.getID());
		assertEquals("bajaCliente Realizado - SACliente", 1, resultadoAPar);
		
		resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(testClientePar.getID());
		assertEquals("bajaCliente ya desactivado", -2, resultadoAPar);

		resultadoAPar = FactoriaDAO.getInstance().getDaoCliente().delete(100000);
		assertEquals("no existe", -1, resultadoAPar);
	}

}
