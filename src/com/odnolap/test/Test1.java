package com.odnolap.test;

/**
 * Created by Odnolap on 28.02.2015.
 */
public class Test1
{
    public static void main(String[] args)
    {
        String s = "<second></second>";
        int l = s.length() - 1;
        System.out.println(l % 2 == 0);
        System.out.println( s.substring(0, l / 2).equals(s.substring(l / 2).replace("/", "")));
        System.out.println( s.indexOf('<') == 0);
        System.out.println(s.indexOf('<', 1) == l / 2);
        System.out.println(s.indexOf('<', l / 2 + 1) == -1);
        System.out.println(s.indexOf('>') == l / 2 - 1);
        System.out.println(s.indexOf('>', l / 2) == l);
        System.out.println( s.indexOf('/') == l / 2 + 1);
        System.out.println(s.lastIndexOf('/') == l / 2 + 1);
        System.out.println("------");

            String s1 = new String("Test text");
        String s2 = new String("Test text");
        System.out.println(s1.equals(s2));

        int x, y, z;
        x = 1;
        y = ++x;
        z = x++;

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        float f;
        f = (float) x / 2;
        y = x / 2;
        System.out.println(f);
        System.out.println(y);
        f = 3 / 2;
        System.out.println(f);

        char c = 71;
        System.out.println(c);

        System.out.println("a.txt".lastIndexOf(".txt"));
        System.out.println(1 % 10 + 1);
    }
}
