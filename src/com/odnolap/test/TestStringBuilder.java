package com.odnolap.test;

/**
 * Created by Odnolap on 09.08.2015.
 */
public class TestStringBuilder
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder(".".intern());
        sb.setLength(10);
        System.out.println(sb);

        TestStringBuilder t = new TestStringBuilder();

        System.out.println(t.getClass().getPackage().getName());
    }
}
