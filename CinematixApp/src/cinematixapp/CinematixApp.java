package cinematixapp;

import Datos.Conexion;
import JFrames.Inicio;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Victor Reyes
 */
public class CinematixApp extends Conexion {

    public static void main(String[] args) {
        new Inicio().setVisible(true);
    }
}
