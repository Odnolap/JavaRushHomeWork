package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Odnolap on 25.06.2016.
 */
public class ConsoleHelper
{
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result;

        while (true) {
            try
            {
                result = BUFFERED_READER.readLine();
                break;
            }
            catch (IOException e)
            {
                writeMessage("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return result;
    }

    public static int readInt() {
        int result;

        while (true) {

            try
            {
                String s = readString();
                result = Integer.parseInt(s);
                break;
            }
            catch (NumberFormatException e)
            {
                writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }

        return result;
    }
}
