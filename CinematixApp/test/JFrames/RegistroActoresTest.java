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
public class RegistroActoresTest {
    
    public RegistroActoresTest() {
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
        RegistroActores instance = new RegistroActores();
        Image expResult = null;
        Image result = instance.getIconImage();
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroActores instance = new RegistroActores();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroActores instance = new RegistroActores();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        RegistroActores instance = new RegistroActores();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        RegistroActores instance = new RegistroActores();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        RegistroActores instance = new RegistroActores();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesbloquear() {
        System.out.println("desbloquear");
        RegistroActores instance = new RegistroActores();
        instance.desbloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNombreCorrecto() {
        System.out.println("validarNombreCorrecto");
        String hora = "";
        RegistroActores instance = new RegistroActores();
        instance.validarNombreCorrecto(hora);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarNombre() {
        System.out.println("verificarNombre");
        RegistroActores instance = new RegistroActores();
        instance.verificarNombre();
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroActores instance = new RegistroActores();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistroActores.main(args);
        fail("The test case is a prototype.");
    }
}
