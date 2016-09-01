package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];

        FileInputStream is = new FileInputStream(fileName);
        int spaseCount = 0;
        int cnt = 0;
        int curLetter;

        while (is.available() > 0)
        {
            curLetter = is.read();
            cnt++;
            if (curLetter == ' ')
            {
                spaseCount++;
            }
        }

        if (cnt == 0)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(String.format("%.2f", (float) (spaseCount * 100) / cnt));
        }

        is.close();
    }
}
