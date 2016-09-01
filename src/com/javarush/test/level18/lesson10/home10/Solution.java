package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<Integer, byte[]> map = new HashMap<Integer, byte[]>();
        String resultFileName;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String curFileName = reader.readLine();
        resultFileName = curFileName.substring(0, curFileName.lastIndexOf('.'));

        while (!"end".equals(curFileName))
        {
            FileInputStream fis = new FileInputStream(curFileName);
            byte[] ba = new byte[fis.available()];
            fis.read(ba);

            int filesNumber = Integer.parseInt(curFileName.substring(curFileName.lastIndexOf('.') + 5));

            map.put(filesNumber, ba);
            fis.close();
            curFileName = reader.readLine();

        }

        reader.close();

        FileOutputStream resFile = new FileOutputStream(resultFileName);
        for (int i = 1; i <= map.size(); i++)
        {
            resFile.write(map.get(i));
        }

        resFile.close();
    }
}
