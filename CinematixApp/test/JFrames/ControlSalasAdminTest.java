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
        if (result == null) {
            fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testDisponibles2D() {
        System.out.println("disponibles2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        try {
            instance.disponibles2D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testReservados2D() {
        System.out.println("reservados2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        try {
            instance.reservados2D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDisponibles3D() {
        System.out.println("disponibles3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        try {
            instance.disponibles3D();
        } catch (Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testReservados3D() {
        System.out.println("reservados3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.reservados3D();
          try {
            instance.reservados3D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testDisponiblesMax2D() {
        System.out.println("disponiblesMax2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
          try {
            instance.disponiblesMax2D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testReservadosMax2D() {
        System.out.println("reservadosMax2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
         try {
            instance.reservadosMax2D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDisponiblesMax3D() {
        System.out.println("disponiblesMax3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        try {
            instance.disponiblesMax3D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testReservadosMax3D() {
        System.out.println("reservadosMax3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        try {
            instance.reservadosMax3D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEstadoSala2D() {
        System.out.println("estadoSala2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
         try {
            instance.estadoSala2D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
        
    }

    @Test
    public void testEstadoSala3D() {
        System.out.println("estadoSala3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
        instance.estadoSala3D();
         try {
            instance.estadoSala3D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEstadoSalaMax2D() {
        System.out.println("estadoSalaMax2D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
         try {
            instance.estadoSalaMax2D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEstadoSalaMax3D() {
        System.out.println("estadoSalaMax3D");
        ControlSalasAdmin instance = new ControlSalasAdmin();
         try {
            instance.estadoSalaMax3D();
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
         try {
            ControlSalasAdmin.main(args);
        } catch(Exception e){
            fail("The test case is a prototype.");
        }
    }   
}
