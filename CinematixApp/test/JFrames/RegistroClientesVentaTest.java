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
public class RegistroClientesVentaTest {
    
    public RegistroClientesVentaTest() {
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
        RegistroClientesVenta instance = new RegistroClientesVenta();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarCaracteresRepetidos() {
        System.out.println("verificarCaracteresRepetidos");
        String cadena = "";
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.verificarCaracteresRepetidos(cadena);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCorreo() {
        System.out.println("validarCorreo");
        String cadena = "";
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.validarCorreo(cadena);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNombre() {
        System.out.println("ValidarNombre");
        String nombre = "";
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.ValidarNombre(nombre);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPasaporte() {
        System.out.println("pasaporte");
        String pasaporte = "";
        RegistroClientesVenta instance = new RegistroClientesVenta();
        boolean expResult = false;
        boolean result = instance.pasaporte(pasaporte);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIdentidad() {
        System.out.println("identidad");
        String identidad = "";
        RegistroClientesVenta instance = new RegistroClientesVenta();
        boolean expResult = false;
        boolean result = instance.identidad(identidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesbloquear() {
        System.out.println("desbloquear");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.desbloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarTipoDocumento() {
        System.out.println("cargarTipoDocumento");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.cargarTipoDocumento();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarData() {
        System.out.println("buscarData");
        String valor = "";
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.buscarData(valor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDocumento() {
        System.out.println("documento");
        RegistroClientesVenta instance = new RegistroClientesVenta();
        instance.documento();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistroClientesVenta.main(args);
        fail("The test case is a prototype.");
    }
    
}
