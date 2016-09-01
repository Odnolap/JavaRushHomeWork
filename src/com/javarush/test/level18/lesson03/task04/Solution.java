package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        int minCount = Integer.MAX_VALUE;
        int curByte;
        Byte curByteB;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream f = new FileInputStream(fileName);
        while (f.available() > 0)
        {
            curByte = f.read();
            curByteB = (byte)curByte;
            if (map.containsKey(curByteB))
            {
                map.put(curByteB, map.get(curByteB) + 1);
            }
            else
            {
                map.put(curByteB, 1);
            }
        }
        f.close();
        reader.close();

        for (Integer i: map.values())
        {
            if (i < minCount)
            {
                minCount = i;
            }
        }

        for (Map.Entry<Byte, Integer> pair : map.entrySet())
        {
            if (pair.getValue().equals(minCount))
            {
                byte b = pair.getKey();
                System.out.println(b);
            }
        }
    }
}
