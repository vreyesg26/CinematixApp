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
public class MenuVendedorTest {
    
    public MenuVendedorTest() {
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
        MenuVendedor instance = new MenuVendedor();
        Image expResult = null;
        Image result = instance.getIconImage();
        if (result == null) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testObtenerMetodoPago() {
        System.out.println("obtenerMetodoPago");
        MenuVendedor instance = new MenuVendedor();
        try {
            instance.obtenerMetodoPago();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testConsultarSala() {
        System.out.println("consultarSala");
        MenuVendedor instance = new MenuVendedor();
        try {
            instance.consultarSala();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testConsultarPrecios() {
        System.out.println("consultarPrecios");
        String numeroSala = "4";
        MenuVendedor instance = new MenuVendedor();
        try {
            instance.consultarPrecios(numeroSala);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testAgregarAComboboxPelicula() {
        System.out.println("AgregarAComboboxPelicula");
        try {
            MenuVendedor.AgregarAComboboxPelicula();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testSeleccionPelicula() {
        System.out.println("seleccionPelicula");
        MenuVendedor instance = new MenuVendedor();
        instance.seleccionPelicula();
        fail("The test case is a prototype.");
    }

    @Test
    public void testHorarios_String() {
        System.out.println("Horarios");
        String idPelicula = "2";
        try {
            MenuVendedor.Horarios(idPelicula);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCalculo() {
        System.out.println("calculo");
        MenuVendedor instance = new MenuVendedor();
        instance.calculo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testPasaDatos() {
        System.out.println("pasaDatos");
        MenuVendedor instance = new MenuVendedor();
        instance.pasaDatos();
        fail("The test case is a prototype.");
    }

    @Test
    public void testTarjeta() {
        System.out.println("tarjeta");
        MenuVendedor instance = new MenuVendedor();
        try {
            instance.tarjeta();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testObtenerSalas_String() {
        System.out.println("obtenerSalas");
        String idPelicula = "2";
        MenuVendedor instance = new MenuVendedor();
        try {
            instance.obtenerSalas(idPelicula);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }
}
