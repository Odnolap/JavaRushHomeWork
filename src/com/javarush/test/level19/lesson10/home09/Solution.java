package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        String advText = "JavaRush - курсы Java онлайн";

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        int eolnPos0 = 0;
        int eolnPos1;
        int eolnPos2;
        String s = outputStream.toString();
        StringBuilder result = new StringBuilder();
        System.setOut(consoleStream);

        while (true)
        {
            if ((eolnPos1 = s.indexOf("\n", eolnPos0)) == -1) // Нечетное (1, 3 и т.д.) окончание строки (строки заканчиваются на "\r\n")
            {
                result.append(s.substring(eolnPos0));
                break;
            }
            if (eolnPos1 == s.length() - 1) // Если вхождение было последним
            {
                result.append(s.substring(eolnPos0));
                break;
            }
            if ((eolnPos2 = s.indexOf("\n", eolnPos1 + 1)) == -1)
            {
                result.append(s.substring(eolnPos0));
                break;
            }
            result.append(s.substring(eolnPos0, eolnPos2 + 1)).append(advText).append("\r").append("\n");
            if (eolnPos2 == s.length() - 1)
            {
                break;
            }
            eolnPos0 = eolnPos2 + 1;
        }

        System.out.println(result.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
