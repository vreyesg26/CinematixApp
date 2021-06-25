package Paneles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Los Pibes
 */
public class panelHistorialTest {
    
    public panelHistorialTest() {
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

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        panelHistorial instance = new panelHistorial();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        String valor = "";
        panelHistorial instance = new panelHistorial();
        instance.cargarData(valor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarData() {
        System.out.println("buscarData");
        String valor = "";
        panelHistorial instance = new panelHistorial();
        instance.buscarData(valor);
        fail("The test case is a prototype.");
    }
    
}
