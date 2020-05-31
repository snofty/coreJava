package com.snofty.java8.fungames.flames;

import java.util.HashMap;
import java.util.Map;

public class FlamesGame {
    private static final Map<Integer, String> mappings = new HashMap<>();

    static {
        mappings.put(1, FlamesEnum.FRIENDSHIP.name());
        mappings.put(2, FlamesEnum.LOVE.name());
        mappings.put(3, FlamesEnum.AFFECTION.name());
        mappings.put(4, FlamesEnum.MARRIAGE.name());
        mappings.put(5, FlamesEnum.ENEMIES.name());
        mappings.put(6, FlamesEnum.SISTER.name());
    }

    public String guessFlame(String playerOne, String playerTwo) {
        String temp = playerTwo.concat(playerOne);
        Map<Character, Integer> remainingChars = new HashMap<>();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            remainingChars.compute(c, (s, count) -> {
                if (count == null) {
                    return 1;
                } else {
                    return ++count;
                }
            });
        }
        int totalRemainCount = remainingChars.values().stream().mapToInt(Integer::intValue).sum();
        int pointer = totalRemainCount % mappings.size();
        return mappings.get(pointer);
    }

    public enum FlamesEnum {
        FRIENDSHIP, LOVE, AFFECTION, MARRIAGE, ENEMIES, SISTER;
    }
}

