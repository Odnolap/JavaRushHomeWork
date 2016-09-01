package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            Date d = new Date("qqq");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int i = Integer.parseInt("aaa");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] ia = new int[1];
            ia[2] = 3;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object o = "dddd";
            Float f = (Float) o;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            InputStream is = new FileInputStream("c:/aaa.txt");

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String s = null;
            System.out.println(s.toString());

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new EOFException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new EmptyStackException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }


    }
}
