package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        int l = (i < k) ? i : k;
        int n = 1;
        for (int m = 1; m <= l + 1; m++)
        {
            if ((i % m == 0) && (k % m == 0)) n = m;
        }
        System.out.println(n);
    }
}
