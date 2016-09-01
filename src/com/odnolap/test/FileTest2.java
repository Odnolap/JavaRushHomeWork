package com.odnolap.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;

/**
 * Created by Odnolap on 04.07.2016.
 */
public class FileTest2
{
    public static void main(String[] args) throws IOException
    {


        System.out.println("test rename File");
        File fileA = new File("D:/a.txt");
        File fileB = new File("D:/b.txt");
//        fileA.createNewFile();
//        fileB.createNewFile();
        File fileC = new File("D:/c.txt");
        File aDir = fileA.getParentFile();
        System.out.println(fileA.getAbsolutePath());
        System.out.println(fileA);
        System.out.println(aDir);
        File fileD = new File(aDir + "d.txt");
        fileD.createNewFile();
        fileA.renameTo(fileC);
        fileA.createNewFile();
        System.out.println("Files in D:/");
        for(File f : aDir.listFiles()) {
            System.out.println(f);
        }

        File f = new File("D:\\Evgeniy\\test\\Test Folder 2");
        boolean success = f.mkdirs();
        System.out.println(f.getParent());
        System.out.println(f.getParentFile());

        Path path = f.toPath();
        System.out.println(path.toString());
        System.out.println(path.isAbsolute());
        System.out.println(path.getFileName());
        System.out.println(path.getFileSystem());
        System.out.println(path.relativize(f.getParentFile().toPath()));
        System.out.println(f.getParentFile().toPath().relativize(path));
        System.out.println(path.toUri());
        System.out.println(f.getParentFile().toPath().relativize(path).toAbsolutePath());

        System.out.println("-----------");
        System.out.println(f);
        System.out.println(f.isDirectory());
        System.out.println(f.canWrite());
        System.out.println(f.isHidden());
        Path p = Paths.get(f.toPath() + "/t.txt");
        System.out.println(p.getParent());
        System.out.println(p.getFileName());
        System.out.println(p);
        Files.delete(p);
        Files.createFile(p);

        File f2 = new File("D:/Evgeniy/test");
        System.out.println(Arrays.toString(f2.list()));
        System.out.println(Arrays.toString(f2.listFiles()));
        Path p2 = Paths.get("D:/Evgeniy/test");
        Files.getFileStore(p2);
        Path p3 = Paths.get("");
        System.out.println(p2);
        System.out.println("resolve paths: '" + p2 + "' to '" + p3 + "' = " + p2.resolve(p3));
        p3 = Paths.get("x.txt");
        System.out.println("resolve paths: '" + p2 + "' to '" + p3 + "' = " + p2.resolve(p3));
        p3 = Paths.get("/x.txt");
        System.out.println("resolve paths: '" + p2 + "' to '" + p3 + "' = " + p2.resolve(p3));
        p3 = Paths.get("fld/x.txt");
        System.out.println("resolve paths: '" + p2 + "' to '" + p3 + "' = " + p2.resolve(p3));
        p3 = Paths.get("/fld/x.txt");
        System.out.println("resolve paths: '" + p2 + "' to '" + p3 + "' = " + p2.resolve(p3));

        Path p4 = Paths.get("D:/1/2/3");
        // Файл создается только если есть директория (Files.createFile)
        // 1 директория (Files.createDirectory) создается, только если есть родительская директория
        // Если нет родительской директории (или даже больше 1 родительских уровней), то надо использовать Files.createDirectories
        Files.createDirectories(p4);

    }
}
