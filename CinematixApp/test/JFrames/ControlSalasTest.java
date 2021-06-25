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
public class ControlSalasTest {
    
    public ControlSalasTest() {
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
        ControlSalas instance = new ControlSalas();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponibles2D() {
        System.out.println("disponibles2D");
        ControlSalas instance = new ControlSalas();
        instance.disponibles2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservados2D() {
        System.out.println("reservados2D");
        ControlSalas instance = new ControlSalas();
        instance.reservados2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponibles3D() {
        System.out.println("disponibles3D");
        ControlSalas instance = new ControlSalas();
        instance.disponibles3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservados3D() {
        System.out.println("reservados3D");
        ControlSalas instance = new ControlSalas();
        instance.reservados3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponiblesMax2D() {
        System.out.println("disponiblesMax2D");
        ControlSalas instance = new ControlSalas();
        instance.disponiblesMax2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservadosMax2D() {
        System.out.println("reservadosMax2D");
        ControlSalas instance = new ControlSalas();
        instance.reservadosMax2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponiblesMax3D() {
        System.out.println("disponiblesMax3D");
        ControlSalas instance = new ControlSalas();
        instance.disponiblesMax3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservadosMax3D() {
        System.out.println("reservadosMax3D");
        ControlSalas instance = new ControlSalas();
        instance.reservadosMax3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSala2D() {
        System.out.println("estadoSala2D");
        ControlSalas instance = new ControlSalas();
        instance.estadoSala2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSala3D() {
        System.out.println("estadoSala3D");
        ControlSalas instance = new ControlSalas();
        instance.estadoSala3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSalaMax2D() {
        System.out.println("estadoSalaMax2D");
        ControlSalas instance = new ControlSalas();
        instance.estadoSalaMax2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSalaMax3D() {
        System.out.println("estadoSalaMax3D");
        ControlSalas instance = new ControlSalas();
        instance.estadoSalaMax3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ControlSalas.main(args);
        fail("The test case is a prototype.");
    }
}
