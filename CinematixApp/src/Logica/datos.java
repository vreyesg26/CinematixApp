/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Conexion;
import encriptacion.Encode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Los Pibes
 */
public class datos extends Conexion {

    private int IDVendedor;
    private String Nombre;
    private String Usuario;
    private String Clave;
    private String Direccion;
    private int Sueldo;
    private int IDJornada;
    private int NumeroCelular;
    private int IDTipoDocumento;
    private String NumeroDocumento;
    private String Corrreo;

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

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int Sueldo) {
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

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public String getCorrreo() {
        return Corrreo;
    }

    public void setCorrreo(String Corrreo) {
        this.Corrreo = Corrreo;
    }

    String secretKey = "lospibes";
    Encode encode = new Encode();

    public boolean guardar() {
        PreparedStatement pst = null;
        Connection cc = GetConexion();
        String sql = "INSERT INTO vendedor (Nombre, Direccion, Sueldo, IDJornada, NumeroCelular, IDTipoDocumento, NumeroDocumento, Correo, Usuario, Clave)" + "Values(?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = cc.prepareStatement(sql);
            pst.setString(1, this.getNombre());
            pst.setString(2, this.getDireccion());
            pst.setInt(3, this.getSueldo());
            pst.setInt(4, this.getIDJornada());
            pst.setInt(5, this.getNumeroCelular());
            pst.setInt(6, this.getIDTipoDocumento());
            pst.setString(7, this.getNumeroDocumento());
            pst.setString(8, this.getCorrreo());
            pst.setString(9, this.getUsuario());
            pst.setString(10, encode.ecnode(secretKey, this.getClave()));
            pst.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean editar() {
        PreparedStatement Pst = null;
        Connection cc = GetConexion();
        //String vSql = "UPDATE vendedor SET Nombre = ? , Direccion = ?, Sueldo = ?, IDJornada = ?, NumeroCelular = ?, IDTipoDocumento = ?, Correo = ? where IDVendedor= ? ";

        /**
         * String vSql="UPDATE vendedor SET Nombre = ?, " + "Direccion = ?," +
         * "Sueldo = ?," + "IDJornada = ?," + "NumeroCelular = ?," +
         * "IDTipoDocumento=?" + "Correo=?" + "WHERE IDVendedor = ?";*
         */
        String vSql = "UPDATE vendedor SET  Nombre= ? , Direccion = ?, Sueldo = ?, IDJornada = ?, NumeroCelular = ?, IDTipoDocumento = ?, NumeroDocumento = ?, Correo = ?, Usuario = ?, Clave = ? where IDVendedor = ?";
        try {
            Pst = cc.prepareStatement(vSql);
            Pst.setString(1, this.getNombre());
            Pst.setString(2, this.getDireccion());
            Pst.setInt(3, this.getSueldo());
            Pst.setInt(4, this.getIDJornada());
            Pst.setInt(5, this.getNumeroCelular());
            Pst.setInt(6, this.getIDTipoDocumento());
            Pst.setString(7, this.getNumeroDocumento());
            Pst.setString(8, this.getCorrreo());
            Pst.setString(9, this.getUsuario());
            Pst.setString(10, encode.ecnode(secretKey, this.getClave()));
            Pst.setInt(11, this.getIDVendedor());
            Pst.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
