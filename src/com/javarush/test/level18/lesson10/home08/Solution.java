package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!"exit".equals(fileName))
        {
            new ReadThread(fileName).start();
            fileName = reader.readLine();
        }

        reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Integer, Integer> bytesOfFile = new HashMap<Integer, Integer>();

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run()
        {
            try
            {
                int i;
                FileInputStream file = new FileInputStream(fileName);
                while (file.available() > 0)
                {
                    i = file.read();
                    if (bytesOfFile.containsKey(i))
                    {
                        bytesOfFile.put(i, bytesOfFile.get(i) + 1);
                    }
                    else
                    {
                        bytesOfFile.put(i, 1);
                    }
                }
                file.close();

                int maxCnt = 0;
                int winnerByte = 0;
                for (Map.Entry<Integer, Integer> pair : bytesOfFile.entrySet())
                {
                    if (pair.getValue() >= maxCnt)
                    {
                        winnerByte = pair.getKey();
                        maxCnt = pair.getValue();
                    }
                }

                resultMap.put(fileName, winnerByte);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
