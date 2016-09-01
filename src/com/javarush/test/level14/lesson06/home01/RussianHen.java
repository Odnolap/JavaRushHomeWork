package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Odnolap on 19.03.2015.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 15;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - Russia. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
