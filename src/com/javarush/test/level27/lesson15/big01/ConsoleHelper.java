package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Odnolap on 04.01.2016.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        String s = null;
        s = reader.readLine();
        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        ArrayList<Dish> result = new ArrayList<>();
        String s;

        writeMessage("Add dish from list: " + Dish.allDishesToString());
        do
        {
            s = readString();
            if (!"exit".equalsIgnoreCase(s))
                try
                {
                    result.add(Dish.valueOf(s));
                }
                catch (IllegalArgumentException e)
                {
                    writeMessage(s + " is not detected");
                }
        }
        while (!"exit".equalsIgnoreCase(s));

        return result;
    }
}
