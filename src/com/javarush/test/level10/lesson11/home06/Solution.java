package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        Human mother;
        Human father;
        ArrayList<Human> children;

        public Human()
        {
            name = "Anonimous";
            sex = false;
            age = 0;
            //mother = new Human();
            //father = new Human();
            children = new ArrayList<Human>();
        }

        public Human(String name)
        {
            this(name, false, 0, new Human(), new Human(), new ArrayList<Human>());
        }

        public Human(boolean sex)
        {
            this.sex = sex;
            if (sex)
            {
                name = "Unknown man";
            }
            else
            {
                name = "Unknown woman";
            }
            age = 0;
            mother = new Human();
            father = new Human();
            children = new ArrayList<Human>();
        }

        public Human(String name, boolean sex)
        {
            this(name, sex, 0);
        }
        // 5
        public Human(boolean sex, int age)
        {
            this.sex = sex;
            if (sex)
            {
                name = "Unknown man";
            }
            else
            {
                name = "Unknown woman";
            }
            this.age = age;
        }

        public Human(String name, int age)
        {
            this(name, false, age);
        }

        public Human(String name, boolean sex, int age)
        {
            this(name, sex, age, new Human(), new Human(), new ArrayList<Human>());
        }
        // 8
        public Human(String name, boolean sex, int age, Human mother, Human father, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.mother = mother;
            this.father = father;
            this.children = children;
        }

        public Human(String name, boolean sex, int age, Human mother, Human father)
        {
            this(name, sex, age, mother, father, new ArrayList<Human>());
        }

        public Human(String name, boolean sex, Human mother, Human father)
        {
            this(name, sex, 0, mother, father, new ArrayList<Human>());
        }
    }
}
