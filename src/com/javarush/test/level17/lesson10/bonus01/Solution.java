package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
            name = args[1];

            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try
            {
                bd = sd.parse(args[3]);
            }
            catch (ParseException e) {}

            if ("м".equals(args[2]))
            {
                allPeople.add(Person.createMale(name, bd));
            }
            else if ("ж".equals(args[2]))
            {
                allPeople.add(Person.createFemale(name, bd));
            }

            System.out.println(allPeople.size() - 1);
        }
        else if ("-u".equals(args[0]))
        {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Person p = allPeople.get(Integer.parseInt(args[1]));
            p.setName(args[2]);
            try
            {
                bd = sd.parse(args[4]);
            }
            catch (ParseException e) {}
            p.setBirthDay(bd);

            if ("м".equals(args[3]))
            {
                p.setSex(Sex.MALE);
            }
            else if ("ж".equals(args[3]))
            {
                p.setSex(Sex.FEMALE);
            }

        }
        else if ("-d".equals(args[0]))
        {
            Person p = allPeople.get(Integer.parseInt(args[1]));
            p.setBirthDay(null);
            p.setName(null);
            p.setSex(null);
        }
        else if ("-i".equals(args[0]))
        {
            SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person p = allPeople.get(Integer.parseInt(args[1]));
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
