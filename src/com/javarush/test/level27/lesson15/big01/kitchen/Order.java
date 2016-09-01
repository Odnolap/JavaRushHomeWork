package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Odnolap on 04.01.2016.
 */
public class Order
{
    protected List<Dish> dishes;

    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException
    {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        String result = "";
        if (!dishes.isEmpty())
        {
            result = "Your order: " + dishes + " of " + tablet;
        }

        return result;
    }

    public int getTotalCookingTime()
    {
        int result = 0;

        for (Dish d : dishes)
            result += d.getDuration();

        return result;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    public Tablet getTablet()
    {
        return tablet;
    }
}
