package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileNameIn = args[0];
        String fileNameOut = args[1];
        BufferedReader fileIn = new BufferedReader(new FileReader(fileNameIn));
        String result = "";
        while (fileIn.ready())
        {
            String line = fileIn.readLine();
            String[] words = line.split(" ");
            for (String s : words)
            {
                if (!s.equals(s.replaceAll("\\d", "")))
                {
                    result += " " + s;
                }
            }
        }

        fileIn.close();

        FileWriter fileOut = new FileWriter(fileNameOut);
        fileOut.write(result.trim());
        fileOut.close();
    }
}
