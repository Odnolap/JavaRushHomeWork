package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName = reader.readLine();
        String outputFileName = reader.readLine();
        FileInputStream fIn = new FileInputStream(inputFileName);
        byte[] bytes = new byte[fIn.available()];
        byte[] bytesOut = new byte[fIn.available()];
        fIn.read(bytes);
        for (int i = 0; i < bytes.length; i++)
        {
            bytesOut[bytesOut.length - (i + 1)] = bytes[i];
        }
        FileOutputStream fOut = new FileOutputStream(outputFileName);
        fOut.write(bytesOut);
        fIn.close();
        fOut.close();

    }
}
