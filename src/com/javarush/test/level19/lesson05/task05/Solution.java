package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
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
            //Удаляем все знаки препинания
            fileOut.write(fileIn.readLine().replaceAll("\\p{Punct}", ""));
            fileOut.write("\r\n");
        }

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
