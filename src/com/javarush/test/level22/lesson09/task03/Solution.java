package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader consReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consReader.readLine();
        consReader.close();

        BufferedReader f = new BufferedReader(new FileReader(fileName));
        Set<String> words = new HashSet<>();
        while (f.ready())
        {
            words.addAll(Arrays.asList(f.readLine().split(" ")));
        }

        f.close();

        System.out.println("Тестовая строка");

        StringBuilder result = getLine(words.toArray(new String[1]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        StringBuilder result = new StringBuilder();

        List<String> wList = new ArrayList<>();
        wList.addAll(Arrays.asList(words));

        boolean isCorrect = false;
        while(!isCorrect)
        {
            Collections.shuffle(wList);
            isCorrect = true;
            for (int i = 0; i < wList.size() - 1 && isCorrect; i++)
            {
                if (wList.get(i).toUpperCase().charAt(wList.get(i).length() - 1) != wList.get(i + 1).toUpperCase().charAt(0))
                {
                    isCorrect = false;
                }
            }
        }

        for (int i = 0; i < wList.size(); i++)
        {
            if (result.length() != 0) result.append(" ");
            result.append(wList.get(i));
        }

        return result;
    }
}
