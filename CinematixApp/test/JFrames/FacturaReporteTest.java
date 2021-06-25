package JFrames;

import java.awt.Image;
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
public class FacturaReporteTest {
    
    public FacturaReporteTest() {
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
    public void testGetIconImage() {
        System.out.println("getIconImage");
        FacturaReporte instance = new FacturaReporte();
        Image expResult = null;
        Image result = instance.getIconImage();
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testRecuperarInformacion() {
        System.out.println("recuperarInformacion");
        FacturaReporte instance = new FacturaReporte();
        try {
            instance.recuperarInformacion();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }
}
