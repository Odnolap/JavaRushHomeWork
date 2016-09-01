package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Odnolap on 22.03.2015.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup(); // выбрать подходящую чашку
    abstract void putIngredient(); // положить ингредиенты
    abstract void pour(); // залить жидкостью

    void makeDrink()
    {
        getRightCup();
        putIngredient();
        pour();
    }
}
