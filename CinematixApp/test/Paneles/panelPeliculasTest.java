package Paneles;

import java.awt.event.KeyEvent;
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
public class panelPeliculasTest {
    
    public panelPeliculasTest() {
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
    public void testCargarIdiomas() {
        System.out.println("cargarIdiomas");
        panelPeliculas instance = new panelPeliculas();
        instance.cargarIdiomas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarDirectores() {
        System.out.println("cargarDirectores");
        panelPeliculas instance = new panelPeliculas();
        instance.cargarDirectores();
        fail("The test case is a prototype.");
        instance.txtTitulo.setText("Los Vengadores");
        instance.guardarPeliculas();
    }

    @Test
    public void testCargarGeneros() {
        System.out.println("cargarGeneros");
        panelPeliculas instance = new panelPeliculas();
        instance.cargarGeneros();
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarCaracteresRepetidos() {
        System.out.println("verificarCaracteresRepetidos");
        String cadena = "";
        panelPeliculas instance = new panelPeliculas();
        instance.verificarCaracteresRepetidos(cadena);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        panelPeliculas instance = new panelPeliculas();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquearCampos() {
        System.out.println("bloquearCampos");
        panelPeliculas instance = new panelPeliculas();
        instance.bloquearCampos();
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        panelPeliculas instance = new panelPeliculas();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarActores() {
        System.out.println("consultarActores");
        panelPeliculas instance = new panelPeliculas();
        instance.consultarActores();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarData() {
        System.out.println("buscarData");
        String valor = "";
        panelPeliculas instance = new panelPeliculas();
        instance.buscarData(valor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        String valor = "";
        panelPeliculas instance = new panelPeliculas();
        instance.cargarData(valor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        panelPeliculas instance = new panelPeliculas();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNumerosLetras() {
        System.out.println("validarNumerosLetras");
        KeyEvent e = null;
        panelPeliculas instance = new panelPeliculas();
        instance.validarNumerosLetras(e);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarSoloNumeros() {
        System.out.println("validarSoloNumeros");
        String numero = "";
        panelPeliculas instance = new panelPeliculas();
        instance.validarSoloNumeros(numero);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditarActores() {
        System.out.println("editarActores");
        String pelicula = "";
        panelPeliculas instance = new panelPeliculas();
        instance.editarActores(pelicula);
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        panelPeliculas instance = new panelPeliculas();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }
    
}
