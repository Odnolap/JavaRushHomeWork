package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        //String fileName = "C:\\Evgeniy\\test\\test.txt";

        FileInputStream is = new FileInputStream(fileName);
        int eLCount = 0;
        int curLetter;

        while (is.available() > 0)
        {
            curLetter = is.read();
            if ((curLetter >= 'a' && curLetter <= 'z') || (curLetter >= 'A' && curLetter <= 'A'))
            {
                eLCount++;
            }
        }
        System.out.println(eLCount);

        is.close();
    }
}
