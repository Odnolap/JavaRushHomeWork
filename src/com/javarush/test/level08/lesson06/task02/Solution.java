package com.javarush.test.level08.lesson06.task02;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Провести 10 тысяч вставок, удалений
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // ArrayList
        System.out.println(new Date().getTime());
        ArrayList arrayList = new ArrayList();
        System.out.println(new Date().getTime());
        insert10000(arrayList);
        System.out.println(new Date().getTime());
        get10000(arrayList);
        System.out.println(new Date().getTime());
        set10000(arrayList);
        System.out.println(new Date().getTime());
        remove10000(arrayList);
        System.out.println(new Date().getTime());

        // LinkedList
        LinkedList linkedList = new LinkedList();
        System.out.println(new Date().getTime());
        insert10000(linkedList);
        System.out.println(new Date().getTime());
        get10000(linkedList);
        System.out.println(new Date().getTime());
        set10000(linkedList);
        System.out.println(new Date().getTime());
        remove10000(linkedList);
        System.out.println(new Date().getTime());
    }

    public static void insert10000(List list)
    {
        //Напишите тут ваш код
        for (int i = 0; i < 10000; i++)
        {
            list.add(0, new Integer(i));
        }

    }

    public static void get10000(List list)
    {
        //Напишите тут ваш код
        Object o;
        for (int i = 0; i < 10000; i++)
        {
            o = list.get(i);
        }

    }

    public static void set10000(List list)
    {
        //Напишите тут ваш код
        for (int i = 0; i < 10000; i++)
        {
            list.set(i, new Integer(i + 1));
        }

    }

    public static void remove10000(List list)
    {
        //Напишите тут ваш код
        for (int i = 10000; i > 0; i--)
        {
            list.remove(i / 2);
        }

    }
}
