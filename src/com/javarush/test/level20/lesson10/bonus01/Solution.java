package com.javarush.test.level20.lesson10.bonus01;


import java.util.LinkedList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {

        List<Integer> l = new LinkedList<>();
        int k;
        int kPow;
        int n;
        double d;
        int power = 1;
        int nextPowerIncrease = 10;
        //l.add(0);

        for (int i = 1; i < N; i++)
        {
            n = i;
            d = 0.0;
            if (i == nextPowerIncrease)
            {
                power++;
                nextPowerIncrease *= 10;
            }

            do
            {
                k = n % 10;
//                d += Math.pow(k, power);

                n = n/10;
            }
            while (n != 0);

            if ((int)d == i)
            {
                l.add(i);
            }
        }

        int[] result = new int[l.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = l.get(0);
            l.remove(0);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] ia = getNumbers(10000000);
        for (int i : ia )
        {
            System.out.println(i);
        }
    }
}
