package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here - напиши код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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

        String s = reader.readLine();
        if (montMap.containsKey(s.toUpperCase()))
        {
            System.out.println(s + " is " + (montMap.get(s.toUpperCase()) + 1) + " month");
        }
        else System.out.println("Неправильный месяц!");
    }

}
