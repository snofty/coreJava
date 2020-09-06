package com.snofty.java8.maxPrize;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMaximumPrize {

    private long finalPrize;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());

        List<Integer> list = new ArrayList<>();
        int opponents = 0;
        while (opponents++ != count) {
            list.add(s.nextInt());
        }
        System.out.println(new FindMaximumPrize().findMaxFrom(list));
    }

    public long findMaxFrom(List<Integer> sequences) {
        Integer lastOpponent = sequences.get(sequences.size() - 1);
        long max = findMax(sequences);
        return max + lastOpponent;
    }

    private long findMax(List<Integer> sequences) {
        if (sequences.size() == 1) {
            return finalPrize;
        }
        int maxIndex = findMaxIndex(sequences);
        Integer opponent = sequences.get(maxIndex);
        if (sequences.size() > 1 && maxIndex > 0) {
            int rightSideValue = sequences.get(maxIndex + 1);
            int leftSideValue = sequences.get(maxIndex - 1);
            int max = Math.max(rightSideValue, leftSideValue);
            int prize = (opponent * max) + Math.min(rightSideValue, leftSideValue);
            finalPrize += prize;
        } else if (maxIndex < sequences.size() - 1) {
            int leftSideValue = sequences.get(maxIndex + 1);
            finalPrize += opponent * leftSideValue;
        } else {
            finalPrize += opponent;
        }
        sequences.remove(maxIndex);
        return findMax(sequences);
    }

    private int findMaxIndex(List<Integer> list) {
        int max = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (max < list.get(i)) {
                index = i;
            }
        }
        return index;
    }
}
