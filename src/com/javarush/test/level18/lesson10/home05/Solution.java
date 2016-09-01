package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1n = reader.readLine();
        String f2n = reader.readLine();

        BufferedReader f1 = new BufferedReader(new InputStreamReader(new FileInputStream(f1n)));
        String s1 = f1.readLine();
        while (f1.ready())
        {
            s1 += " " + f1.readLine();
        }
        f1.close();
        FileOutputStream f2 = new FileOutputStream(f2n);
        String[] f1Numbers = s1.split(" ");
        for (String s : f1Numbers)
        {
            double d = Double.parseDouble(s);
            long l = Math.round(d);
            f2.write(String.valueOf(l).getBytes());
            f2.write(' ');
        }
        f2.close();

    }
}
