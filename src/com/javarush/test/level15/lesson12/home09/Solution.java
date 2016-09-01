package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        // Оставили тольео параметры
        s = s.substring(s.indexOf('?') + 1);
        String[] sa = s.split("&");
        String objValue = "";
        Integer objValueInt = null;
        String parametrName = "";
        String result = "";
        for (String parametrWithValue : sa)
        {
            if (parametrWithValue.indexOf('=') >= 0)
            {
                parametrName = parametrWithValue.substring(0, parametrWithValue.indexOf('='));

            }
            else
            {
                parametrName = parametrWithValue;
            }

            result = result + parametrName + " ";

            if ("obj".equals(parametrName) && parametrWithValue.indexOf('=') >= 0)
            {
                objValue = parametrWithValue.substring(parametrWithValue.indexOf('=') + 1);
                try
                {
                    objValueInt = new Integer(objValue);
                }
                catch (Exception e) {}
            }

        }

        System.out.println(result.trim());

        if (objValue.indexOf('.') >= 0 || objValueInt != null)
        {
            alert(new Double(objValue));
        }
        else if (!objValue.isEmpty())
        {
            alert(objValue);
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
