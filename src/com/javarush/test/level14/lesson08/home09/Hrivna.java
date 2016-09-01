package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Odnolap on 20.03.2015.
 */
public class Hrivna extends Money
{
    public String getCurrencyName()
    {
        return "HRN";
    }

    public Hrivna(double amount)
    {
        super(amount);
    }
}
