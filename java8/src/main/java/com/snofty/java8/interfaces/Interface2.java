package com.snofty.java8.interfaces;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Interface2 {
    Logger logger = Logger.getLogger(Interface2.class.getSimpleName());
    default void newMethod() {
        logger.log(Level.INFO, "in interface1");
    }
}
