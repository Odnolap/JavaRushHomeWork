package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //Напишите тут ваш код
        Map<String, Cat> result = new HashMap<String, Cat>();
        result.put("Васька", new Cat("Васька"));
        result.put("Барсик", new Cat("Барсик"));
        result.put("Мурка", new Cat("Мурка"));
        result.put("Пушок", new Cat("Пушок"));
        result.put("Матильда", new Cat("Матильда"));
        result.put("Петька", new Cat("Петька"));
        result.put("Рыжик", new Cat("Рыжик"));
        result.put("Уголек", new Cat("Уголек"));
        result.put("Пионер", new Cat("Пионер"));
        result.put("Изя", new Cat("Изя"));

        return result;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //Напишите тут ваш код
        Set<Cat> result = new HashSet<Cat>();
        result.addAll(map.values());

        return result;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
