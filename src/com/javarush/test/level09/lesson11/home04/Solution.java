package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        Date d = new Date(s);
        //System.out.println(d);
        SimpleDateFormat sd = new SimpleDateFormat("MMM d, yyyy");
        //System.out.println(sd);
        System.out.println(sd.format(d).toUpperCase());
        System.out.printf("%tB %te, %tY%n", d, d, d);
    }
}
