package com.odnolap.test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Odnolap on 13.03.2015.
 */
public class TestFormat
{
    public static void main(String[] args)
    {
        float floatVar = 1.0f;
        int intVar = 2;
        String stringVar = "Wow!";

        System.out.printf("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        "and the string is %s",
                floatVar, intVar, stringVar);
        System.out.println("");

        String fs;
        fs = String.format("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        " and the string is %s",
                floatVar, intVar, stringVar);
        System.out.println(fs);

        int k = 461012;
        System.out.format("The value of i is: %d%n", k);
        System.out.println("---");
        System.out.format("The value of i is: %d", k);
        System.out.println("---");

        Date d = new Date();
        System.out.printf("Today is %td.%tm.%tY%n", d,d,d);

        long n = 461012;
        System.out.format("%,8d%n", n);

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

        System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

        System.out.format("%tD%n", c);

        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);

        // padding
        System.out.print(String.format("%5s", "").replace(' ', 'я'));
        System.out.println("---");

        long l = 1210128;
        DecimalFormat myFormatter = new DecimalFormat("###.##");
        String output = myFormatter.format(l * 1.0 / 100);
        System.out.println(output);

    }

    static public void customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }
}
