package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Odnolap on 14.01.2016.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<>();
        int stepCount = (int)(Math.random() * 5) + 1;
        for (int i = 0; i < stepCount; i++)
        {
            dishes.add(Dish.values()[(int)(Math.random() * Dish.values().length)]);
        }
    }
}
