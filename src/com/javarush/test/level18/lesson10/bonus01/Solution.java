package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        //String paramString = args[0];
        //String[] paramsArray = paramString.split(" ");
        String[] paramsArray = args;
        FileInputStream fis = new FileInputStream(paramsArray[1]);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        byte[] resultBytes = new byte[bytes.length];
        FileOutputStream fos = new FileOutputStream(paramsArray[2]);

        if ("-e".equals(paramsArray[0]))
        {
            for (int i = 0; i < bytes.length; i++)
            {
                if (bytes[i] == (byte)127)
                {
                    resultBytes[i] = -128;
                }
                else
                {
                    resultBytes[i] = (byte)(bytes[i] + 1);
                }
            }
        }
        else if ("-d".equals(paramsArray[0]))
        {
            for (int i = 0; i < bytes.length; i++)
            {
                if (bytes[i] == (byte)-128)
                {
                    resultBytes[i] = 127;
                }
                else
                {
                    resultBytes[i] = (byte)(bytes[i] - 1);
                }
            }
        }

        fos.write(resultBytes);
        fis.close();
        fos.close();

    }

}
