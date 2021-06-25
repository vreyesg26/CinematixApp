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
public class RegistroDirectoresTest {
    
    public RegistroDirectoresTest() {
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
        RegistroDirectores instance = new RegistroDirectores();
        Image expResult = null;
        Image result = instance.getIconImage();
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroDirectores instance = new RegistroDirectores();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testNombre() {
        System.out.println("nombre");
        String nombre = "";
        RegistroDirectores instance = new RegistroDirectores();
        boolean expResult = false;
        boolean result = instance.nombre(nombre);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroDirectores instance = new RegistroDirectores();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        RegistroDirectores instance = new RegistroDirectores();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        RegistroDirectores instance = new RegistroDirectores();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        RegistroDirectores instance = new RegistroDirectores();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesbloquear() {
        System.out.println("desbloquear");
        RegistroDirectores instance = new RegistroDirectores();
        instance.desbloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarNombre() {
        System.out.println("verificarNombre");
        RegistroDirectores instance = new RegistroDirectores();
        instance.verificarNombre();
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroDirectores instance = new RegistroDirectores();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDirectores() {
        System.out.println("directores");
        RegistroDirectores instance = new RegistroDirectores();
        instance.directores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistroDirectores.main(args);
        fail("The test case is a prototype.");
    }
    
}
