package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        List<String> fileStrings = new ArrayList<String>();
        String curLine;
        String curID;

        BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
        while (fileIn.ready())
        {
            curLine = fileIn.readLine();
            if (curLine.length() > 0)
            {
                curID = curLine.substring(0, 8).trim();

                if (("-d".equals(args[0])) && (curID.equals(args[1].trim())))
                {

                }
                else if (("-u".equals(args[0])) && (curID.equals(args[1].trim())))
                {
                    curLine = curLine.substring(0, 8) +
                            String.format("%-30s", args[2]) +
                            String.format("%-8s", args[3]) +
                            String.format("%-4s", args[4]);
                    fileStrings.add(curLine);
                }
                else
                {
                    fileStrings.add(curLine);
                }
            }
            else
            {
                fileStrings.add(curLine);
            }
        }

        fileIn.close();

        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName));
        for (String s : fileStrings)
        {
            fileOut.write(s);
            fileOut.write("\r\n");
        }

        fileOut.close();



    }
}
