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
public class RegistroAdministradoresTest {
    
    public RegistroAdministradoresTest() {
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
        RegistroAdministradores instance = new RegistroAdministradores();
        Image expResult = null;
        Image result = instance.getIconImage();
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesbloquear() {
        System.out.println("desbloquear");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.desbloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testContraseña() {
        System.out.println("contrase\u00f1a");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.contraseña();
        fail("The test case is a prototype.");
    }

    @Test
    public void testUsuarios() {
        System.out.println("usuarios");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.usuarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistroAdministradores.main(args);
        fail("The test case is a prototype.");
    }
    
}
