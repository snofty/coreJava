package com.snofty.java8;

import java.util.Random;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ForkAction extends RecursiveAction {
    private Logger logger = Logger.getLogger(ForkAction.class.getSimpleName());

    private int index;

    public ForkAction(int index) {
        this.index = index;
    }

    protected void compute() {
        int randomNumberInRange = getRandomNumberInRange(0, index*10);
        logger.log(Level.INFO,"{0} Started computing...{1}",new Object[]{index, randomNumberInRange});
        try {

            Thread.sleep(10000*randomNumberInRange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(index+" computing completed: "+randomNumberInRange);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
