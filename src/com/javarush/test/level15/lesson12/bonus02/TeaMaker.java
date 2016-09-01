package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Odnolap on 22.03.2015.
 */
public class TeaMaker extends DrinkMaker
{
    void getRightCup() // выбрать подходящую чашку
    {
        System.out.println("Берем чашку для чая");
    }
    void putIngredient() // положить ингредиенты
    {
        System.out.println("Насыпаем чай");
    }
    void pour() // залить жидкостью
    {
        System.out.println("Заливаем водой");
    }
}
