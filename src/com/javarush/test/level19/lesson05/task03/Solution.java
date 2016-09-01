package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader fileIn = new BufferedReader(new FileReader(fileName1));
        String resultLine = "";

        while (fileIn.ready())
        {
            String[] words = fileIn.readLine().split(" ");
            for (String s : words)
            {
                if (s.length() != 0)
                {
                    try
                    {
                        Double d = Double.parseDouble(s);
                        resultLine += " " + s;
                    }
                    catch (NumberFormatException e)
                    {}
                }
            }
        }

        resultLine = resultLine.trim();
        FileWriter fileOut = new FileWriter(fileName2);
        fileOut.write(resultLine);

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
