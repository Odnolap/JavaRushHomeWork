package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Odnolap on 04.01.2016.
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    public static String allDishesToString()
    {
        String result = "";
        for (Dish d : Dish.values())
            result += ", " + d;
        result = result.substring(2);
        return result;
    }

    public int getDuration()
    {
        return duration;
    }

    Dish(int duration)
    {
        this.duration = duration;
    }
}
