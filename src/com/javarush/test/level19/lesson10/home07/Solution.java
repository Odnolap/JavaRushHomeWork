package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
//        BufferedReader file1 = new BufferedReader(new FileReader("C:\\Evgeniy\\test\\test.txt"));
        FileWriter file2 = new FileWriter(args[1]);
//        FileWriter file2 = new FileWriter("C:\\Evgeniy\\test\\test2.txt");

        String result = "";
        while (file1.ready())
        {
            String line = file1.readLine();
            String[] words = line.split(" ");
            for (String s : words)
            {
                if (s.length() > 6)
                {
                    result += "," + s;
                }
            }
        }

        file2.write(result.substring(1));

        file1.close();
        file2.close();

    }
}
