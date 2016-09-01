package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Odnolap on 20.03.2015.
 */
public class Singleton
{
    static Singleton singletonInstance = new Singleton();

    public static Singleton getInstance()
    {
        return singletonInstance;
    }

    private Singleton() {}
}
