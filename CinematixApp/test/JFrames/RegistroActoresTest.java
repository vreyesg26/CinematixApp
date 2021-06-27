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
        instance.txtNombre.setText("Victor");
        if (!instance.txtNombre.getText().isEmpty()) {
            instance.validarCamposVacios();
        } else {
            fail("Debe escribir un nombre.");
        }
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroActores instance = new RegistroActores();
        try {
            instance.cargarData();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarNombreCorrecto() {
        System.out.println("validarNombreCorrecto");
        String nombre = "Victor Reyes";
        RegistroActores instance = new RegistroActores();
        if (nombre.matches("^[A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+([ ][A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+)+$")) {
            instance.validarNombreCorrecto(nombre);
        } else {
            fail("Debes escribir un nombre correcto");
        }
    }

    @Test
    public void testVerificarNombre() {
        System.out.println("verificarNombre");
        RegistroActores instance = new RegistroActores();
        try {
            instance.verificarNombre();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroActores instance = new RegistroActores();
        instance.fila = 4;
        if (instance.fila < 0) {
            instance.modificarRegistro();
            fail("No se seleccionó ningún elemento de la tabla");
        }
    }
}
