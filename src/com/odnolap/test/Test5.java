package com.odnolap.test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Odnolap on 13.05.2015.
 */
public class Test5
{
    private static SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        return new BigInteger(60, random).toString(32);
    }

    public static void main(String[] args)
    {
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println("=========");

        String s1 = "Test";
        String s2 = s1;
        s2 = "TTT";
        System.out.println(s1);
        System.out.println(s2);

        int i1 = 0;
        int i2 = i1;
        i2 = 2;
        System.out.println(i1);
        System.out.println(i2);

        StringBuilder sb1 = new StringBuilder("rrr");
        StringBuilder sb2 = sb1;
        sb2.append("---");
        System.out.println(sb1);
        System.out.println(sb2);

        String s = "Good news everyone!";
        System.out.println(s.indexOf("ne", 17));
        System.out.println(s.lastIndexOf("ne",19));

        System.out.println("a" + '\t' + "b");
        System.out.println("Y".compareTo("Z"));
        System.out.println("Z".compareTo("b"));
        System.out.println("Z".compareTo("ф"));
        System.out.println("b".compareTo("ф"));
        System.out.println("Ф".compareTo("ф"));
/*

        try
        {
            s2.wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
*/

        System.out.format("Test %d = ", i2);

        System.out.println("----------");
        List<String> list = new ArrayList<>();
        list.add("bbb");
        list.add("ddd");
        list.add("hhh");
        list.add("fff");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

    }

}
