package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Odnolap on 19.03.2015.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 14;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - Ukraine. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
