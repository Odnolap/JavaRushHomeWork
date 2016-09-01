package com.odnolap.test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Odnolap on 10.03.2015.
 */
public class Test2
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        System.out.println(list.size());
        list.add("str1");
        System.out.println(list.size());
        list.add("str2");
        System.out.println(list.size());
        list.add("str3");
        System.out.println(list.size());
        String s = list.get(2);
        System.out.println(s);

        double d = 1;

        System.out.println("Next about ArrayList");

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        Collections.addAll(list1, 1, 5, 6, 11, 3, 15, 7, 8);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        Collections.addAll(list2, 1, 8, 6, 21, 53, 5, 67, 18);

        ArrayList<Integer> result = new ArrayList<Integer>();

        result.addAll(list1);
        result.addAll(list2);

        for (Integer x : result)
        {
            System.out.println(x);
        }

        int i = s.indexOf('p');
        System.out.println(i);

    }
}
