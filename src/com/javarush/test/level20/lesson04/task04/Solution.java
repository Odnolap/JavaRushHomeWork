package com.javarush.test.level20.lesson04.task04;

import java.io.*;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ClassWithStatic c1 = new ClassWithStatic();
        c1.i = 2;
        c1.j = 3;
        FileOutputStream fos = new FileOutputStream("C:\\Evgeniy\\test\\test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c1);
        fos.close();
        oos.close();
        FileInputStream fis = new FileInputStream("C:\\Evgeniy\\test\\test.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ClassWithStatic c2 = new ClassWithStatic();
        c2.i = 5;
        c2.j = 6;
        ClassWithStatic.staticString = "Changed String";
        System.out.println(c2.i);
        System.out.println(c2.j);
        System.out.println(ClassWithStatic.staticString);
        c2 = (ClassWithStatic)ois.readObject();
        System.out.println(c2.i);
        System.out.println(c2.j);
        System.out.println(ClassWithStatic.staticString);
        fis.close();
        ois.close();

    }
}
