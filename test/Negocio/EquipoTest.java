package Negocio;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Factorias.FactoriaSA;
import Negocio.Equipo.SAEquipo;
import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;


import junit.framework.TestCase;

public class EquipoTest extends TestCase {

	public void testAltaEquipo() {
		
		//EQUIPO DESARROLLO
		TEquipoDesarrollo tedes = new TEquipoDesarrollo();
		
		tedes.setNombre("PruebaDes");
		tedes.setTecnologia("PruebaTech");
		
		int resultadoADes = FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDesarrollo) tedes);	
        assertEquals("El equipo se ha dado de alta", 1, resultadoADes);
        
        
        TEquipo te = new TEquipoDesarrollo();     
        te = FactoriaDAO.getInstance().getDaoEquipo().readByNombre(tedes.getNombre());
        
        FactoriaDAO.getInstance().getDaoEquipo().delete(te.getIdEquipo());
        int resultadoADes2 = FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDesarrollo) tedes);
        assertEquals("El equipo se ha dado de alta. Reactivado", 2, resultadoADes2);
        
        
        int resultadoADes3 = FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDesarrollo) tedes);
        assertEquals("El equipo NO se ha dado de alta. Ya existe", -1, resultadoADes3);
        
        //EQUIPO DISEÑO
        TEquipoDisenio tedis = new TEquipoDisenio();
		
		tedis.setNombre("PruebaDis");
		tedis.setCampoDisenio("PruebaCDis");
		
		int resultadoADis = FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDisenio) tedis);	
        assertEquals("El equipo se ha dado de alta", 1, resultadoADis);
        
        TEquipo te1 = new TEquipoDisenio();
        
        te1 = FactoriaDAO.getInstance().getDaoEquipo().readByNombre(tedis.getNombre());
        FactoriaDAO.getInstance().getDaoEquipo().delete(te1.getIdEquipo());
        int resultadoADis2 = FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDisenio) tedis);
        assertEquals("El equipo se ha dado de alta. Reactivado", 2, resultadoADis2);
        
        int resultadoADis3 = FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDisenio) tedis);
        assertEquals("El equipo NO se ha dado de alta. Ya existe", -1, resultadoADis3);
       
	}
}
