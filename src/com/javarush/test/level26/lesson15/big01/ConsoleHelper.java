package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Odnolap on 04.10.2015.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String s = null;
        try
        {
            s = reader.readLine();
        }
        catch (IOException ignored) {}

        if (s != null && s.toUpperCase().contains("EXIT"))
            throw new InterruptOperationException();

        return s;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String currencyCode = null;
        writeMessage(res.getString("choose.currency.code"));

        while (currencyCode == null || currencyCode.length() != 3)
        {
            currencyCode = readString();
            if (currencyCode == null || currencyCode.length() != 3)
                writeMessage(res.getString("invalid.data"));
        }

        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode, String error_message) throws InterruptOperationException
    {
        String[] result = new String[2];
        boolean isOk = false;

        writeMessage(res.getString(String.format("choose.denomination.and.count.format", currencyCode)));

        while (!isOk)
        {
            String s = readString();
            if (s != null && s.matches("\\d+ \\d+"))
            {
                isOk = true;
                result = s.split(" ");
            }
            else
            {
                writeMessage(error_message);
            }
        }

        return result;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        writeMessage("1 - " + res.getString("operation.INFO"));
        writeMessage("2 - " + res.getString("operation.DEPOSIT"));
        writeMessage("3 - " + res.getString("operation.WITHDRAW"));
        writeMessage("4 - " + res.getString("operation.EXIT"));
        String s = readString();
        while (!s.matches("[1-4]"))
        {
            writeMessage(res.getString("invalid.data"));
            s = readString();
        }

        return Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
