package ec.edu.epn;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ProductoTetTest {
    String nombre="teclado";
    @Test
    public void esNombreValido() {
        ProductoTet p = Mockito.mock(ProductoTet.class);
        Mockito.when(p.esNombreValido(nombre)).thenReturn(true);

        assertEquals( true,p.esNombreValido("teclado"));
    }
}