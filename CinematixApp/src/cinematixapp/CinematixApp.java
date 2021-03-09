package cinematixapp;

import Datos.Conexion;
import JFrames.Inicio;

/**
 *
 * @author Victor Reyes
 */
public class CinematixApp extends Conexion{
    
    //CONSTRUCTORES PARA DASHBOARD ADMIN EN PANEL VENDEDOR
    private int IDVendedor;
    private String Nombre;
    private String Direccion;
    private float Sueldo;
    private int IDJornada;
    private int NumeroCelular;
    private int IDTipoDocumento;
    private String Corrreo;

    public CinematixApp(int IDVendedor, String Nombre, String Direccion, float Sueldo, int IDJornada, int NumeroCelular, int IDTipoDocumento, String Corrreo) {
        this.IDVendedor = IDVendedor;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Sueldo = Sueldo;
        this.IDJornada = IDJornada;
        this.NumeroCelular = NumeroCelular;
        this.IDTipoDocumento = IDTipoDocumento;
        this.Corrreo = Corrreo;
    }

    public int getIDVendedor() {
        return IDVendedor;
    }

    public void setIDVendedor(int IDVendedor) {
        this.IDVendedor = IDVendedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float Sueldo) {
        this.Sueldo = Sueldo;
    }

    public int getIDJornada() {
        return IDJornada;
    }

    public void setIDJornada(int IDJornada) {
        this.IDJornada = IDJornada;
    }

    public int getNumeroCelular() {
        return NumeroCelular;
    }

    public void setNumeroCelular(int NumeroCelular) {
        this.NumeroCelular = NumeroCelular;
    }

    public int getIDTipoDocumento() {
        return IDTipoDocumento;
    }

    public void setIDTipoDocumento(int IDTipoDocumento) {
        this.IDTipoDocumento = IDTipoDocumento;
    }

    public String getCorrreo() {
        return Corrreo;
    }

    public void setCorrreo(String Corrreo) {
        this.Corrreo = Corrreo;
    }
    
    public static void main(String[] args) {
        new Inicio().setVisible(true);
    
    
    
    
     
    

    
    
    } 
    
}
