package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
/*        String[] args2 = new String[4];
        args2[0] = "D:/tst/E.txt";
        args2[1] = "D:/tst/d.zip.001";
        args2[2] = "D:/tst/d.zip.003";
        args2[3] = "D:/tst/d.zip.002";*/
        ByteArrayOutputStream zipBAOS = new ByteArrayOutputStream();
        List<String> strings = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            strings.add(args[i]);
        }
        Collections.sort(strings);
        byte[] ba = new byte[8192];
        int count;
        for (String s : strings) {
            FileInputStream fis = new FileInputStream(s);
            while ((count = fis.read(ba)) > 0) {
                zipBAOS.write(ba, 0, count);
                zipBAOS.flush();
            }
            fis.close();
        }
        zipBAOS.close();

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zipBAOS.toByteArray());
             ZipInputStream zipIS = new ZipInputStream(byteArrayInputStream, Charset.defaultCharset());
             FileOutputStream fos = new FileOutputStream(args[0])) {

            ZipEntry ze;
            while ((ze = zipIS.getNextEntry()) != null) {
                while ((count = zipIS.read(ba)) > 0) {
                    fos.write(ba, 0, count);
                    fos.flush();
                }
                zipIS.closeEntry();
            }
        }
    }
}
