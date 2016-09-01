package com.javarush.test.level12.lesson12.home06;

/* Fly, Run, Climb для классов Cat, Dog, Tiger, Duck
1. Внутри класса Solution создай интерфейс public interface Fly(летать) с методом void fly().
2. Внутри класса Solution создай интерфейс public interface Climb(лазить по деревьям) с методом void climb().
3. Внутри класса Solution создай интерфейс public interface Run(бегать) с методом void run().
4. Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
5. Добавь интерфейсы классам Cat(кот), Dog(собака), Tiger(тигр), Duck(Утка).
*/

public class Solution {

    public static class Cat implements Climb, Run
    {
        public void climb()
        {
            System.out.println("Я лезу!");
        }

        public void run()
        {
            System.out.println("Я бегу!");
        }
    }

    public class Dog implements Run
    {
        public void run()
        {
            System.out.println("Я бегу!");
        }
    }

    public static class Tiger extends Cat
    {

    }

    public class Duck implements Fly, Run
    {
        public void fly()
        {
            System.out.println("Я лечу!");
        }

        public void run()
        {
            System.out.println("Я бегу!");
        }
    }

    interface Fly
    {
        void fly();
    }

    interface Climb
    {
        void climb();
    }

    interface Run
    {
        void run();
    }

}
