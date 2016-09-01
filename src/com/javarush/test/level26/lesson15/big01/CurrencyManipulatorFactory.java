package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Odnolap on 04.10.2015.
 */
public class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> currencyManipulators = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (currencyManipulators.containsKey(currencyCode))
            return currencyManipulators.get(currencyCode);
        else
        {
            CurrencyManipulator result = new CurrencyManipulator(currencyCode);
            currencyManipulators.put(currencyCode, result);
            return result;
        }
    }

    private CurrencyManipulatorFactory()
    {

    }

    public static Collection getAllCurrencyManipulators()
    {
        return currencyManipulators.values();
    }

}
