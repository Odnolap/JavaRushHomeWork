package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1n = reader.readLine();
        String f2n = reader.readLine();
        String f3n = reader.readLine();

        FileOutputStream f1 = new FileOutputStream(f1n);
        FileInputStream f2 = new FileInputStream(f2n);
        FileInputStream f3 = new FileInputStream(f3n);

        int i2 = f2.available();
        int i3 = f3.available();
        byte[] b = new byte[i2 + i3];
        f2.read(b, 0, i2);
        f3.read(b, i2, i3);
        f1.write(b);

        f1.close();
        f2.close();
        f3.close();

    }
}
