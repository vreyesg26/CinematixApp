package cinematixapp;
import Datos.Conexion;
/**
 *
 * @author Victor Reyes
 */
public class CinematixApp {

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        if (cn.GetConexion()!=null)
            System.out.println("Conexion Correcta");
        else
            System.out.println("Conexion incorrecta");
    } 
}
