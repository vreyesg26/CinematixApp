/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import cinematixapp.CinematixApp;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author LosPibes
 */
public class log {



    public void LogBitacora(String error) {
        java.util.Date fecha = new java.util.Date();
        DateFormat f = new SimpleDateFormat("yyy-MM-dd");
        String fileName = ".\\src\\Logs" + f.format(fecha) + ".txt";

        try {
            PrintStream ps = new PrintStream(new BufferedOutputStream(
                    new FileOutputStream(new File(fileName), true)), true);
            java.util.Date fecha2 = new java.util.Date();
            DateFormat f2 = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
            String fechaActual = f2.format(fecha2);
            ps.println(fechaActual + " -- " + error);

            ps.close();

            System.setOut(ps);
            System.setErr(ps);

        } catch (FileNotFoundException ex) {
            System.err.println("Se ha producido una excepción file fallo" + ex);

        }

    }
    //ESTO ES LO VIEJO
  /*  public Logger logger;
    FileHandler fh;

    public log(String fileName) throws SecurityException, IOException {
        final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CinematixApp.class);

        logger.debug("Este es debug: " + "parameter/exception Object");
        logger.info("Este es info: " + "parameter/exception Object");
        logger.warn("Este es warn: " + "parameter/exception Object");
        logger.error("Este es error: " + "parameter/exception Object");
        logger.fatal("Este es fatal: " + "parameter/exception Object");
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();  
        }
        fh = new FileHandler(fileName, true);

        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }*/
}
