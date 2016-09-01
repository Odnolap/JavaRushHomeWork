package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Odnolap on 09.12.2015.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        int cnt = 0;
        for (Object o : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            CurrencyManipulator currencyManipulator = (CurrencyManipulator)o;
            if (currencyManipulator.hasMoney())
            {
                ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " + String.valueOf(currencyManipulator.getTotalAmount()));
                cnt++;
            }
        }

        if (cnt == 0)
            ConsoleHelper.writeMessage(res.getString("no.money"));

    }
}
