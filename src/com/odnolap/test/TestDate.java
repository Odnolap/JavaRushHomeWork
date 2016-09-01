package com.odnolap.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Odnolap on 12.03.2015.
 */
public class TestDate
{
    public static void main(String[] args) throws java.text.ParseException
    {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR) % 2);
        cal.set(Calendar.YEAR, 2014);
        System.out.println(cal.getTime());
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.YEAR, 1978);
        System.out.println(cal.getTime());

        DateFormat df = DateFormat.getDateInstance();
        Date d = df.parse("01.02.2015");
        System.out.println(d);

        String date = "JANUARY 1 2000";
        int i = date.indexOf(" ");
        int j = date.indexOf(" ", i + 1);
        String month = date.substring(0, i);
        String day = date.substring(i + 1, j);
        String year = date.substring(j + 1);
        int dayI = Integer.parseInt(day);
        int yearI = Integer.parseInt(year);
        Map<String, Integer> montMap = new HashMap<String, Integer>();
        montMap.put("JANUARY", 0);
        montMap.put("FEBRUARY", 1);
        montMap.put("MARCH", 2);
        montMap.put("APRIL", 3);
        montMap.put("MAY", 4);
        montMap.put("JUNE", 5);
        montMap.put("JULY", 6);
        montMap.put("AUGUST", 7);
        montMap.put("SEPTEMBER", 8);
        montMap.put("OCTOBER", 9);
        montMap.put("NOVEMBER", 10);
        montMap.put("DECEMBER", 11);

        int monthI = montMap.get(month);
        System.out.println(month + day + year);
        System.out.println(monthI + " " + dayI + " " + yearI);

        cal.set(Calendar.YEAR, yearI);
        cal.set(Calendar.MONTH, monthI);
        cal.set(Calendar.DAY_OF_MONTH, dayI);
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR) % 2);

        Date d2 = new Date("JANUARY 1 2000");
        System.out.println(d2);

        Date d3 = new Date();
        Date d4 = new Date(d3.getYear(), 0, 1);
        System.out.println(d4);

        System.out.println("b".compareTo("a"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println(dateFormat.format(new Date()));
        System.out.println(dateFormat.format(Calendar.getInstance().getTime()));

    }

   /* public static void main(String[] args)
    {
        System.out.println("main begin");
        try
        {
            System.out.println("main before call");

            method1();

            System.out.println("main after call");
        }
        catch (RuntimeException e)
        {
            String s = e.getMessage();
            System.out.println(s);
        }
        System.out.println("main end");
    }

    public static void method1()
    {
        System.out.println("method1 begin");
        method2();

        System.out.println("method1 end");
    }

    public static void method2()
    {
        System.out.println("method2");
        String s = "Message: Unknown Exception";
        throw new RuntimeException(s);
    }*/
}
