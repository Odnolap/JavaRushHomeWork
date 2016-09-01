package com.odnolap.test;

/**
 * Created by Odnolap on 14.03.2015.
 */
public class TestExtend
{
    public static void main(String[] args)
    {
        Parent p = new Parent();
        Child c = new Child();
        Parent p2 = new Child();

        Child.printHello();
        p.printHello();
        c.printHello();
        p2.printHello();

        p.printName();
        c.printName();
        p2.printName();
    }

    public static class Parent
    {
        public void printName()
        {
            System.out.println("Это класс Parent");
        }

        public static void printHello()
        {
            System.out.println("Привет от Parent");
        }
    }

    public static class Child extends Parent
    {
        public void printName()
        {
            System.out.println("Это класс Child");
        }

        public static void printHello()
        {
            System.out.println("Привет от Child");
        }

    }

}
