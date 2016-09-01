package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Odnolap on 09.12.2015.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        boolean isOk = false;
        int expectedAmount = 0;

        ConsoleHelper.writeMessage(res.getString("specify.amount"));

        while (!isOk)
        {
            String s = ConsoleHelper.readString();
            ConsoleHelper.writeMessage(res.getString("before"));
            if (s == null || !s.matches("\\d+") || Integer.parseInt(s) <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
            else if (!currencyManipulator.isAmountAvailable(Integer.parseInt(s)))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            else
            {
                try
                {
                    expectedAmount = Integer.parseInt(s);
                    Map<Integer, Integer> cash = currencyManipulator.withdrawAmount(expectedAmount);
                    Integer[] cashNominals = cash.keySet().toArray(new Integer[1]);
                    Arrays.sort(cashNominals, Collections.reverseOrder());
                    for (Integer i : cashNominals)
                    {
                        ConsoleHelper.writeMessage("\t" + i + " - " + cash.get(i));
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(s), currencyCode));

                    isOk = true;
                }
                catch (NotEnoughMoneyException e)
                {
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                }
            }
        }


    }
}
