package com.snofty.java8.interfaces;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Interface1 {
    Logger logger = Logger.getLogger(Interface1.class.getSimpleName());
    default void newMethod() {
        logger.log(Level.INFO, "new method in interface1");
    }

    static void check(){
        logger.log(Level.INFO, "checking in interface1");
    }
}
