package Negocio;

import Integracion.Factorias.FactoriaDAO;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TEmpleado;
import Negocio.Factorias.FactoriaSA;
import junit.framework.TestCase;

public class EmpleadoTest extends TestCase {

    public void testAltaEmpleado() {
        TEmpleado empleado = new TEmpleado();
        empleado.setDNI("12345678A");
        empleado.setNombre("Juan");
        empleado.setApellidos("Pérez");
        empleado.setE_mail("juan@ucm.es");
        empleado.setTlfn(123456789);
        empleado.setSueldo(1500.0);

        int resultado = FactoriaSA.getInstance().getSAEmpleado().altaEmpleado(empleado);
        assertEquals("El empleado ya existe y está activo", -1, resultado);

        // Intentamos dar de alta a un empleado con el mismo DNI pero distinto nombre
        TEmpleado empleadoDNIRepetido = new TEmpleado();
        empleadoDNIRepetido.setDNI("12345678A");
        empleadoDNIRepetido.setNombre("Pedro");
        empleadoDNIRepetido.setApellidos("García");
        empleadoDNIRepetido.setE_mail("pedro@ucm.es");
        empleadoDNIRepetido.setTlfn(987654321);
        empleadoDNIRepetido.setSueldo(2000.0);
        resultado = FactoriaSA.getInstance().getSAEmpleado().altaEmpleado(empleadoDNIRepetido);
        assertEquals("Ya existe un empleado con el mismo DNI", -1, resultado); 
	}
    
    public void testBajaEmpleado() {
    	TEmpleado emp = FactoriaDAO.getInstance().getDaoEmpleado().readByDNI("12345678A");
        
        
        
    }
}
