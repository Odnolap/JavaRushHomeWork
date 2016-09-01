package com.odnolap.test;

/**
 * Created by Odnolap on 10.03.2015.
 */
public class TestParent
{
    int x = 1;
    int y;

    {
        System.out.println("Before Initialize block TestParent x = " + x + " and y = " + y);
        x = 5;
        // y = 7;
        System.out.println("After Initialize block TestParent x = " + x + " and y = " + y);
    }
    public TestParent()
    {
        System.out.println("constructor TestParent");
        System.out.println("x = " + x);
        this.x = 9;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    public void printName()
    {
        System.out.println("Это класс TestParent");
    }

    public static void printHello()
    {
        System.out.println("Привет от TestParent");
    }

    private void privateMethod()
    {
        System.out.println("We are in private method privateMethod now!");
    }

    public void testPrivateMethod()
    {
        System.out.println("Now we will try to call private method in parent class.");
        privateMethod();
    }

    public static int sMethod2()
    {
        System.out.println("sMetod2 ib TestParent");
        return 11;
    }

    public static int iS2 = sMethod2();
}
