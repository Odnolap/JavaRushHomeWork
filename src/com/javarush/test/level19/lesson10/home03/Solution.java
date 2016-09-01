package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {

//        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        BufferedReader file = new BufferedReader(new FileReader("C:\\Evgeniy\\test\\test.txt"));
        while (file.ready())
        {
            String s = file.readLine();
            String[] words = s.split(" ");
            String dayOfBirth = words[words.length - 3];
            String monthOfBirth = words[words.length - 2];
            String yearOfBirth = words[words.length - 1];
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < words.length - 3; i++)
            {
                name.append(" " + words[i]);
            }
            String nameStr = name.substring(1);
            Date bd = null;
            SimpleDateFormat sd = new SimpleDateFormat("d.M.yyyy");
            try
            {
                bd = sd.parse(dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
            }
            catch (ParseException e) {}
//            System.out.println(dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
//            System.out.println(nameStr + " " + bd);

            PEOPLE.add(new Person(nameStr, bd));
        }

        file.close();
    }

}
