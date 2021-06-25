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
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEncender() {
        System.out.println("Encender");
        MenuVendedor instance = new MenuVendedor();
        instance.Encender();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerMetodoPago() {
        System.out.println("obtenerMetodoPago");
        MenuVendedor instance = new MenuVendedor();
        instance.obtenerMetodoPago();
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarSala() {
        System.out.println("consultarSala");
        MenuVendedor instance = new MenuVendedor();
        instance.consultarSala();
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarPrecios() {
        System.out.println("consultarPrecios");
        String numeroSala = "";
        MenuVendedor instance = new MenuVendedor();
        instance.consultarPrecios(numeroSala);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDesactivados() {
        System.out.println("Desactivados");
        MenuVendedor.Desactivados();
        fail("The test case is a prototype.");
    }

    @Test
    public void testActivar() {
        System.out.println("Activar");
        MenuVendedor instance = new MenuVendedor();
        instance.Activar();
        fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarAComboboxPelicula() {
        System.out.println("AgregarAComboboxPelicula");
        MenuVendedor.AgregarAComboboxPelicula();
        fail("The test case is a prototype.");
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
        String idPelicula = "";
        MenuVendedor.Horarios(idPelicula);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimCantidad() {
        System.out.println("LimCantidad");
        MenuVendedor instance = new MenuVendedor();
        instance.LimCantidad();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiar() {
        System.out.println("limpiar");
        MenuVendedor.limpiar();
        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiar2() {
        System.out.println("limpiar2");
        MenuVendedor.limpiar2();
        fail("The test case is a prototype.");
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
        instance.tarjeta();
        fail("The test case is a prototype.");
    }

    @Test
    public void testTransparenciaButton() {
        System.out.println("transparenciaButton");
        MenuVendedor instance = new MenuVendedor();
        instance.transparenciaButton();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerSalas_String() {
        System.out.println("obtenerSalas");
        String idPelicula = "";
        MenuVendedor instance = new MenuVendedor();
        instance.obtenerSalas(idPelicula);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHorarios_0args() {
        System.out.println("horarios");
        MenuVendedor instance = new MenuVendedor();
        instance.horarios();
        fail("The test case is a prototype.");
    }

    @Test
    public void testObtenerSalas_0args() {
        System.out.println("obtenerSalas");
        MenuVendedor instance = new MenuVendedor();
        instance.obtenerSalas();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MenuVendedor.main(args);
        fail("The test case is a prototype.");
    }
    
}
