package com.odnolap.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Odnolap on 03.10.2015.
 */
public class ConcurrentHashMapTest
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Str1", 12);
        map.put("Str2", 88);
        map.put("Str3", 0);
        map.put("Str4", -2);
        map.put("Str5", 4);

/*
        for (String key: map.keySet())
        {
            if (map.get(key)==0)
                map.remove(key);
        }*/

        System.out.println(map.toString());

        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.put("Str1", 12);
        map2.put("Str2", 88);
        map2.put("Str3", 0);
        map2.put("Str4", -2);
        map2.put("Str5", 4);

        for (String key: map2.keySet())
        {
            if (map2.get(key)==0)
                map2.remove(key);
        }

        System.out.println(map2.toString());
    }
}
