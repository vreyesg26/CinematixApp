package cinematixapp;

import Datos.Conexion;
import JFrames.Inicio;

/**
 *
 * @author Victor Reyes
 */
public class CinematixApp extends Conexion {

    public static void main(String[] args) {
        new Inicio().setVisible(true);
    }
}
