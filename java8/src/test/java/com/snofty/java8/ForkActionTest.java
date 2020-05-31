package com.snofty.java8;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

import static org.testng.Assert.*;

public class ForkActionTest {
    Logger logger = Logger.getLogger(ForkActionTest.class.getSimpleName());
    @Test
    public void testForkPool(){
        ForkJoinPool pool = new ForkJoinPool(
                6, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
        List<ForkAction> actions = new ArrayList<>();

        ForkAction forkAction = new ForkAction(1);
        ForkAction forkAction2 = new ForkAction(2);
        actions.add(forkAction);
        actions.add(forkAction2);

        pool.execute(forkAction);
        pool.execute(forkAction2);
        logger.info("Completed test");
        actions.forEach(ForkAction::join);
    }

    @Test
    public void testRunnableFork() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> tasks = new ArrayList<>();
        for (int i=0;i< 12; i++){
            logger.info("now it is i: "+i);
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    logger.info("running ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Future<?> future = executorService.submit(runnable);
            tasks.add(future);
        }
        tasks.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //executorService.shutdown();
    }
}