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
public class RegistroHorariosTest {
    
    public RegistroHorariosTest() {
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
        RegistroHorarios instance = new RegistroHorarios();
        Image expResult = null;
        Image result = instance.getIconImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroHorarios instance = new RegistroHorarios();
        instance.validarCamposVacios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroHorarios instance = new RegistroHorarios();
        instance.cargarData();
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnchoColumnas() {
        System.out.println("anchoColumnas");
        RegistroHorarios instance = new RegistroHorarios();
        instance.anchoColumnas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiarCajas() {
        System.out.println("limpiarCajas");
        RegistroHorarios instance = new RegistroHorarios();
        instance.limpiarCajas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testBloquear() {
        System.out.println("bloquear");
        RegistroHorarios instance = new RegistroHorarios();
        instance.bloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesbloquear() {
        System.out.println("desbloquear");
        RegistroHorarios instance = new RegistroHorarios();
        instance.desbloquear();
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarFormatoHora() {
        System.out.println("verificarFormatoHora");
        String hora = "";
        RegistroHorarios instance = new RegistroHorarios();
        instance.verificarFormatoHora(hora);
        fail("The test case is a prototype.");
    }

    @Test
    public void testVerificarHorario() {
        System.out.println("verificarHorario");
        RegistroHorarios instance = new RegistroHorarios();
        instance.verificarHorario();
        fail("The test case is a prototype.");
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroHorarios instance = new RegistroHorarios();
        instance.modificarRegistro();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RegistroHorarios.main(args);
        fail("The test case is a prototype.");
    }
    
}
