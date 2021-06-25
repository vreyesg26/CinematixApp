package JFrames;

import java.awt.Image;
import java.awt.event.KeyEvent;
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
public class ConfirmarVentaTest {
    
    public ConfirmarVentaTest() {
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
    public void testNoEditable() {
        System.out.println("noEditable");
        ConfirmarVenta instance = new ConfirmarVenta();
        instance.noEditable();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDatosFactura() {
        System.out.println("datosFactura");
        ConfirmarVenta instance = new ConfirmarVenta();
        instance.datosFactura();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculo() {
        System.out.println("calculo");
        ConfirmarVenta instance = new ConfirmarVenta();
        instance.calculo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testPasaDatos() {
        System.out.println("pasaDatos");
        ConfirmarVenta instance = new ConfirmarVenta();
        instance.pasaDatos();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIconImage() {
        System.out.println("getIconImage");
        ConfirmarVenta instance = new ConfirmarVenta();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNumeros() {
        System.out.println("validarNumeros");
        KeyEvent e = null;
        ConfirmarVenta instance = new ConfirmarVenta();
        instance.validarNumeros(e);
        fail("The test case is a prototype.");
    }
}
