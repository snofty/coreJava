package com.snofty.java8.fungames.flames;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlamesGame {
    private static final Map<Integer, String> mappings = new HashMap<>();
    private static final Logger log = Logger.getLogger(FlamesGame.class.getSimpleName());

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

    public String guessFlameFaster(String playerOne, String playerTwo){
        int[] charCounts = new int[100];
        playerOne = playerOne.toUpperCase();
        playerTwo = playerTwo.toUpperCase();
        for (int i = 0; i < playerOne.length(); i++) {
            charCounts[(int)playerOne.charAt(i)] = 1;
        }
        for (int i = 0; i < playerTwo.length(); i++) {
            int currentChar = playerTwo.charAt(i);
            int current = charCounts[currentChar];
            if(current == 0){
                charCounts[currentChar] =  3;
            }else if(current >= 3){
                charCounts[currentChar] = charCounts[currentChar]+1;
            }else {
                charCounts[currentChar] = 2;
            }
        }
        int totalCounts = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charCounts.length; i++) {
            int charCount = charCounts[i];
            if(charCount == 0){
                continue;
            }
            sb.append(String.format("%s count: %d",Character.toString((char)i), charCount))
                    .append(", ");
            if(charCount == 3 || charCount == 1){
                ++totalCounts;
            }else if(charCount > 3){
                totalCounts += (charCount -2);
            }
        }
        info(sb.toString());
        log.info("totalcounts: "+totalCounts);
        int pointer = totalCounts % mappings.size();
        return mappings.get(pointer);
    }

    public String findFlame(int count){
        char[] flamesc = "flames".toCharArray();
        String flames = "FLAMES";
        while(flames.length()!=1){
            flames = flames.substring(count, flames.length()-1).concat(flames.substring(0, count));
        }
        return flames;
    }

    private void info(String msg, Object ...args){
        log.log(Level.INFO, String.format(msg, args));
    }

    public enum FlamesEnum {
        FRIENDSHIP, LOVE, AFFECTION, MARRIAGE, ENEMIES, SISTER;
    }
}

