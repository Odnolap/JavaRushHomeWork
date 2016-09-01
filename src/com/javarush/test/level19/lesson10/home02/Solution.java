package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String, Double> map = new TreeMap<String, Double>();

//        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        BufferedReader file = new BufferedReader(new FileReader("C:\\Evgeniy\\test\\test.txt"));
        while (file.ready())
        {
            String s = file.readLine();
            String[] words = s.split(" ");
            String numStr = words[words.length - 1];
            String name = s.substring(0, s.length() - (numStr.length() + 1));
            if (map.containsKey(name))
            {
                map.put(name, map.get(name) + Double.parseDouble(numStr));
            }
            else
            {
                map.put(name, Double.parseDouble(numStr));
            }
        }

        file.close();

        double maxNum = 0;
        String result = "";
        for (Map.Entry<String, Double> pair: map.entrySet())
        {
            if (pair.getValue() > maxNum)
            {
                result = pair.getKey();
                maxNum = pair.getValue();
            }
            else if (pair.getValue() == maxNum)
            {
                result += " " + pair.getKey();
            }
        }

        System.out.println(result.trim());
    }
}
