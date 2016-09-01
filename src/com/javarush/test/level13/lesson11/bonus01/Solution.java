package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        InputStream f = new FileInputStream(s);
        int i;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int dig = 0;
        boolean isNewDig = true;
        Character c;
        while (f.available() > 0)
        {
            i = f.read();
            c = (char)i;
            if (Character.isDigit(c))
            {
                if (isNewDig)
                {
                    dig = Integer.parseInt(Character.toString(c));
                    isNewDig = false;
                }
                else
                {
                    dig = dig * 10 + Integer.parseInt(Character.toString(c));
                }
            }
            else if (!isNewDig)
            {
                isNewDig = true;
                if (dig % 2 == 0) list.add(dig);
            }
        }

        if (!isNewDig)
        {
            if (dig % 2 == 0) list.add(dig);
        }

        f.close();

        int[] array = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++)
        {
            array[i2] = list.get(i2);
        }

        boolean b = false;
        int k;
        while (!b)
        {
            b = true;
            for (int i3 = 1; i3 < array.length; i3++)
            {
                if (array[i3] < array[i3 - 1])
                {
                    k = array[i3];
                    array[i3] = array[i3 - 1];
                    array[i3 - 1] = k;
                    b = false;
                }
            }
        }

        for (int i4 : array)
        {
            System.out.println(i4);
        }
    }
}
