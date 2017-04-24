package com.auto1.lr.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

/**
 * Created by slone on 4/20/17.
 */
public class CentralizedLogger {


    private static final String LOG_FILE = "logs/lone-ranger.log";
    private static Logger logger = Logger.getLogger(LOG_FILE);
    private static FileHandler fileHandler = null;

   static {
        try {
            fileHandler = new FileHandler(LOG_FILE);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            System.err.print("ERROR_LOG_INITIALIZE :");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static synchronized void log(LogLevel logLevel, String message, Throwable t) {
        try {

            switch (logLevel) {
                case ERROR:
                    logger.log(Level.SEVERE, message, t);
                    break;
                case INFO:
                    logger.log(Level.INFO, message, t);
                    break;
                case WARN:
                    logger.log(Level.WARNING, message, t);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
