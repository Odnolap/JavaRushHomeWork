package com.odnolap.test;

import java.util.*;

/**
 * Created by Odnolap on 11.03.2015.
 */
public class Test3
{
    public static void main(String[] args) throws InterruptedException
    {
        //Напишите тут ваш код
        //Set<String> set = new HashSet<String>();
        /*
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("жень-шень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");
        */
        /*
        Collections.addAll(set, "арбуз", "банан", "вишня", "груша", "дыня", "ежевика", "жень-шень", "земляника", "ирис", "картофель");

        for (String s : set) {
            System.out.println(s);
        }

        //Напишите тут ваш код

        Map<String, String> map = new HashMap<String, String>();
        */
        /*
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");
        */

        /*
        Collections.addAll(map, "арбуз", "ягода", "банан", "трава");


        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
        */

        /*
        Date currentTime = new Date();
        Thread.sleep(3000);
        Date newTime = new Date();

        long msDelay = newTime.getTime() - currentTime.getTime();
        System.out.println("Time distance is: " + msDelay + " in ms");

        System.out.println(newTime);
        System.out.println(newTime.getTime());

        */
/*
        String str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(str.length());
        str = str.substring(5,10);
        System.out.println(str);
        System.out.println(str.length());

        System.out.println("------");
        String str1 = "string";
        String str2 = "string";
        System.out.println(str1==str2 ? "the same" : "not the same");

        System.out.println("------");
        float f1 = 0.3f;
        float f2 = 0.4f;
        float f3 = f1 + f2;
        float f4 = 0.7f;
        System.out.println("f1="+(double)f1);
        System.out.println("f2="+(double)f2);
        System.out.println("f3="+(double)f3);
        System.out.println("f4="+(double)f4);
        System.out.println("f1="+f1);
        System.out.println("f2="+f2);
        System.out.println("f3="+f3);
        System.out.println("f4="+f4);
        System.out.println("|f3-f4|<1e-6: "+( Math.abs(f3-f4) < 1e-6 ));
        System.out.println(Math.abs(f3-f4));
        System.out.println(1e-6);
        System.out.println(100e-3);
*/
/*
        System.out.println("----");

        Date startTime = new Date();

        long endTime = startTime.getTime() + 5000;
        Date endDate = new Date(endTime);

        Thread.sleep(6000);

        Date currentTime = new Date();
        if (currentTime.after(endDate))
        {
            System.out.println("End time!");
        }
        else System.out.println("no!");
*/

        Date currentTime = new Date();
        int hours = currentTime.getHours();
        int mins = currentTime.getMinutes();
        int secs = currentTime.getSeconds();

        System.out.println("Time from midnight " + hours + ":" + mins + ":" + secs);

        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);

        Date currentTime2 = new Date();
        long msTimeDistance = currentTime2.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;

        int dayCount = (int) (msTimeDistance/msDay);
        System.out.println("Days from start of year: " + dayCount);

        System.out.println(yearStartTime);

        int numbers[] = new int[]{-129,-128,127,128};

        for (int number : numbers) {
            Integer i1 = number;
            Integer i2 = number;
            int ii1 = number;
            int ii2 = number;
            System.out.println("number=" + number + ": " + (i1 == i2));
            System.out.println("number=" + number + ": " + (ii1 == ii2));
        }



    }
}
