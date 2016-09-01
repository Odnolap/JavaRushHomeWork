package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        InputStream f = new FileInputStream(s);
        int i;
        while (f.available() > 0)
        {
            i = f.read();
            //Character c2 = Character.
            System.out.print((char)i);
            //Character c = new Character()
        }

        f.close();

    }
}
