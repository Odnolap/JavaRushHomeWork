package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String outputFileName1 = reader.readLine();
        String outputFileName2 = reader.readLine();
        FileInputStream fIn = new FileInputStream(inputFileName);
        int sizeFull = fIn.available();
        byte[] bytes = new byte[sizeFull];
        int size2 = sizeFull / 2;;
        fIn.read(bytes);
        FileOutputStream fOut1 = new FileOutputStream(outputFileName1);
        FileOutputStream fOut2 = new FileOutputStream(outputFileName2);
        fOut1.write(bytes, 0, sizeFull - size2);
        fOut2.write(bytes, sizeFull - size2, size2);
        fIn.close();
        fOut1.close();
        fOut2.close();

    }
}
