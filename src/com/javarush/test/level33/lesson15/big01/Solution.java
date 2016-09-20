package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> result = new HashSet<>();
        for (String s: strings) {
            result.add(shortener.getId(s));
        }

        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> result = new HashSet<>();
        for (Long l: keys) {
            result.add(shortener.getString(l));
        }

        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (long l = 0; l < elementsNumber; l++){
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date startTime = new Date();
        Set<Long> keys = getIds(shortener, strings);
        Helper.printMessage(String.valueOf(new Date().getTime() - startTime.getTime()));

        startTime = new Date();
        Set<String> strings2 = getStrings(shortener, keys);
        Helper.printMessage(String.valueOf(new Date().getTime() - startTime.getTime()));

        if (strings2.equals(strings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 20000);
        testStrategy(new OurHashMapStorageStrategy(), 20000);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), 20000);
        testStrategy(new HashBiMapStorageStrategy(), 20000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 20000);
    }
}
