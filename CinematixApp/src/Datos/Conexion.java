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
    public String db = "YCmREGaPCH";
    public String driver = "com.mysql.jdbc.Driver";
    public String usuario = "YCmREGaPCH";
    public String clave = "AYDewKQfsB";
    //public String url = "jdbc:mysql://remotemysql.com:3306/"+db+"?verifyServerCertificate=false&useSSL=true";
    public String url = "jdbc:mysql://remotemysql.com:3306/"+db+"?autoReconnect=true&useUnicode=yes";
    
    
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
            System.out.println("Error al conectarse" + e.getMessage());
        }
        return cn;       
    }
}
