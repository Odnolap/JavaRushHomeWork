package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Сталлоне", "Сильвестр");
        map.put("Петров", "Эдуард");
        map.put("Иванов", "Павел");
        map.put("Сидоров", "Павел");
        map.put("Баланда", "Евгений");
        map.put("Капков", "Яков");
        map.put("Хайруллин", "Радик");
        map.put("Шеварнадзе", "Эдуард");
        map.put("Ельцин", "Борис");
        map.put("Чехов", "Антон");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        HashMap<String, String> controlMap = new HashMap<String, String>();
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (controlMap.containsValue(pair.getValue()))
                removeItemFromMapByValue(map, pair.getValue());
            controlMap.put(pair.getKey(), pair.getValue());
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args)
    {
        HashMap<String, String> myMap = createMap();
        removeTheFirstNameDuplicates(myMap);
        for (Map.Entry<String, String> pair: myMap.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
