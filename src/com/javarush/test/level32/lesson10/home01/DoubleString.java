package com.javarush.test.level32.lesson10.home01;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoubleString extends Remote
{
    String MY_STRING = "Текст для тестирования"; // public static final всегда, даже без указания данных модификаторов

    String doubleString(String str) throws RemoteException;
}

