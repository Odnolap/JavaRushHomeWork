package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        int curByte;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream f = new FileInputStream(fileName);
        while (f.available() > 0)
        {
            curByte = f.read();
            if (!list.contains(curByte))
            list.add(curByte);
        }
        f.close();
        reader.close();

        int[] bytes = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            bytes[i] = list.get(i);
        }

        boolean b = false;
        int k;
        while (!b)
        {
            b = true;
            for (int i = 1; i < bytes.length; i++)
            {
                if (bytes[i] < bytes[i - 1])
                {
                    k = bytes[i];
                    bytes[i] = bytes[i - 1];
                    bytes[i - 1] = k;
                    b = false;
                }
            }
        }

        for (int i : bytes)
        {
            System.out.println(i);
        }
    }
}
