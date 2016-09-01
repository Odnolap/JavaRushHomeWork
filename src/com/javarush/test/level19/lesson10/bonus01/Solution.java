package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        BufferedReader f1 = new BufferedReader(new FileReader(file1));
        BufferedReader f2 = new BufferedReader(new FileReader(file2));

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        while (f1.ready())
        {
            l1.add(f1.readLine());
        }
        f1.close();

        while (f2.ready())
        {
            l2.add(f2.readLine());
        }
        f2.close();

        //Исходный файл пуст
        if (l1.size() == 0)
        {
            for (String s : l2)
            {
                lines.add(new LineItem(Type.ADDED, s));
            }
        }

        //Новая версия файла пуста
        if (l2.size() == 0)
        {
            for (String s : l1)
            {
                lines.add(new LineItem(Type.REMOVED, s));
            }
        }

        int lastCheckedStrFromFile2Num = -1;
        for (String curStrF1 : l1)
        {
            boolean goToNextLineF1 = false;
            int curStrF2Num = lastCheckedStrFromFile2Num + 1;
            while (!goToNextLineF1 && (curStrF2Num < l2.size()))
            {
                if (curStrF1.equals(l2.get(curStrF2Num)))
                {
                    for (int i = lastCheckedStrFromFile2Num + 1; i < curStrF2Num; i++) // Новые строки из файла 2 (от последней проверенной до текущей), вставленные перед текущей строкой из файла 1
                    {
                        lines.add(new LineItem(Type.ADDED, l2.get(i)));
                    }
                    lines.add(new LineItem(Type.SAME, curStrF1));
                    lastCheckedStrFromFile2Num = curStrF2Num;
                    goToNextLineF1 = true;
                }
                else
                {
                    curStrF2Num++;
                }
            }

            if (!goToNextLineF1) // Перебрав все строки в файле 2 с последней проверенной не нашли совпадение, значит текущая строка из файла 1 была удалена
            {
                lines.add(new LineItem(Type.REMOVED, curStrF1));
            }
        }

        if (lastCheckedStrFromFile2Num < l2.size() - 1)
        {
            for (int i = lastCheckedStrFromFile2Num + 1; i < l2.size(); i++)
            {
                lines.add(new LineItem(Type.ADDED, l2.get(i)));
            }
        }

        for (LineItem li : lines)
        {
            System.out.println(li.line + "_" + li.type);
        }

        reader.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
