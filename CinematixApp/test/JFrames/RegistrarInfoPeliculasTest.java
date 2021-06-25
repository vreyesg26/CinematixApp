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
public class RegistrarInfoPeliculasTest {
    
    public RegistrarInfoPeliculasTest() {
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
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarActores() {
        System.out.println("consultarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.consultarActores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarHorarios() {
        System.out.println("consultarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.consultarHorarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarSalas() {
        System.out.println("consultarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.consultarSalas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerUltimaPelicula() {
        System.out.println("obtenerUltimaPelicula");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.obtenerUltimaPelicula();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerIDActores() {
        System.out.println("obtenerIDActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.obtenerIDActores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerIDHorarios() {
        System.out.println("obtenerIDHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.obtenerIDHorarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerIDSalas() {
        System.out.println("obtenerIDSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.obtenerIDSalas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGuardarActores() {
        System.out.println("guardarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.guardarActores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGuardarHorarios() {
        System.out.println("guardarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.guardarHorarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGuardarSalas() {
        System.out.println("guardarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.guardarSalas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testHabilitarActores() {
        System.out.println("habilitarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.habilitarActores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeshabilitarActores() {
        System.out.println("deshabilitarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.deshabilitarActores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testHabilitarHorarios() {
        System.out.println("habilitarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.habilitarHorarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeshabilitarHorarios() {
        System.out.println("deshabilitarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.deshabilitarHorarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testHabilitarSalas() {
        System.out.println("habilitarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.habilitarSalas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeshabilitarSalas() {
        System.out.println("deshabilitarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.deshabilitarSalas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistrarInfoPeliculas.main(args);
        fail("The test case is a prototype.");
    }
    
}
