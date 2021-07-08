package cinematixapp;

import Datos.Conexion;
import JFrames.Inicio;
import org.apache.log4j.Logger;

/**
 *
 * @author Victor Reyes
 */
public class CinematixApp extends Conexion {

    public static void main(String[] args) {
        new Inicio().setVisible(true);
        final Logger logger = Logger.getLogger(CinematixApp.class);

        logger.debug("Este es debug: " + "parameter/exception Object");
        logger.info("Este es info: " + "parameter/exception Object");
        logger.warn("Este es warn: " + "parameter/exception Object");
        logger.error("Este es error: " + "parameter/exception Object");
        logger.fatal("Este es fatal: " + "parameter/exception Object");
    }
}
