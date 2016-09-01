package com.javarush.test.level26.lesson15.big01;

/**
 * Created by Odnolap on 04.10.2015.
 */
public enum Operation
{
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException
    {
        try
        {
            if (i == 0)
                throw new IllegalArgumentException();
            else
                return Operation.values()[i];
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException();
        }
    }
}
