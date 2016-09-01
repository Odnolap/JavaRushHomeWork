package com.javarush.test.level08.lesson11.home09;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static boolean isDateOdd(String date)
    {
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
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, yearI);
        cal.set(Calendar.MONTH, monthI);
        cal.set(Calendar.DAY_OF_MONTH, dayI);
        return (cal.get(Calendar.DAY_OF_YEAR) % 2 != 0);
    }
}
