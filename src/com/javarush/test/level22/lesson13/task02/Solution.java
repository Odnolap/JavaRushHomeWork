package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        //if (args.length < 2 || args[0] == null || args[1] == null) return;

        Charset charsetWin = Charset.forName("Windows-1251");
        Charset charsetUTF = Charset.forName("UTF-8");

        int i;

//        FileInputStream fis = new FileInputStream(args[0]);
        FileInputStream fis = new FileInputStream("C:\\Evgeniy\\test\\test2.txt");
//        FileOutputStream fos = new FileOutputStream(args[1]);
        FileOutputStream fos = new FileOutputStream("C:\\Evgeniy\\test\\test.txt");
        byte[] ba = new byte[fis.available()];

        while (fis.available() > 0)
        {
            i = fis.read(ba);
            String s = new String(ba, 0, i, charsetWin);
            System.out.println(s);
            ba = s.getBytes(charsetUTF);
            fos.write(ba);
        }

        fis.close();
        fos.close();
    }
}
