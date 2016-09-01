package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human gp1 = new Human("Дед 1", true, 78, null, null);
        Human gp2 = new Human("Дед 2", true, 69, null, null);
        Human gm1 = new Human("Бабушка 1", false, 75, null, null);
        Human gm2 = new Human("Бабушка 2", false, 68, null, null);
        Human ft = new Human("Папа", true, 35, gp1, gm1);
        Human mt = new Human("Мама", false, 33, gp2, gm2);
        Human ch1 = new Human("Сын 1", true, 12, ft, mt);
        Human ch2 = new Human("Дочь 2", false, 8, ft, mt);
        Human ch3 = new Human("Сын 3", true, 4, ft, mt);

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
        Human father;
        Human mother;

        public Human (String name_, boolean sex_, int age_, Human father_,  Human mother_) {
            super();
            name = name_;
            sex = sex_;
            age = age_;
            father = father_;
            mother = mother_;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
