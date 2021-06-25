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
public class LoginAdminTest {
    
    public LoginAdminTest() {
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
        String expResult = "sun.awt.image.ToolkitImage@43a25848";
        Image result = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cinematixLogo.png"));
        assertEquals(expResult, result.toString());
        System.out.println(result);
        if (result == null) {
            System.out.println("Fallo imagen administrador");
            fail("Fallo imagen administrador");
        }
    }

    @Test
    public void testValidarAdministradores() {
        System.out.println("validarAdministradores");
        LoginAdmin instance = new LoginAdmin();
        instance.txtusuario.setText("firulais");
        instance.txtpassword.setText("12345678");
        if (instance.validarAdministradores() == false) {
            fail("The test case is a prototype.");
        }
    }    
}
