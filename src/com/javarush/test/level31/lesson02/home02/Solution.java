package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> resultList = new ArrayList<>();
        List<File> dirs = new ArrayList<>();
        dirs.add(new File(root));

        while (!dirs.isEmpty()) {
            File currentDir = dirs.remove(0);
            for (File f : currentDir.listFiles()) {
                if (f.isDirectory()) {
                    dirs.add(f);
                } else {
                    resultList.add(f.getAbsolutePath());
                }
            }
        }

        return resultList;

    }
}
