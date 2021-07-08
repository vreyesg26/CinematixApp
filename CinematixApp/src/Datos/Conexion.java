package Datos;

/**
 *
 * @author Los Pibes
 */

import JFrames.log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    public String db = "dn8nB7Jl0c";
    public String driver = "com.mysql.jdbc.Driver";
    public String usuario = "dn8nB7Jl0c";   
    public String clave = "oMZapKdHQ3";
    //public String url = "jdbc:mysql://remotemysql.com:3306/"+db+"?verifyServerCertificate=false&useSSL=true";
    public String url = "jdbc:mysql://remotemysql.com:3306/"+db+"?autoReconnect=true&useUnicode=yes";
    
    
    public Connection GetConexion(){
        Connection cn=null;
        log lo = new log();
        try{
            Class.forName(driver);
            cn = (Connection) DriverManager.getConnection(this.url, this.usuario, this.clave);
            if (cn !=  null){
                System.out.println("Conexion exitosa");
            }
        }catch(ClassNotFoundException | SQLException e){
             lo.LogBitacora("No se pudo conectar " + e);
            JOptionPane.showConfirmDialog(null, e);
            System.out.println("Error al conectarse" + e.getMessage());
        }
        return cn;       
    }
}
