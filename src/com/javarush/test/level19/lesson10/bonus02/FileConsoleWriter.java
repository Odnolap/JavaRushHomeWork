package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;
import java.util.Arrays;

public class FileConsoleWriter extends FileWriter
{
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        super.write(cbuf);
        System.out.println(cbuf);
    }

    @Override
    public void write(String str) throws IOException
    {
        super.write(str);
        System.out.println(str);
    }

    @Override
    public void write(int c) throws IOException
    {
        super.write(c);
        System.out.println(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);
        System.out.println(Arrays.copyOfRange(cbuf, off, off + len));
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        super.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    @Override
    public Writer append(CharSequence csq) throws IOException
    {
        if (csq == null)
            System.out.println("null");
        else
            System.out.println(csq.toString());
        return super.append(csq);
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException
    {
        CharSequence cs = (csq == null ? "null" : csq);
        System.out.println(cs.subSequence(start, end).toString());
        return super.append(csq, start, end);
    }

    @Override
    public Writer append(char c) throws IOException
    {
        System.out.println(c);
        return super.append(c);
    }
}
