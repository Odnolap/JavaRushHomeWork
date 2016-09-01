package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final int medianInt;
        if (array.length % 2 != 0)
            medianInt = array[array.length / 2];
        else
            medianInt = (array[array.length / 2] + array[array.length / 2 -1]) / 2;

        Comparator<Integer> myComparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if (o1.equals(o2))
                    return 0;
                else if (Math.abs(o1 - medianInt) == Math.abs(o2 - medianInt))
                    return o1 - o2;
                else
                    return Math.abs(o1 - medianInt) - Math.abs(o2 - medianInt);
            }
        };
        Arrays.sort(array, myComparator);

        return array;
    }

    public static void main(String[] args)
    {
        Integer[] integers = new Integer[]{4, 6, 7, 14, 55, 33, 0, -12};
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
