package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Odnolap on 20.03.2015.
 */
public class USD extends Money
{
    public String getCurrencyName()
    {
        return "USD";
    }

    public USD(double amount)
    {
        super(amount);
    }
}
