package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //Написать тут ваш код. step 3 - пункт 3
        Set<Cat> catsCopy = new HashSet<Cat>(cats);
        for (Cat c : catsCopy)
        {
            if ((c.name != null) && (c.name.equals("Петька")))
                cats.remove(c);
        }

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //Написать тут ваш код. step 2 - пункт 2
        Set<Cat> resultSet = new HashSet<Cat>();
        resultSet.add(new Cat());
        resultSet.add(new Cat("Петька", 4));
        resultSet.add(new Cat("Васька", 6));
        return (Set<Cat>)resultSet;
    }

    public static void printCats(Set<Cat> cats)
    {
        // step 4 - пункт 4
        for (Cat c : cats)
        {
            //System.out.println(c.name + ", " + c.age + " лет");
            System.out.println(c);
        }
    }

    // step 1 - пункт 1
    public static class Cat
    {
        String name;
        int age;

        public Cat(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Cat()
        {
            this("Безымянный", 1);
        }

    }
}
