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
        LoginVendedor instance = new LoginVendedor();
        String expResult = "sun.awt.image.ToolkitImage@43a25848";
        Image result = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cinematixLogo.png"));
        assertEquals(expResult, result.toString());
        System.out.println(result);
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarVendedores() {
        System.out.println("validarVendedores");
        LoginVendedor instance = new LoginVendedor();
        try {
            instance.validarVendedores();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }    
}
