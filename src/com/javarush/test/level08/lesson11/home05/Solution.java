package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static java.lang.Character.isLetter;
import static java.lang.Character.toTitleCase;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
/*
        //Напишите тут ваш код
        s = s.substring(0,1).toUpperCase() + s.substring(1);

        for (int i = 0; i < s.length() - 1; i++)
        {
            if (" ".equals(s.substring(i, i + 1)))
            {
                s = s.substring(0, i + 1) + s.substring(i + 1, i + 2).toUpperCase() + s.substring(i + 2);
            }
        }

        System.out.println(s);
*/

        StringBuffer sb = new StringBuffer(s);
        char ch0 = toTitleCase(sb.charAt(0));
        sb.setCharAt(0, ch0);
        char ch;
        char ch1;
        char sp = ' ';
        for (int i = 0; i < s.length() - 1; i++) {
            ch = sb.charAt(i);
            ch1 = sb.charAt(i + 1);
            if (ch == sp && isLetter(ch1)) {
                sb.setCharAt(i + 1, toTitleCase(ch1));
            }
        }



        System.out.println(sb);
    }


}
