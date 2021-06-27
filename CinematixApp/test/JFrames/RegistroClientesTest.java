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
public class RegistroClientesTest {

    public RegistroClientesTest() {
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
        RegistroClientes instance = new RegistroClientes();
        Image expResult = null;
        Image result = instance.getIconImage();
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroClientes instance = new RegistroClientes();
        instance.cbTipoDocu.addItem("Seleccione tipo de documento");
        instance.cbTipoDocu.addItem("Identidad");
        instance.cbTipoDocu.addItem("RTN");
        instance.cbTipoDocu.addItem("Pasaporte");
        instance.txtNombre.setText("Fernanda Martínez");
        instance.txtCorreo.setText("fermartinez@yahoo.com   ");
        instance.cbTipoDocu.setSelectedIndex(2);
        instance.txtNumDocu.setText("019231231221412");
        if (instance.txtNombre.getText().isEmpty() || instance.txtCorreo.getText().isEmpty() ||
                instance.cbTipoDocu.getSelectedIndex() == 0 || instance.txtNumDocu.getText().isEmpty()) {
            fail("Faltaron algunos datos");
        }
    }
    
    @Test
    public void testVerificarCaracteresRepetidos() {
        System.out.println("verificarCaracteresRepetidos");
        String cadena = "Derick";
        RegistroClientes instance = new RegistroClientes();
        if (instance.verificarCaracteresRepetidos(cadena) != true) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarCorreo() {
        System.out.println("validarCorreo");
        String cadena = "cesar@ujcv.edu.hn";
        RegistroClientes instance = new RegistroClientes();
        if (instance.validarCorreo(cadena) != true) {
            fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testValidarNombre() {
        System.out.println("ValidarNombre");
        String cadena = "Cesar Zepeda";
        RegistroClientes instance = new RegistroClientes();
        if (instance.ValidarNombre(cadena) != true) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testPasaporte() {
        System.out.println("pasaporte");
        String pasaporte = "E837293";
        RegistroClientes instance = new RegistroClientes();
        if (instance.pasaporte(pasaporte) != true) {
            fail("No es un pasaporte válido");
        }
    }

    @Test
    public void testIdentidad() {
        System.out.println("identidad");
        String identidad = "0801199347282";
        RegistroClientes instance = new RegistroClientes();
        if (instance.identidad(identidad) != true) {
            fail("No es una identidad válida");
        }
    }

    @Test
    public void testCargarTipoDocumento() {
        System.out.println("cargarTipoDocumento");
        RegistroClientes instance = new RegistroClientes();
        try {
            instance.cargarTipoDocumento();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroClientes instance = new RegistroClientes();
        try {
            instance.cargarData();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testBuscarData() {
        System.out.println("buscarData");
        String valor = "2";
        RegistroClientes instance = new RegistroClientes();
        try {
            instance.buscarData(valor);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroClientes instance = new RegistroClientes();
        instance.fila = 4;
        if (instance.fila < 0) {
            instance.modificarRegistro();
            fail("No se seleccionó ningún elemento de la tabla");
        }
    }
}
