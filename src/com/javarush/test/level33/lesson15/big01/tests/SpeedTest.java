package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startTime = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return new Date().getTime() - startTime.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startTime = new Date();
        for (Long l : ids) {
            strings.add(shortener.getString(l));
        }
        return new Date().getTime() - startTime.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>(10000);
        for (int i = 0; i < 10000; i++){
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> ids1 = new HashSet<>(10000);
        Set<Long> ids2 = new HashSet<>(10000);
        long l1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        long l2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(l1 > l2);

        Set<String> strings1 = new HashSet<>(10000);
        Set<String> strings2 = new HashSet<>(10000);
        l1 = getTimeForGettingStrings(shortener1, ids1, strings1);
        l2 = getTimeForGettingStrings(shortener2, ids2, strings2);
        Assert.assertEquals(l1, l2, 5F);
    }
}
