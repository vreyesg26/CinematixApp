package Datos;

/**
 *
 * @author Los Pibes
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public  String db = "cinematix";
    public  String driver = "com.mysql.jdbc.Driver";
    public  String usuario = "root";
    public  String clave = "";
    public  String url = "jdbc:mysql://localhost:3306/"+db+"?verifyServerCertificate=false&useSSL=true";
    
    
    public Connection GetConexion(){
        Connection cn=null;
        
        try{
            Class.forName(driver);
            cn = (Connection) DriverManager.getConnection(this.url, this.usuario, this.clave);
            if (cn !=  null){
                System.out.println("Conexion exitosa");
            }
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            System.out.println("error al conectarse" + e);
        }
        
        return cn;       
    }
}
