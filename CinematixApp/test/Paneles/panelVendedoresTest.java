package Paneles;

import java.awt.event.KeyEvent;
import javafx.scene.control.TextField;
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
public class panelVendedoresTest {
    
    public panelVendedoresTest() {
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
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        panelVendedores instance = new panelVendedores();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEmail() {
        System.out.println("email");
        String correo = "vreyes@gmail.com";
        panelVendedores instance = new panelVendedores();
        boolean expResult = false;
        boolean result = instance.email(correo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarCaracteresRepetidos() {
        System.out.println("verificarCaracteresRepetidos");
        String cadena = "";
        panelVendedores instance = new panelVendedores();
        instance.verificarCaracteresRepetidos(cadena);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNombre() {
        System.out.println("nombre");
        String nombre = "";
        panelVendedores instance = new panelVendedores();
        boolean expResult = false;
        boolean result = instance.nombre(nombre);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPasaporte() {
        System.out.println("pasaporte");
        String pasaporte = "";
        panelVendedores instance = new panelVendedores();
        boolean expResult = false;
        boolean result = instance.pasaporte(pasaporte);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIdentidad() {
        System.out.println("identidad");
        String identidad = "080119958767";
        panelVendedores instance = new panelVendedores();
        boolean expResult = false;
        boolean result = instance.identidad(identidad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSueldo() {
        System.out.println("sueldo");
        String sueldo = "";
        panelVendedores instance = new panelVendedores();
        boolean expResult = false;
        boolean result = instance.sueldo(sueldo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        panelVendedores instance = new panelVendedores();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        panelVendedores instance = new panelVendedores();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarTipoDocumento() {
        System.out.println("cargarTipoDocumento");
        panelVendedores instance = new panelVendedores();
        instance.cargarTipoDocumento();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarJornadas() {
        System.out.println("cargarJornadas");
        panelVendedores instance = new panelVendedores();
        instance.cargarJornadas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCaracteres() {
        System.out.println("validarCaracteres");
        KeyEvent e = null;
        panelVendedores instance = new panelVendedores();
        instance.validarCaracteres(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNumeros() {
        System.out.println("validarNumeros");
        String datos = "";
        boolean expResult = false;
        boolean result = panelVendedores.validarNumeros(datos);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarStrings() {
        System.out.println("validarStrings");
        String datos = "";
        boolean expResult = false;
        boolean result = panelVendedores.validarStrings(datos);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        panelVendedores instance = new panelVendedores();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        panelVendedores instance = new panelVendedores();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarData() {
        System.out.println("buscarData");
        String valor = "";
        panelVendedores instance = new panelVendedores();
        instance.buscarData(valor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        panelVendedores instance = new panelVendedores();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimite() {
        System.out.println("limite");
        TextField txtnombre = null;
        TextField txtdireccion1 = null;
        panelVendedores instance = new panelVendedores();
        instance.limite(txtnombre, txtdireccion1);
        fail("The test case is a prototype.");
    }
    
}
