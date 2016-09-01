package com.odnolap.test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Odnolap on 13.03.2015.
 */
public class Test4
{
    public static void main(String[] args)
    {
        System.out.println("Ob" + (float) 2 / 3);
        System.out.println(5 + '\u0042' + "Log");
        System.out.println("Log" + 5 + '\u0042');
        int i = '\u0040';
        System.out.println(i);
        String s = "Test";
        char[] ca = s.toCharArray();
        System.out.println(ca);
        s.getChars(0, s.length(), ca, 0);
        System.out.println(ca);

        // приведение к классу-"обертке"
        // также запрещено
        // !!! Некорректное утверждение в лекции на Интуите!!!
        Long a = 5L;

        System.out.println(a);

        String s2 = "+38(050)123-45-67";
        System.out.println(s2.replaceAll("[-()]",""));

        String s3 = "+38(050)123-45-67 test ii, ee";
        System.out.println(s3.replaceAll("\\W",""));
        String[] words = s3.split("\\W");
        for (String s4 : words)
        {
            System.out.println(s4);
        }

        System.out.println(' ');
        System.out.println((int)' ');
        System.out.println('d');
        System.out.println((int)'d');
        System.out.println('a');
        System.out.println((int)'a');

        String curFileName = "Lion.avi.part37";
        int i10 = Integer.parseInt(curFileName.substring(curFileName.lastIndexOf('.') + 5));
        System.out.println(i10);

        String l = String.format("%10s%10s", "раз", "два");
        System.out.println(l);
        System.out.printf("%-10s%-10s", "раз", "два");

        String l2 = String.format("%-10s%-10s", "раз", "два");
        System.out.println(l2);
        System.out.printf("%10s%10s", "раз", "два");
        System.out.println("\r\n");


        System.out.println(Runtime.getRuntime().availableProcessors());


    }
}
