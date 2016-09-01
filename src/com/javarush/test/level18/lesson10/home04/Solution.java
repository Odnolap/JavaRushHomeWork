package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
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


        FileInputStream f2 = new FileInputStream(f2n);
        FileInputStream f3 = new FileInputStream(f1n);

        int i2 = f2.available();
        int i3 = f3.available();
        byte[] b = new byte[i2 + i3];
        f2.read(b, 0, i2);
        f3.read(b, i2, i3);
        f2.close();
        f3.close();

        FileOutputStream f1 = new FileOutputStream(f1n);
        f1.write(b);

        f1.close();

    }
}
