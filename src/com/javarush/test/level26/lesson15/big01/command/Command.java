package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Odnolap on 09.12.2015.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
