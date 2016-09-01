package com.javarush.test.level20.lesson10.home01;

import java.io.*;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/
public class Solution implements Serializable{

    public class A implements Serializable{
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution s = new Solution();
        s.tst();
    }

    public void tst() throws IOException, ClassNotFoundException
    {
        C c1 = new C("TestName");
        System.out.println(c1.name);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(c1);

        baos.close();
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        C c2 = (C)ois.readObject();

        bais.close();
        ois.close();

        System.out.println(c2.name);
    }


}
