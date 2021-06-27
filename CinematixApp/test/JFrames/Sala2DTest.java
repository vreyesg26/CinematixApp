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
public class Sala2DTest {
    
    public Sala2DTest() {
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
        Sala2D instance = new Sala2D();
        Image expResult = null;
        Image result = instance.getIconImage();
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testReservaAsiento() {
        System.out.println("reservaAsiento");
        int numeroasiento = 4;
        Sala2D instance = new Sala2D();
        try {
            instance.reservaAsiento(numeroasiento);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testQuitarReservaAsiento() {
        System.out.println("QuitarReservaAsiento");
        int numeroasiento = 2;
        Sala2D instance = new Sala2D();
        try {
            instance.QuitarReservaAsiento(numeroasiento);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testBuscarAsientosReservados() {
        System.out.println("buscarAsientosReservados");
        Sala2D instance = new Sala2D();
        try {
            instance.buscarAsientosReservados();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    } 
}
