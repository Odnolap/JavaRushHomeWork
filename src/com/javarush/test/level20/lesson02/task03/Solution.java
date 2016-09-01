package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        load(fis);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            printWriter.println(pair.getKey() + " = " + pair.getValue());
        }
        printWriter.close();
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready())
        {
            String s = reader.readLine().trim();
            if (!(s.isEmpty()) && !(s.charAt(0) == '#') && !(s.charAt(0) == '!'))
            {
                int delimiterPos = s.indexOf('=');
                String key = s.substring(0, delimiterPos).replaceAll("\\\\", "").trim();
                String value = s.substring(delimiterPos + 2);
                while (value.charAt(value.length() - 1) == '\\')
                {
                    value = value.substring(0, value.length() - 1) + reader.readLine().trim();
                }
                properties.put(key, value);
            }
        }

        reader.close();
        inputStream.close();
    }

}
