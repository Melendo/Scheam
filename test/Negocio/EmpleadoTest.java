package Negocio;

import java.util.Set;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Empleado.TEmpleado;
import Negocio.Factorias.FactoriaSA;
import junit.framework.TestCase;

public class EmpleadoTest extends TestCase {

    public void testAltaEmpleado() {
    	int expected_output;
    	if (FactoriaDAO.getInstance().getDaoEmpleado().readByDNI("12345678A").getIdEmpleado() == -1) 
    		expected_output = 1;
    	else
    		expected_output = 2;
    	
        TEmpleado empleado = new TEmpleado();
        empleado.setDNI("12345678A");
        empleado.setNombre("Juan");
        empleado.setApellidos("P�rez");
        empleado.setE_mail("juan@ucm.es");
        empleado.setTlfn(123456789);
        empleado.setSueldo(1500.0);
        int resultado = FactoriaSA.getInstance().getSAEmpleado().altaEmpleado(empleado);
        
        assertEquals("El empleado se ha dado de alta", expected_output, resultado);

        // Intentamos dar de alta a un empleado con el mismo DNI pero distinto nombre
        TEmpleado empleadoDNIRepetido = new TEmpleado();
        empleadoDNIRepetido.setDNI("12345678A");
        empleadoDNIRepetido.setNombre("Pedro");
        empleadoDNIRepetido.setApellidos("Garc�a");
        empleadoDNIRepetido.setE_mail("pedro@ucm.es");
        empleadoDNIRepetido.setTlfn(987654321);
        empleadoDNIRepetido.setSueldo(2000.0);
        resultado = FactoriaSA.getInstance().getSAEmpleado().altaEmpleado(empleadoDNIRepetido);
        assertEquals("Ya existe un empleado con el mismo DNI", -1, resultado);
	}
    
    public void testBajaEmpleado() {
    	TEmpleado emp = FactoriaDAO.getInstance().getDaoEmpleado().readByDNI("12345678A");
        int resultado = FactoriaSA.getInstance().getSAEmpleado().bajaEmpleado(emp.getIdEmpleado());
        assertEquals("Baja realizada con �xito", 1, resultado);
        
        resultado = FactoriaSA.getInstance().getSAEmpleado().bajaEmpleado(99999);
        assertEquals("No existe el empleado", -1, resultado);
        
        resultado = FactoriaSA.getInstance().getSAEmpleado().bajaEmpleado(emp.getIdEmpleado());
        assertEquals("El empleado ya est� dado de baja", -2, resultado);
    }
    
    public void testModificarEmpleado() {
    	if (FactoriaDAO.getInstance().getDaoEmpleado().readByDNI("12345680B").getDNI() == "-1") {
        	TEmpleado empleado = new TEmpleado();
            empleado.setDNI("12345680B");
            empleado.setNombre("Antonio");
            empleado.setApellidos("Navarro");
            empleado.setE_mail("anavarro@ucm.es");
            empleado.setTlfn(123456789);
            empleado.setSueldo(1500.0);
            FactoriaSA.getInstance().getSAEmpleado().altaEmpleado(empleado);
    	}
    	
    	TEmpleado empleado = FactoriaDAO.getInstance().getDaoEmpleado().readByDNI("12345680B");
    	empleado.setSueldo(3000.0);
    	empleado.setDNI(null);
    	int resultado = FactoriaSA.getInstance().getSAEmpleado().modificarEmpleado(empleado);
    	assertEquals("El empleado ha sido modificado", 1, resultado);
    	
    	TEmpleado emp2 = new TEmpleado();
    	emp2.setIdEmpleado(9999);
    	resultado = FactoriaSA.getInstance().getSAEmpleado().modificarEmpleado(emp2);
    	assertEquals("El empleado no existe en la base de datos", -1, resultado);
    	
    	TEmpleado empleado2 = new TEmpleado();
        empleado2.setDNI("22222222P");
        empleado2.setNombre("Alicia");
        empleado2.setApellidos("G�mez");
        empleado2.setE_mail("alicia@ucm.es");
        empleado2.setTlfn(123456789);
        empleado2.setSueldo(1500.0);
        FactoriaSA.getInstance().getSAEmpleado().altaEmpleado(empleado2);
    	empleado2.setDNI("00000000P");
    	empleado2.setIdEmpleado(FactoriaDAO.getInstance().getDaoEmpleado().readByDNI("22222222P").getIdEmpleado());
    	resultado = FactoriaSA.getInstance().getSAEmpleado().modificarEmpleado(empleado2);
    	assertEquals("El DNI ya existe en la base de datos", -2, resultado);
    }
    
    public void testlistarEmpleados() {
    	Set<TEmpleado> lista = FactoriaSA.getInstance().getSAEmpleado().listarEmpleados();
    	assertTrue("Como hemos metido datos, el listar debe tener al menos un empleado", lista.size() > 0);
    }
    
    public void testMostrarEmpleadoID() {
    	int id = FactoriaDAO.getInstance().getDaoEmpleado().readByDNI("12345678A").getIdEmpleado();
    	TEmpleado result = FactoriaSA.getInstance().getSAEmpleado().mostrarEmpleadoID(id);
    	assertEquals("El empleado se muestra: DNI correcto", result.getDNI(), "12345678A");
    	assertEquals("El empleado se muestra: Nombre correcto", result.getNombre(), "Juan");
    	assertEquals("El empleado se muestra: Apellido correcto", result.getApellidos(), "P�rez");
    	assertEquals("El empleado se muestra: E-mail correcto", result.getE_mail(), "juan@ucm.es");
    	
    	result = FactoriaSA.getInstance().getSAEmpleado().mostrarEmpleadoID(9999);
    	int id2 = result.getIdEmpleado();
    	assertEquals("El empleado no existe en la BD", -1, id2);
    }
    
    public void testListarIntegrantesIdEquipo() {
    	Set<TEmpleado> resultado = FactoriaSA.getInstance().getSAEmpleado().listarIntegrantesIdEquipo(999);
    	assertTrue("El equipo no existe", resultado == null);
    	
    }
}
