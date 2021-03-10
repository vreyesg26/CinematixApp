package Logica;

import Datos.Conexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Los Pibes
 */
public class datosPeliculas extends Conexion{
    private String titulo;
    private int duracion;
    private int director;
    private String reparto;
    private String sinopsis;
    private int idioma;
    private String url;
    private int horarios;
    private String foto;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHorarios() {
        return horarios;
    }

    public void setHorarios(int horarios) {
        this.horarios = horarios;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    

    public datosPeliculas(){
        this.titulo = titulo;
        this.duracion = duracion;
        this.director = director;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
        this.idioma = idioma;
        this.url = url;
        this.horarios = horarios;
        this.foto = foto;
    }
    
    
    public boolean guardar() throws FileNotFoundException{
        PreparedStatement pst = null;
        Connection cc = GetConexion();
        String sql = "INSERT INTO peliculas (Titulo, Duracion, IDDirector, Reparto, IDIdioma, Sinopsis, IDHorario, urlFoto, Foto)" + "Values(?,?,?,?,?,?,?,?,?)";
        
        try {
            FileInputStream archivoImagen = null;
            pst = cc.prepareStatement(sql);
            pst.setString(1, this.getTitulo());
            pst.setInt(2, this.getDuracion());
            pst.setInt(3, this.getDirector());
            pst.setString(4, this.getReparto());
            pst.setInt(5, this.getIdioma());
            pst.setString(6, this.getSinopsis());
            pst.setInt(7, this.getHorarios());
            pst.setString(8, this.getUrl());
            archivoImagen = new FileInputStream(this.getUrl());
            pst.setBinaryStream(9, archivoImagen);
            pst.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
