package com.sahil.lr.logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by slone on 4/20/17.
 */
public class ConsoleLogger {


    public static synchronized void log(String message) {
        System.out.println(message);

    }
}
