package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filaName1 = reader.readLine();
        String filaName2 = reader.readLine();

        FileInputStream fIn = new FileInputStream(filaName1);
        FileOutputStream fOut = new FileOutputStream(filaName2);

        int i = 0;
        int curByte;

        while (fIn.available() > 0)
        {
            curByte = fIn.read();
            i++;
            if (i % 2 == 0)
            {
                fOut.write(curByte);
            }
        }

        fIn.close();
        fOut.close();
    }
}
