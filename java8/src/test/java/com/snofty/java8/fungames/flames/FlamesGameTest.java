package com.snofty.java8.fungames.flames;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FlamesGameTest {

    FlamesGame flamesGame = new FlamesGame();

    @Test
    public void testGuessFlame() {
        String guessFlame = flamesGame.guessFlame("Samantha", "Alexander");
        Assert.assertEquals(guessFlame, FlamesGame.FlamesEnum.ENEMIES.name());
    }

    @Test(dataProvider = "getNames")
    public void fasterGuess(String playerOne, String playerTwo) {
        String guessFlame = flamesGame.guessFlameFaster(playerOne, playerTwo);
        Assert.assertEquals(guessFlame, FlamesGame.FlamesEnum.MARRIAGE.name());
    }

    @Test
    public void testFind(){
        String flameResult = flamesGame.findFlame(3);
        Assert.assertEquals(flameResult, FlamesGame.FlamesEnum.FRIENDSHIP.name());
    }

    @DataProvider
    private Object[][] getNames() {
        return new Object[][]{{"MOBILE", "LANDLINE"},{"Samantha", "Alexander"}};
    }
}