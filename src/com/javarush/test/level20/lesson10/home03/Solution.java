package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable{
    private static final long serialVersionUID = 2L;

    public static class A {
        transient protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A(){}

    }

    public class B extends A implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name2;
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            name2 = name;
            out.defaultWriteObject();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = name2;
        }

    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        s.tst();
    }

    public void tst()
    {

    }
}
