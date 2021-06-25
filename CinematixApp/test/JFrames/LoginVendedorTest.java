package JFrames;

import java.awt.Image;
import java.awt.Toolkit;
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
public class LoginVendedorTest {
    
    public LoginVendedorTest() {
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
        LoginAdmin instance = new LoginAdmin();
        Image expResult = null;
        Image result = instance.getIconImage();
        System.out.println(result);
        if (result == null) {
            fail("Fallo imagen administrador");
        }
    }

    @Test
    public void testValidarVendedores() {
        System.out.println("validarVendedores");
        LoginVendedor instance = new LoginVendedor();
        instance.txtCorreo.setText("cesar@gmail.com ");
        instance.txtClave.setText("firulais");
        if (instance.validarVendedores() == false) {
            fail("No existe este vendedor");
        }
    }    
}
