package com.snofty.java8.maxPrize;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FindMaximumPrizeTest {

    @Test(dataProvider = "getFighters")
    public void testFindMaxFrom(List<Integer> data, long max) {
        FindMaximumPrize findMaximumPrize = new FindMaximumPrize();
        long maxFrom = findMaximumPrize.findMaxFrom(data);
        Assert.assertEquals(maxFrom, max);
    }

    @DataProvider
    private Object[][] getFighters() {
        List<Integer> data = Lists.newArrayList(2, 5, 6, 7);
        List<Integer> data2 = Lists.newArrayList(7, 8,9);
        return new Object[][]{
                {data2, 151},
                {data, 105}
        };
    }
}