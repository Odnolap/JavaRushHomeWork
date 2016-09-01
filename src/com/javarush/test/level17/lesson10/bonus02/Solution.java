package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String name;
        Date bd = null;

        if ("-c".equals(args[0]))
        {
            for (int i = 1; i < args.length; i = i + 3)
            {
                name = args[i];

                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                try
                {
                    bd = sd.parse(args[i + 2]);
                }
                catch (ParseException e) {}

                if ("м".equals(args[i + 1]))
                {
                    allPeople.add(Person.createMale(name, bd));
                }
                else if ("ж".equals(args[i + 1]))
                {
                    allPeople.add(Person.createFemale(name, bd));
                }

                System.out.println(allPeople.size() - 1);
            }
        }
        else if ("-u".equals(args[0]))
        {
            for (int i = 1; i < args.length; i = i + 4)
            {
                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Person p = allPeople.get(Integer.parseInt(args[i]));
                p.setName(args[i + 1]);
                try
                {
                    bd = sd.parse(args[i + 3]);
                }
                catch (ParseException e) {}
                p.setBirthDay(bd);

                if ("м".equals(args[i + 2]))
                {
                    p.setSex(Sex.MALE);
                }
                else if ("ж".equals(args[i + 2]))
                {
                    p.setSex(Sex.FEMALE);
                }
            }

        }
        else if ("-d".equals(args[0]))
        {
            for (int i = 1; i < args.length; i++)
            {
                Person p = allPeople.get(Integer.parseInt(args[i]));
                p.setBirthDay(null);
                p.setName(null);
                p.setSex(null);
            }
        }
        else if ("-i".equals(args[0]))
        {
            for (int i = 1; i < args.length; i++)
            {
                SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Person p = allPeople.get(Integer.parseInt(args[i]));
                switch (p.getSex())
                {
                    case FEMALE:
                        System.out.println(p.getName() + " ж " + sd.format(p.getBirthDay())); break;
                    case MALE:
                        System.out.println(p.getName() + " м " + sd.format(p.getBirthDay())); break;
                }
            }

        }
    }
}
