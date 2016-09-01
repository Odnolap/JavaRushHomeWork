package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        //Написать тут ваш код
        result.add(new Cat("Петька", 4));
        result.add(new Cat("Васька", 7));
        result.add(new Cat("Барсик", 2));
        result.add(new Cat("Мурка", 5));

        return result;
    }

    public static Set<Dog> createDogs()
    {
        //Написать тут ваш код
        HashSet<Dog> result = new HashSet<Dog>();

        result.add(new Dog("Шарик", 9));
        result.add(new Dog("Барбос", 11));
        result.add(new Dog("Джеки", 8));

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //Написать тут ваш код
        Set<Object> result = new HashSet<Object>();

        result.addAll(cats);
        result.addAll(dogs);

        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        //Написать тут ваш код
        for (Cat c : cats)
        {
            if (pets.contains(c))
            {
                pets.remove(c);
            }
        }
    }

    public static void printPets(Set<Object> pets)
    {
        //Написать тут ваш код
        for (Object o : pets)
        {
            System.out.println(o);
        }
    }

    //Написать тут ваш код
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

    public static class Dog
    {
        String name;
        int age;
        int weight;

        public Dog(String name, int age, int weight)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public Dog(String name, int age)
        {
            this(name, age, 10);
        }

        public Dog()
        {
            this("Безымянный", 1);
        }

    }
}
