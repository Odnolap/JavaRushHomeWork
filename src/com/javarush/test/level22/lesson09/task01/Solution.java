package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader consReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consReader.readLine();
        consReader.close();

        BufferedReader f = new BufferedReader(new FileReader(fileName));
        List<String> words = new ArrayList<>();
        while (f.ready())
        {
            words.addAll(Arrays.asList(f.readLine().split(" ")));
        }

        f.close();

        for (int i = 0; i < words.size(); i++)
        {
            for (int j = i + 1; j < words.size(); j++)
            {
                if (words.get(i).equals(new StringBuilder(words.get(j)).reverse().toString()))
                {
                    Pair p = new Pair();
                    p.first = words.get(i);
                    p.second = words.get(j);
                    result.add(p);
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
