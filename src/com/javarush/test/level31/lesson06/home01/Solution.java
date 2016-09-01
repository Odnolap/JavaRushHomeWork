package com.javarush.test.level31.lesson06.home01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String sourceFileName = args[0];
//        String sourceFileName = "D:/c.txt";
        String zipFileName = args[1];
//        String zipFileName = "D:/tst/test.zip";
        Path sourcePath = Paths.get(sourceFileName);
        String sourceFileShortName = sourcePath.getFileName().toString();
        Path zipFilePath = Paths.get(zipFileName);

        FileInputStream fisSourceFile = new FileInputStream(sourceFileName);
        byte[] sourceFileByteArray = new byte[fisSourceFile.available()];
        fisSourceFile.read(sourceFileByteArray);
        fisSourceFile.close();

        Map<ZipEntry, byte[]> entryMap = new HashMap<>();

        boolean isSourceFileFounded = false;

        if (Files.exists(zipFilePath)) {
            try (FileInputStream fis = new FileInputStream(zipFileName);
                 ZipInputStream zipInputStream = new ZipInputStream(fis, Charset.defaultCharset())) {

                ZipEntry ze;

                while ((ze = zipInputStream.getNextEntry()) != null) {
//                    System.out.println(ze.getName());
//                    System.out.println(ze.getSize());
                    if (ze.isDirectory()) {
                        entryMap.put(ze, null);
                    } else if (!sourceFileShortName.equals(ze.getName())){
                        byte[] ba = new byte[(int)ze.getSize()];
                        zipInputStream.read(ba);
                        entryMap.put(ze, ba);
                    } else {
                        entryMap.put(new ZipEntry("new/" + sourceFileShortName), sourceFileByteArray);
                        isSourceFileFounded = true;
                    }
                    zipInputStream.closeEntry();
                }
            }
        }
/*

        if (!isSourceFileFounded) {
//            entryMap.put(new ZipEntry("new/"), null);
            ZipEntry ze = new ZipEntry("new/" + sourceFileShortName);
            ze.setSize(sourceFileByteArray.length);
            entryMap.put(ze, sourceFileByteArray);
        }
*/

        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fos, Charset.defaultCharset())) {

            for (Map.Entry<ZipEntry, byte[]> pair : entryMap.entrySet()) {
                ZipEntry ze = pair.getKey();
//                System.out.println(ze.getName());
                zipOutputStream.putNextEntry(ze);
                if (!ze.isDirectory()){
                    zipOutputStream.write(pair.getValue());
                }
                zipOutputStream.closeEntry();
            }
        }
    }
}
