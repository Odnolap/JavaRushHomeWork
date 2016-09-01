package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //Напишите тут ваш код
        HashSet<Integer> resultSet = new HashSet<Integer>();
        for (int i = 0; i < 20; i++)
        {
            resultSet.add(i);
        }

        return resultSet;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //Напишите тут ваш код
        HashSet<Integer> resultHashSet = (HashSet<Integer>)set.clone();
        Iterator<Integer> iterator = set.iterator();

        Integer i;
        while (iterator.hasNext())
        {
            i = iterator.next();
            if (i.intValue() > 10)
            {
                resultHashSet.remove(i);
            }
        }

        return resultHashSet;

    }

    public static void main(String[] args)
    {
        HashSet<Integer> mySet = createSet();
        mySet = removeAllNumbersMoreThan10(mySet);
        for (int i : mySet)
        {
            System.out.println(i);
        }
    }
}
