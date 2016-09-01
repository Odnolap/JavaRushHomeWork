package com.odnolap.test;

/**
 * Created by Odnolap on 10.03.2015.
 */
public class TestChild extends TestParent
{
    {
        x = 10;
        y = 12;
        System.out.println("Initialize block TestChild");
    }

    static int iS = sMethod1();

    public TestChild() {
        super();
        System.out.println("Constructor TestChild");
        System.out.println("tc - x = " + x);
        System.out.println("tc - y = " + y);
    }

    public TestChild(int i) {
        this();
        System.out.println("tsc i");
    }

    public static void main(String[] args)
    {
        TestChild tc = new TestChild(1);
        //System.out.println("А тут уже x = " + tc.x + ", а y = " + tc.y);
        TestChild.printHello();
        TestParent.printHello();
        TestParent p = new TestChild();
        p.printName();
        p.printHello();

        p.testPrivateMethod();
    }

    public void printName()
    {
        System.out.println("Это класс TestChild");
    }

    public static void printHello()
    {
        System.out.println("Привет от TestChild");
    }

    public static int sMethod1()
    {
        System.out.println("sMetod1 ib TestChild");
        return 13;
    }
}
