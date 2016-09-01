package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        ArrayList<Human> emtyChildrenList = new ArrayList<Human>();
        Human ch1 = new Human("Сын 1", true, 12, emtyChildrenList);
        Human ch2 = new Human("Дочь 2", false, 8, emtyChildrenList);
        Human ch3 = new Human("Сын 3", true, 4, emtyChildrenList);
        ArrayList<Human> children1 = new ArrayList<Human>();
        Collections.addAll(children1, ch1, ch2, ch3);
        Human ft = new Human("Папа", true, 35, children1);
        Human mt = new Human("Мама", false, 33, children1);
        ArrayList<Human> children2 = new ArrayList<Human>();
        Collections.addAll(children2, ft);
        ArrayList<Human> children3 = new ArrayList<Human>();
        Collections.addAll(children3, mt);
        Human gp1 = new Human("Дед 1", true, 78, children2);
        Human gp2 = new Human("Дед 2", true, 69, children3);
        Human gm1 = new Human("Бабушка 1", false, 75, children2);
        Human gm2 = new Human("Бабушка 2", false, 68, children3);

        System.out.println(gp1.toString());
        System.out.println(gp2.toString());
        System.out.println(gm1.toString());
        System.out.println(gm2.toString());
        System.out.println(ft.toString());
        System.out.println(mt.toString());
        System.out.println(ch1.toString());
        System.out.println(ch2.toString());
        System.out.println(ch3.toString());
    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human (String name, boolean sex, int age, ArrayList<Human> children)
        {
            super();
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
