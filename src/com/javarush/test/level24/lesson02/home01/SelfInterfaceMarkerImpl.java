package com.javarush.test.level24.lesson02.home01;

/**
 * Created by Odnolap on 03.09.2015.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{
    public SelfInterfaceMarkerImpl()
    {

    }

    public void printHelloWorld()
    {
        System.out.println("Hello World!");
    }

    public String whatsYourName()
    {
        return "My name is " + getClass().getSimpleName();
    }
}
