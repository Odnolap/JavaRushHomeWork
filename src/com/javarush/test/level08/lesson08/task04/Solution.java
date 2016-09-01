package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));

        //Напишите тут ваш код
        Date startDate = new Date("JUNE 1 1980");
        Date d2;
        for (int i = 1; i < 10; i++)
        {
            d2 = new Date(startDate.getTime() + (i * 1000L * 60 * 60 * 24 * 31));
            //System.out.println(d2 + " - " + i + " - " + (i * 1000L * 60 * 60 * 24 * 31));
            map.put("Сталлоне_" + i, d2);
        }

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        ArrayList<Integer> badMonts = new ArrayList<Integer>();
        Collections.addAll(badMonts, 5, 6, 7);
        HashMap<String, Date> cloneMap = (HashMap<String, Date>)map.clone();
        for (Map.Entry<String, Date> pair : cloneMap.entrySet())
        {
            int i = pair.getValue().getMonth();
            // System.out.println(pair.getKey() + " - " + pair.getValue());
            if (badMonts.contains(i))
            {
                map.remove(pair.getKey());
                // System.out.println("delete");
            }
        }


    }

    public static void main(String[] args)
    {
        HashMap<String, Date> myMap = createMap();
        removeAllSummerPeople(myMap);

        System.out.println("Итог");
        for (Map.Entry<String, Date> pair : myMap.entrySet())
        {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
