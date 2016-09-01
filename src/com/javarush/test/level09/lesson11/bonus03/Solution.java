package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //Напишите тут ваш код
        String[] sa1 = new String[array.length];
        ArrayList<String> wordList = new ArrayList<String>();
        ArrayList<String> digitList = new ArrayList<String>();

        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                sa1[i] = "N";
                digitList.add(array[i]);
            }
            else
            {
                sa1[i] = "L";
                wordList.add(array[i]);
            }
        }

        //Sort wordList
        boolean b = false;
        String s;
        while (!b)
        {
            b = true;
            for (int i = 1; i < wordList.size(); i++)
            {
                if (isGreaterThen(wordList.get(i - 1), wordList.get(i)))
                {
                    s = wordList.get(i);
                    wordList.set(i, wordList.get(i - 1));
                    wordList.set(i - 1, s);
                    b = false;
                }
            }
        }

        //Sort digitList
        b = false;
        while (!b)
        {
            b = true;
            for (int i = 1; i < digitList.size(); i++)
            {
                if (Integer.parseInt(digitList.get(i)) > Integer.parseInt(digitList.get(i - 1)))
                {
                    s = digitList.get(i);
                    digitList.set(i, digitList.get(i - 1));
                    digitList.set(i - 1, s);
                    b = false;
                }
            }
        }


        int iWord = 0;
        int iDig = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (sa1[i] == "N")
            {
                array[i] = digitList.get(iDig++);
            }
            else
            {
                array[i] = wordList.get(iWord++);
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
