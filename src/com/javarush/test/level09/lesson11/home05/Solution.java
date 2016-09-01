package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Написать тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        char[] chars = new char[s.length()];
        chars = s.toCharArray();
        ArrayList<Character> firstLine = new ArrayList<Character>();
        ArrayList<Character> secondLine = new ArrayList<Character>();

        for (char c : chars)
        {
            if (isVowel(c))
            {
                firstLine.add(c);
            }
            else if (!(c == ' '))
            {
                secondLine.add(c);
            }
        }

        boolean isFirstLetter = true;

        for (Character c : firstLine)
        {
            if (!isFirstLetter) System.out.print(" ");
            System.out.print(c);
            isFirstLetter = false;
        }
        System.out.println("");

        isFirstLetter = true;

        for (Character c : secondLine)
        {
            if (!isFirstLetter) System.out.print(" ");
            System.out.print(c);
            isFirstLetter = false;
        }
        System.out.println("");


    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
