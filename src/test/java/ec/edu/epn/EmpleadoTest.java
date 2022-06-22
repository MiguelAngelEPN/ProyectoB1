package ec.edu.epn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cris
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of esNombreValido method, of class Empleado.
     */
    @Test
    public void testEsNombreValido() {
        System.out.println("esNombreValido");
        String nombre = "Andr@s";
        Empleado instance = new Empleado();
        boolean expResult = false;
        boolean result = instance.esNombreValido(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esApellidoValido method, of class Empleado.
     */
    @Test
    public void testEsApellidoValido() {
        System.out.println("esApellidoValido");
        String apellido = "Gomez";
        Empleado instance = new Empleado();
        boolean expResult = true;
        boolean result = instance.esApellidoValido(apellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esDireccionValida method, of class Empleado.
     */
    @Test
    public void testEsDireccionValida() {
        System.out.println("esDireccionValida");
        String direccion = "Enrique Segoviano";
        Empleado instance = new Empleado();
        boolean expResult = true;
        boolean result = instance.esDireccionValida(direccion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esCorreoValido method, of class Empleado.
     */
    @Test
    public void testEsCorreoValido() {
        System.out.println("esCorreoValido");
        String correo = "lizbeth@gmail.com";
        Empleado instance = new Empleado();
        boolean expResult = true;
        boolean result = instance.esCorreoValido(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esTelefonoValido method, of class Empleado.
     */
    @Test
    public void testEsTelefonoValido() {
        System.out.println("esTelefonoValido");
        String telefono = "0983007423";
        Empleado instance = new Empleado();
        boolean expResult = true;
        boolean result = instance.esTelefonoValido(telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
