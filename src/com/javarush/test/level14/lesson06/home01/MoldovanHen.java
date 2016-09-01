package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Odnolap on 19.03.2015.
 */
public class MoldovanHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 13;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - Moldova. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
