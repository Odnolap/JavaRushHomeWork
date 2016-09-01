package com.odnolap.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Odnolap on 08.07.2016.
 */
public class ZipTest
{
    public static void main(String[] args) throws IOException
    {
        Path path = Paths.get("d:/archive.zip");
        System.out.println(Files.exists(path));

        // создаем архив
        FileOutputStream zipFile = new FileOutputStream("d:/archive.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile, Charset.defaultCharset());

        //кладем в него ZipEntry – «архивный объект» - заготовка архивного файла
        zip.putNextEntry(new ZipEntry("document.txt"));

        //копируем файл «document-for-archive.txt» в архив под именем «document.txt» - последний ZipEntry
        File file = new File("d:/document-for-archive.txt");
        Files.copy(file.toPath(), zip);

        //кладем в архив еще 1 ZipEntry, иначе следующий файл положится в тот же ZipEntry - байты просто добавятся к тому, что есть
        zip.putNextEntry(new ZipEntry("document 2.txt"));

        //копируем файл «document-for-archive 333.txt» в архив под именем «document 2.txt» - последний ZipEntry
        File file2 = new File("d:/document-for-archive 333.txt");
        Files.copy(file2.toPath(), zip);

        // закрываем архив
        zip.close();
    }
}
