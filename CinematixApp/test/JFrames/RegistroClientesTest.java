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
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroClientes instance = new RegistroClientes();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarCaracteresRepetidos() {
        System.out.println("verificarCaracteresRepetidos");
        String cadena = "";
        RegistroClientes instance = new RegistroClientes();
        instance.verificarCaracteresRepetidos(cadena);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCorreo() {
        System.out.println("validarCorreo");
        String cadena = "";
        RegistroClientes instance = new RegistroClientes();
        instance.validarCorreo(cadena);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNombre() {
        System.out.println("ValidarNombre");
        String nombre = "";
        RegistroClientes instance = new RegistroClientes();
        instance.ValidarNombre(nombre);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPasaporte() {
        System.out.println("pasaporte");
        String pasaporte = "";
        RegistroClientes instance = new RegistroClientes();
        boolean expResult = false;
        boolean result = instance.pasaporte(pasaporte);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIdentidad() {
        System.out.println("identidad");
        String identidad = "";
        RegistroClientes instance = new RegistroClientes();
        boolean expResult = false;
        boolean result = instance.identidad(identidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        RegistroClientes instance = new RegistroClientes();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        RegistroClientes instance = new RegistroClientes();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        RegistroClientes instance = new RegistroClientes();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesbloquear() {
        System.out.println("desbloquear");
        RegistroClientes instance = new RegistroClientes();
        instance.desbloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarTipoDocumento() {
        System.out.println("cargarTipoDocumento");
        RegistroClientes instance = new RegistroClientes();
        instance.cargarTipoDocumento();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroClientes instance = new RegistroClientes();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarData() {
        System.out.println("buscarData");
        String valor = "";
        RegistroClientes instance = new RegistroClientes();
        instance.buscarData(valor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroClientes instance = new RegistroClientes();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDocumento() {
        System.out.println("documento");
        RegistroClientes instance = new RegistroClientes();
        instance.documento();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistroClientes.main(args);
        fail("The test case is a prototype.");
    }
    
}
