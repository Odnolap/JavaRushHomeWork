package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Odnolap on 20.03.2015.
 */
public class Computer
{
    private Mouse mouse;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer()
    {
        mouse = new Mouse();
        monitor = new Monitor();
        keyboard = new Keyboard();
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }
}
