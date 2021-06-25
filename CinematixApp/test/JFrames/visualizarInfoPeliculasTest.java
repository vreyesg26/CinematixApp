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
public class visualizarInfoPeliculasTest {
    
    public visualizarInfoPeliculasTest() {
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
        visualizarInfoPeliculas instance = new visualizarInfoPeliculas();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVisualizarActores() {
        System.out.println("visualizarActores");
        String pelicula = "";
        visualizarInfoPeliculas instance = new visualizarInfoPeliculas();
        instance.visualizarActores(pelicula);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVisualizarHorarios() {
        System.out.println("visualizarHorarios");
        String pelicula = "";
        visualizarInfoPeliculas instance = new visualizarInfoPeliculas();
        instance.visualizarHorarios(pelicula);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVisualizarSalas() {
        System.out.println("visualizarSalas");
        String pelicula = "";
        visualizarInfoPeliculas instance = new visualizarInfoPeliculas();
        instance.visualizarSalas(pelicula);
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerIDActores() {
        System.out.println("obtenerIDActores");
        visualizarInfoPeliculas instance = new visualizarInfoPeliculas();
        instance.obtenerIDActores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerIDHorarios() {
        System.out.println("obtenerIDHorarios");
        visualizarInfoPeliculas instance = new visualizarInfoPeliculas();
        instance.obtenerIDHorarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerIDSalas() {
        System.out.println("obtenerIDSalas");
        visualizarInfoPeliculas instance = new visualizarInfoPeliculas();
        instance.obtenerIDSalas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        visualizarInfoPeliculas.main(args);
        fail("The test case is a prototype.");
    }
    
}
