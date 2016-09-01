package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public static int min(int i1, int i2)
    {
        return i1 < i2 ? i1 : i2;
    }

    public static long min(long l1, long l2)
    {
        return l1 < l2 ? l1 : l2;
    }

    public static double min(double d1, double d2)
    {
        return d1 < d2 ? d1 : d2;
    }
}
