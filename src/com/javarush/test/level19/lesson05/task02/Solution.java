package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int cnt = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader file = new BufferedReader(new FileReader(fileName));

        while (file.ready())
        {
            String s = file.readLine().replaceAll("\\W", " ");

            String[] words = s.split(" ");
            for (String w : words)
            {
                if ("world".equals(w))
                {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        file.close();
        reader.close();
    }
}
