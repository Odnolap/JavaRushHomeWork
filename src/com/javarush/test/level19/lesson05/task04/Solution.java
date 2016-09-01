package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        BufferedReader fileIn = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName2));

        while (fileIn.ready())
        {
            fileOut.write(fileIn.readLine().replaceAll("[.]", "!"));
            fileOut.write("\r\n");
        }

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
