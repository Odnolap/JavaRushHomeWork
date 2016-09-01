package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        OutputStream f = new FileOutputStream(s);
        int i;

        do
        {
            s = r.readLine();
            char[] ca = new char[s.length()];
            ca = s.toCharArray();
            for (char c : ca)
            {
                f.write((int)c);
            }
            f.write(13);
            f.write(10);
        }
        while (!"exit".equals(s));

        f.close();
    }
}
