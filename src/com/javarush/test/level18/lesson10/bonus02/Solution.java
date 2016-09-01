package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        args = new String[4];
        args[0] = "-c";
        args[1] = "Куртка для сноубордистов, размер 535 и 567";
        args[2] = "10173.99";
        args[3] = "34";

        if ((args.length > 3) && ("-c".equals(args[0])))
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
            String fileLine;
            int maxID = 0;
            int curID;

            while (fileIn.ready())
            {
                fileLine = fileIn.readLine();
                if (fileLine.length() > 0)
                {
                    curID = Integer.parseInt(fileLine.substring(0, 8).trim());
                    if (curID > maxID)
                    {
                        maxID = curID;
                    }
                }
            }

            fileIn.close();

            String strID = String.valueOf(++maxID);
            if (strID.length() > 8) strID = strID.substring(0, 8);
            String goodsName = args[1];
            if (goodsName.length() > 30) goodsName = goodsName.substring(0, 30);
            String goodsPrice = args[2];
            if (goodsPrice.length() > 8) goodsPrice = goodsPrice.substring(0, 8);
            String goodsCount = args[3];
            if (goodsCount.length() > 4) goodsCount = goodsCount.substring(0, 4);

            String resultLine = String.format("%-8s", strID) +
                    String.format("%-30s",goodsName) +
                    String.format("%-8s", goodsPrice) +
                    String.format("%-4s", goodsCount);

            FileOutputStream fOut = new FileOutputStream(fileName, true);
            if (maxID != 1)
            {
                fOut.write("\r\n".getBytes());
            }
            fOut.write(resultLine.getBytes());
            fOut.close();
        }

    }
}
