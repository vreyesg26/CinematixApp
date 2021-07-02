/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author LosPibes
 */
public class log {

    public Logger logger;
    FileHandler fh;

    public log(String fileName) throws SecurityException, IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            f.createNewFile();
        }
        fh = new FileHandler(fileName, true);
        logger = Logger.getLogger("test");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }
}
