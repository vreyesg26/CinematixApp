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
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroGeneros instance = new RegistroGeneros();
        instance.txtGeneros.setText("Hola");
        if (!instance.txtGeneros.getText().isEmpty()) {
            instance.validarCamposVacios();
        } else {
            instance.validarCamposVacios();
            fail("El campo género está vacío");
        }
    }

    @Test
    public void testVerificarCaracteres() {
        System.out.println("verificarCaracteres");
        String cadena = "Prueba";
        RegistroGeneros instance = new RegistroGeneros();
        if (instance.verificarCaracteres(cadena) != true){
            fail("The test case is a prototype.");
        } 
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroGeneros instance = new RegistroGeneros();
        try {
            instance.cargarData();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testVerificarGenero() {
        System.out.println("verificarGenero");
        RegistroGeneros instance = new RegistroGeneros();
        instance.txtGeneros.setText("Vaqueros");
        if (instance.verificarGenero() == true) {
            instance.verificarGenero();
        } else {
            fail("Este género ya existe");
        }
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroGeneros instance = new RegistroGeneros();
        instance.fila = 4;
        if (instance.fila < 0) {
            instance.modificarRegistro();
            fail("No se seleccionó ningún elemento de la tabla");
        }
    } 
}
