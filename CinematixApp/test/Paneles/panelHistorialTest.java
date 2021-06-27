/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Paneles.panelHistorial;

/**
 *
 * @author Victor Reyes
 */
public class panelHistorialTest {
    
    public panelHistorialTest() {
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
    public void testCargarData() {
        System.out.println("cargarData");
        panelHistorial instance = new panelHistorial();
        try {
            instance.cargarData();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testBuscarData() {
        System.out.println("buscarData");
        String valor = "";
        panelHistorial instance = new panelHistorial();
        try {
            instance.buscarData(valor);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    } 
}
