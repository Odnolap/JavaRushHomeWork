package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        File path = new File(args[0]);
//        File path = new File("D:\\Evgenij\\test");
        File resultFileAbsolutePath = new File(args[1]);
//        File resultFileAbsolutePath = new File("D:\\Evgenij\\resFile.txt");
        List<File> queue = new LinkedList<>();
        List<File> resultQueue = new LinkedList<>();
        List<File> dirList = new LinkedList<>();

        queue.add(path);
//        dirList.add(path);
        while (!queue.isEmpty()) {
            File currentDir = queue.remove(0);
            for (File f : currentDir.listFiles()) {
                if (f.isDirectory()) {
                    queue.add(f);
                    dirList.add(f);
                } else {
                    if (f.length() > 50 && !f.equals(resultFileAbsolutePath)) {
                        f.delete();
                    } else if (!f.equals(resultFileAbsolutePath)) {
                        resultQueue.add(f);
                    }
                }
            }
        }

        Collections.sort(resultQueue, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });

        File finalResultFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        resultFileAbsolutePath.renameTo(finalResultFile);
        FileOutputStream fos = new FileOutputStream(finalResultFile);
        byte[] ba = new byte[200];
        for (File f : resultQueue) {
            FileInputStream fis = new FileInputStream(f);
            int i = fis.read(ba);
            fos.write(ba, 0, i);
            fos.write("\n".getBytes());
            fis.close();
        }
        fos.close();

        Collections.reverse(dirList);

        for (int j = 0; j < dirList.size(); j++) {
            if (dirList.get(j).list().length == 0) {
                dirList.get(j).delete();
            }
        }
    }

}
