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
public class ProductoTest {
    
    public ProductoTest() {
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
     * Test of esNombreValido method, of class Producto.
     */
    @Test
    public void testEsNombreValido() {
        System.out.println("esNombreValido");
        String nombre = "Teclado Mec�nico";
        Producto instance = new Producto();
        boolean expResult = false;
        boolean result = instance.esNombreValido(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esFechaValida method, of class Producto.
     */
    @Test
    public void testEsFechaValida() {
        System.out.println("esFechaValida");
        String fecha = "21/06/2022";
        Producto instance = new Producto();
        boolean expResult = true;
        boolean result = instance.esFechaValida(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esPrecioValido method, of class Producto.
     */
    @Test
    public void testEsPrecioValido() {
        System.out.println("esPrecioValido");
        String precio = "60.25";
        Producto instance = new Producto();
        boolean expResult = true;
        boolean result = instance.esPrecioValido(precio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esStockValido method, of class Producto.
     */
    @Test
    public void testEsStockValido() {
        System.out.println("esStockValido");
        String stock = "10a";
        Producto instance = new Producto();
        boolean expResult = false;
        boolean result = instance.esStockValido(stock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esProveedorValido method, of class Producto.
     */
    @Test
    public void testEsProveedorValido() {
        System.out.println("esProveedorValido");
        String proveedor = "NoviCompu";
        Producto instance = new Producto();
        boolean expResult = true;
        boolean result = instance.esProveedorValido(proveedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esMarcaValida method, of class Producto.
     */
    @Test
    public void testEsMarcaValida() {
        System.out.println("esMarcaValida");
        String marca = "KDA";
        Producto instance = new Producto();
        boolean expResult = true;
        boolean result = instance.esMarcaValida(marca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of esDescripcionValida method, of class Producto.
     */
    @Test
    public void testEsDescripcionValida() {
        System.out.println("esDescripcionValida");
        String descripcion = "Teclado RGB mecanico";
        Producto instance = new Producto();
        boolean expResult = true;
        boolean result = instance.esDescripcionValida(descripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
