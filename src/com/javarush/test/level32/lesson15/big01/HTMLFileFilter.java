package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Odnolap on 17.07.2016.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String fileNameInLowerCase = f.getName().toLowerCase();
        return f.isDirectory()
                || fileNameInLowerCase.endsWith(".html")
                || fileNameInLowerCase.endsWith(".htm");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
