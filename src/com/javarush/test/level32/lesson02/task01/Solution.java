package com.javarush.test.level32.lesson02.task01;

import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution {
    public static void main(String... args) throws IOException {
//        String fileName = args[0];
        String fileName = "d:/no2.txt";
//        long number = Long.parseLong(args[1]);
        long number = 100L;
//        String text = args[2];
        String text = "new text";

        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        if (raf.length() < number) {
            number = raf.length();
        }
        raf.seek(number);
//        raf.writeBytes(text);
        String s = raf.readLine();
        System.out.println(s);
        raf.close();
    }
}
