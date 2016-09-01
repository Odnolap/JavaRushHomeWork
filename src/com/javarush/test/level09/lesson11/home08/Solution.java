package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Collections;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //Написать тут ваш код
        ArrayList<int[]> result = new ArrayList<int[]>();
        int[] a1 = new int[5];
        int[] a2 = new int[2];
        int[] a3 = new int[4];
        int[] a4 = new int[7];
        int[] a5 = new int[0];

        Collections.addAll(result, a1, a2, a3, a4, a5);

        for (int[] array: result )
        {
            for (int i = 0; i < array.length; i ++)
            {
                array[i] = i;
            }
        }

        return result;

    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
