package com.javarush.test.level09.lesson02.task02;

/* И снова StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static String method1()
    {
        method2();
        //Напишите тут ваш код
        int i = 0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            i++;
            if (i == 3)
            {
                return element.getMethodName();
            }
        }

        return "";

    }

    public static String method2()
    {
        method3();
        //Напишите тут ваш код
        int i = 0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            i++;
            if (i == 3)
            {
                return element.getMethodName();
            }
        }

        return "";

    }

    public static String method3()
    {
        method4();
        //Напишите тут ваш код
        int i = 0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            i++;
            if (i == 3)
            {
                return element.getMethodName();
            }
        }

        return "";

    }

    public static String method4()
    {
        method5();
        //Напишите тут ваш код
        int i = 0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            i++;
            if (i == 3)
            {
                return element.getMethodName();
            }
        }

        return "";

    }

    public static String method5()
    {
        //Напишите тут ваш код
        int i = 0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            i++;
            if (i == 3)
            {
                return element.getMethodName();
            }
        }

        return "";

    }
}
