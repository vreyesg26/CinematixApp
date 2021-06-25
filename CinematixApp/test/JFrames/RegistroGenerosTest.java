/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RegistroGenerosTest {
    
    public RegistroGenerosTest() {
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
        RegistroGeneros instance = new RegistroGeneros();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroGeneros instance = new RegistroGeneros();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarCaracteres() {
        System.out.println("verificarCaracteres");
        String cadena = "";
        RegistroGeneros instance = new RegistroGeneros();
        instance.verificarCaracteres(cadena);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroGeneros instance = new RegistroGeneros();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        RegistroGeneros instance = new RegistroGeneros();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        RegistroGeneros instance = new RegistroGeneros();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        RegistroGeneros instance = new RegistroGeneros();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesbloquear() {
        System.out.println("desbloquear");
        RegistroGeneros instance = new RegistroGeneros();
        instance.desbloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarGenero() {
        System.out.println("verificarGenero");
        RegistroGeneros instance = new RegistroGeneros();
        instance.verificarGenero();
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroGeneros instance = new RegistroGeneros();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistroGeneros.main(args);
        fail("The test case is a prototype.");
    }
    
}
