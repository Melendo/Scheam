package Negocio;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Empleado.TEmpleado;
import Negocio.Equipo.TEquipo;
import Negocio.Equipo.TEquipoDesarrollo;
import Negocio.Equipo.TEquipoDisenio;
import Negocio.Equipo.TVinculacion;
import Negocio.Factorias.FactoriaSA;
import Negocio.Producto.TProducto;
import Negocio.Tareas.TTarea;
import junit.framework.TestCase;

public class EquipoTest extends TestCase {
	
    Connection con;

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
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from equipo where id_equipo = ?");
			ps.setInt(1, tedes.getIdEquipo());			
			ps.executeUpdate();
			
			ps = (PreparedStatement) con.prepareStatement("delete from equipodesarrollo where id_equipo = ?");
			ps.setInt(1, tedes.getIdEquipo());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
        
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
       
        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from equipo where id_equipo = ?");
			ps.setInt(1, tedis.getIdEquipo());
			
			ps.executeUpdate();
			
			ps = (PreparedStatement) con.prepareStatement("delete from equipodisenyo where id_equipo = ?");
			ps.setInt(1, tedis.getIdEquipo());
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
    	
    	
	}
	
	public void testBajaEquipo() {
		
		TEquipoDesarrollo equipo = new TEquipoDesarrollo();
		equipo.setNombre("PruebaDes");
		equipo.setTecnologia("PruebaTech");
		
		FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDesarrollo) equipo);
		TEquipo teAux = new TEquipoDesarrollo();     
	    teAux = FactoriaDAO.getInstance().getDaoEquipo().readByNombre(equipo.getNombre());
		
	    
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
		
		FactoriaDAO.getInstance().getDaoProducto().create(producto);
		TProducto pAux = new TProducto();
		pAux = FactoriaDAO.getInstance().getDaoProducto().readByNombre(producto.getNombre());
		
	    
	    TTarea tarea = new TTarea();		
		tarea.setNombre("teswt");
		tarea.setEquipo(teAux.getIdEquipo());
		tarea.setProducto(pAux.getIdproyecto());
		
		FactoriaDAO.getInstance().getDaoTarea().create(tarea);
		TTarea tAux = new TTarea();	
		tAux = FactoriaDAO.getInstance().getDaoTarea().readByNombre(tarea.getNombre());
		
		
		
		int res = FactoriaSA.getInstance().getSAEquipo().bajaEquipo(teAux.getIdEquipo());
        assertEquals("El equipo no se ha dado de Baja. Tarea pendiente", -4, res);
		
        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from equipo where nombre = ?");
			ps.setString(1, teAux.getNombre());			
			ps.executeUpdate();
			
			ps = (PreparedStatement) con.prepareStatement("delete from equipodesarrollo where id_equipo = ?");
			ps.setInt(1, teAux.getIdEquipo());
			ps.executeUpdate();

			ps = (PreparedStatement) con.prepareStatement("delete from productos where nombre = ?");
			ps.setString(1, pAux.getNombre());
			ps.executeUpdate();
					
			ps = (PreparedStatement) con.prepareStatement("delete from tarea where nombre = ?");
			ps.setString(1, tAux.getNombre());
			ps.executeUpdate();
			
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
        TEmpleado empleado = new TEmpleado();
        empleado.setDNI("12345678A");
        empleado.setNombre("Juan");
        empleado.setApellidos("Perez");
        empleado.setE_mail("juan@ucm.es");
        empleado.setTlfn(123456789);
        empleado.setSueldo(1500.0);
        
        FactoriaDAO.getInstance().getDaoEmpleado().create(empleado);
        TEmpleado temAux = new TEmpleado();
        temAux = FactoriaDAO.getInstance().getDaoEmpleado().readByDNI(empleado.getDNI());
				
		
        TEquipoDesarrollo equipo1 = new TEquipoDesarrollo();
		equipo1.setNombre("PruebaDes1");
		equipo1.setTecnologia("PruebaTech1");
		
		FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDesarrollo) equipo1);		
		TEquipo teAux1 = new TEquipoDesarrollo();     
	    teAux1 = FactoriaDAO.getInstance().getDaoEquipo().readByNombre(equipo1.getNombre());
		
	    TVinculacion tvin = new TVinculacion();
        tvin.setId_1(teAux1.getIdEquipo());
        tvin.setId_2(temAux.getIdEmpleado());
        
		FactoriaSA.getInstance().getSAEquipo().anyadirIntegrante(tvin);		

		 int res2 = FactoriaSA.getInstance().getSAEquipo().bajaEquipo(teAux1.getIdEquipo());
	        assertEquals("El equipo se ha dado de Baja", 1, res2);
     
        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from equipo where nombre = ?");
			ps.setString(1, teAux1.getNombre());			
			ps.executeUpdate();
			
			ps = (PreparedStatement) con.prepareStatement("delete from equipodesarrollo where id_equipo = ?");
			ps.setInt(1, teAux1.getIdEquipo());
			ps.executeUpdate();

			ps = (PreparedStatement) con.prepareStatement("delete from empleados where DNI = ?");
			ps.setString(1, temAux.getDNI());
			ps.executeUpdate();
			
			ps = (PreparedStatement) con.prepareStatement("delete from pertenece where id_equipo = ? and id_empleado = ?");
			ps.setInt(1, teAux.getIdEquipo());
			ps.setInt(2, temAux.getIdEmpleado());
			ps.executeUpdate();
			
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        TEquipoDesarrollo equipo2 = new TEquipoDesarrollo();
		equipo2.setNombre("PruebaDes3");
		equipo2.setTecnologia("PruebaTech3");
		
		FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDesarrollo) equipo2);		
		TEquipo teAux2 = new TEquipoDesarrollo();     
	    teAux2 = FactoriaDAO.getInstance().getDaoEquipo().readByNombre(equipo2.getNombre());
		
	    int res3 = FactoriaSA.getInstance().getSAEquipo().bajaEquipo(teAux2.getIdEquipo());
        assertEquals("El equipo se ha dado de Baja", 1, res3);
        
        int res4 = FactoriaSA.getInstance().getSAEquipo().bajaEquipo(teAux2.getIdEquipo());
        assertEquals("El equipo no se ha dado de Baja. ya dado de baja", -2, res4);
	    
        int res5 = FactoriaSA.getInstance().getSAEquipo().bajaEquipo(10000);
        assertEquals("El equipo no se ha dado de Baja. no existe", -1, res5);

        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from equipo where nombre = ?");
			ps.setString(1, teAux.getNombre());			
			ps.executeUpdate();
			
			ps = (PreparedStatement) con.prepareStatement("delete from equipodesarrollo where id_equipo = ?");
			ps.setInt(1, teAux.getIdEquipo());
			ps.executeUpdate();
			
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}                	
    }
	
    public void testModifyEquipo() {
    	TEquipoDesarrollo equipo = new TEquipoDesarrollo();
		equipo.setNombre("PruebaDes");
		equipo.setTecnologia("PruebaTech");
		
		FactoriaSA.getInstance().getSAEquipo().altaEquipo((TEquipoDesarrollo) equipo);
		TEquipo teAux = new TEquipoDesarrollo();     
	    teAux = FactoriaDAO.getInstance().getDaoEquipo().readByNombre(equipo.getNombre());
	    
	    TEquipoDesarrollo equipoM = new TEquipoDesarrollo();
		equipoM.setNombre("PruebaDes1");
		equipoM.setTecnologia("PruebaTech");
		equipoM.setIdEquipo(teAux.getIdEquipo());
		equipoM.setActivo(true);
		
		int res1 = FactoriaSA.getInstance().getSAEquipo().modificarEquipo(teAux);
        assertEquals("El equipo se ha Modificado", -2, res1);
		
		int res = FactoriaSA.getInstance().getSAEquipo().modificarEquipo(equipoM);
        assertEquals("El equipo se ha Modificado", 1, res);
        
        equipoM.setIdEquipo(10000);

        int res2 = FactoriaSA.getInstance().getSAEquipo().modificarEquipo(equipoM);
        assertEquals("El equipo se ha Modificado", -1, res2);
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scheam", "root", "");
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from equipo where nombre = ?");
			ps.setString(1, equipoM.getNombre());			
			ps.executeUpdate();
			
			ps = (PreparedStatement) con.prepareStatement("delete from equipodesarrollo where id_equipo = ?");
			ps.setInt(1, equipoM.getIdEquipo());
			ps.executeUpdate();
			
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}              
    }
	
}
