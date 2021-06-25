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
        instance.txtUsuario.setText("Victor");
        instance.txtContraseña.setText("firulais");
        if (instance.txtUsuario.getText().isEmpty()) {
            fail("The test case is a prototype.");
        } else if (instance.txtContraseña.getText().isEmpty()) {
            fail("Rellene el campo");
        } else {
            instance.validarCamposVacios();
        }
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroAdministradores instance = new RegistroAdministradores();
        try {
            instance.cargarData();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.fila = 4;
        if (instance.fila < 0) {
            instance.modificarRegistro();
            fail("No se seleccionó ningún elemento de la tabla");
        }
    }

    @Test
    public void testContraseña() {
        System.out.println("contrase\u00f1a");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.txtContraseña.setText("firulais");
        if (instance.txtContraseña.getText().length() < 6) {
            fail("La contraseña debe contener al menos 6 caracteres");
        } else {
            instance.contraseña();
        }
    }

    @Test
    public void testUsuarios() {
        System.out.println("usuarios");
        RegistroAdministradores instance = new RegistroAdministradores();
        instance.txtUsuario.setText("adminsuplente");
        if (instance.usuarios() == true) {
            instance.usuarios();
        } else {
            fail("El usuario ya existe");
        }
    }
}
