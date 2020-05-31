package com.snofty.java8.fungames.flames;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FlamesGameTest {

    FlamesGame flamesGame = new FlamesGame();

    @Test
    public void testGuessFlame() {
        String guessFlame = flamesGame.guessFlame("Samantha", "Alexander");
        Assert.assertEquals(guessFlame,FlamesGame.FlamesEnum.ENEMIES.name());
    }
}