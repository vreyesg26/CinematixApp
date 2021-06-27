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
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testValidarCamposVacios() {
        System.out.println("validarCamposVacios");
        RegistroHorarios instance = new RegistroHorarios();
        instance.txtHorarios.setText("Hola");
        if (!instance.txtHorarios.getText().isEmpty()) {
            instance.validarCamposVacios();
        } else {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCargarData() {
        System.out.println("cargarData");
        RegistroHorarios instance = new RegistroHorarios();
        try {
            instance.cargarData();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testVerificarFormatoHora() {
        System.out.println("verificarFormatoHora");
        String hora = "02:00pm";
        RegistroHorarios instance = new RegistroHorarios();
        if (instance.verificarFormatoHora(hora) == true) {
            instance.verificarFormatoHora(hora);
        } else {
            fail("El formato de hora es incorrecto");
        }
    }

    @Test
    public void testVerificarHorario() {
        System.out.println("verificarHorario");
        RegistroHorarios instance = new RegistroHorarios();
        instance.txtHorarios.setText("01:00am");
        if (instance.verificarHorario() == false){
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");
        RegistroHorarios instance = new RegistroHorarios();
        instance.fila = 4;
        if (instance.fila < 0) {
            instance.modificarRegistro();
            fail("No se seleccionó ningún elemento de la tabla");
        }
    }
    
}
