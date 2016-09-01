package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> resultMap = new HashMap<String, String>();
        for (int i = 0; i < 10; i++)
        {
            resultMap.put("Иванов" + i, "Петя" + (11-i));
        }

        return resultMap;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        if (map.containsValue(name))
        {
            int i = 0;
            for (Map.Entry<String, String> pair : map.entrySet())
            {
                if ((name != null) && (name.equals(pair.getValue())))
                {
                    i++;
                }
            }

            return i;

        }
        else return 0;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        if (map.containsKey(familiya)) return 1;
        else return 0;
    }
}
