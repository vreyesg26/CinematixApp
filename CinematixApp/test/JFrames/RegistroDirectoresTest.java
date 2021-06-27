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
        instance.txtDirector.setText("Hola");
        if (!instance.txtDirector.getText().isEmpty()) {
            instance.validarCamposVacios();
        } else {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testNombre() {
        System.out.println("nombre");
        String nombre = "Luis Salmeron";
        RegistroDirectores instance = new RegistroDirectores();
        if (instance.nombre(nombre) != true) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroDirectores instance = new RegistroDirectores();
        try {
            instance.cargarData();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testVerificarNombre() {
        System.out.println("verificarNombre");
        RegistroDirectores instance = new RegistroDirectores();
        instance.txtDirector.setText("Andrew Gardfield");
        if (instance.verificarNombre() != true) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroDirectores instance = new RegistroDirectores();
        instance.fila = 4;
        if (instance.fila < 0) {
            instance.modificarRegistro();
            fail("No se seleccionó ningún elemento de la tabla");
        }
    }

    @Test
    public void testDirectores() {
        System.out.println("directores");
        RegistroDirectores instance = new RegistroDirectores();
        instance.txtDirector.setText("Franklin Meza");
        if (!instance.txtDirector.getText().isEmpty()) {
            if (instance.directores() != true) {
                fail("El nombre del director es incorrecto");
            }
        } else {
            fail("No hay ningún nombre");
        }
    }
}
