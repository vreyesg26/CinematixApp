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
public class ControlSalasAdminTest {
    
    public ControlSalasAdminTest() {
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
        ControlSalasAdmin instance = new ControlSalasAdmin();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponibles2D() {
        System.out.println("disponibles2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.disponibles2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservados2D() {
        System.out.println("reservados2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.reservados2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponibles3D() {
        System.out.println("disponibles3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.disponibles3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservados3D() {
        System.out.println("reservados3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.reservados3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponiblesMax2D() {
        System.out.println("disponiblesMax2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.disponiblesMax2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservadosMax2D() {
        System.out.println("reservadosMax2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.reservadosMax2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDisponiblesMax3D() {
        System.out.println("disponiblesMax3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.disponiblesMax3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testReservadosMax3D() {
        System.out.println("reservadosMax3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.reservadosMax3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSala2D() {
        System.out.println("estadoSala2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.estadoSala2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSala3D() {
        System.out.println("estadoSala3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.estadoSala3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSalaMax2D() {
        System.out.println("estadoSalaMax2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.estadoSalaMax2D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEstadoSalaMax3D() {
        System.out.println("estadoSalaMax3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.estadoSalaMax3D();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ControlSalasAdmin.main(args);
        fail("The test case is a prototype.");
    }
    
}
