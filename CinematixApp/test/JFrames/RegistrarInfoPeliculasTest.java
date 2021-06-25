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
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testConsultarActores() {
        System.out.println("consultarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.consultarActores();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testConsultarHorarios() {
        System.out.println("consultarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.consultarHorarios();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testConsultarSalas() {
        System.out.println("consultarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.consultarSalas();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testObtenerUltimaPelicula() {
        System.out.println("obtenerUltimaPelicula");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.obtenerUltimaPelicula();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testObtenerIDActores() {
        System.out.println("obtenerIDActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.obtenerIDActores();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testObtenerIDHorarios() {
        System.out.println("obtenerIDHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.obtenerIDHorarios();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testObtenerIDSalas() {
        System.out.println("obtenerIDSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.obtenerIDSalas();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGuardarActores() {
        System.out.println("guardarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.arregloIDActores.add(1);
        instance.arregloIDActores.add(3);
        instance.arregloIDActores.add(2);
        if (!instance.arregloIDActores.isEmpty()) {
            instance.guardarActores();
        } else {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGuardarHorarios() {
        System.out.println("guardarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.arregloIDHorarios.add(1);
        instance.arregloIDHorarios.add(3);
        instance.arregloIDHorarios.add(2);
        if (!instance.arregloIDHorarios.isEmpty()) {
            instance.guardarHorarios();
        } else {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testGuardarSalas() {
        System.out.println("guardarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        instance.arregloIDSalas.add(1);
        instance.arregloIDSalas.add(3);
        instance.arregloIDSalas.add(2);
        if (!instance.arregloIDSalas.isEmpty()) {
            instance.guardarSalas();
        } else {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testHabilitarActores() {
        System.out.println("habilitarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.habilitarActores();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDeshabilitarActores() {
        System.out.println("deshabilitarActores");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.deshabilitarActores();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testHabilitarHorarios() {
        System.out.println("habilitarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.habilitarHorarios();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDeshabilitarHorarios() {
        System.out.println("deshabilitarHorarios");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.deshabilitarHorarios();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testHabilitarSalas() {
        System.out.println("habilitarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.habilitarSalas();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDeshabilitarSalas() {
        System.out.println("deshabilitarSalas");
        RegistrarInfoPeliculas instance = new RegistrarInfoPeliculas();
        try {
            instance.deshabilitarSalas();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }
}
