package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Odnolap on 10.12.2015.
 */
class LoginCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    @Override
    public void execute() throws InterruptOperationException
    {
        boolean isOk = false;

        ConsoleHelper.writeMessage(res.getString("specify.data"));

        while (!isOk)
        {
            String s1 = ConsoleHelper.readString();
            String s2 = ConsoleHelper.readString();
            ConsoleHelper.writeMessage(res.getString("before"));
            if (s1 == null || s2 == null || !s1.matches("\\d{12}") || !s2.matches("\\d{4}"))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
            else
            {
                try
                {
                    String key = validCreditCards.getString(s1);
                    if (s2.equals(key))
                    {
                        isOk = true;
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), s1));
                    }
                    else
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), s1));
                }
                catch (MissingResourceException e)
                {
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
            }
        }
    }
}
