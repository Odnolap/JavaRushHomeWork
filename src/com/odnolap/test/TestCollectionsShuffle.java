package com.odnolap.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * Created by Odnolap on 15.08.2015.
 */
public class TestCollectionsShuffle
{

    public static void main(String args[]) {
        String simpsons[] = { "Bart", "Hugo", "Lisa", "Marge", "Homer",
                "Maggie", "Roy" };
        List list1 = Arrays.asList(simpsons);
        List list2 = Arrays.asList(simpsons);
        Random rand = new Random(100);
        Collections.shuffle(list1, rand);
        Collections.shuffle(list2);
        System.out.println(list1);
        System.out.println(list2);
    }
}
