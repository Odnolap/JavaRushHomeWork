package com.javarush.test.level20.lesson07.task03;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException
        {
            Person dad = new Person("Имя папы", "YYYФамилия папы", 32);
            Person mom = new Person("Имя мамы", "YYYФамилия мамыы", 29);
            Person son = new Person("Имя сына", "YYYФамилия сына", 1);
            son.setFather(dad);
            son.setMother(mom);
            List<Person> l1 = new ArrayList<>();
            List<Person> l2 = new ArrayList<>();
            l1.add(son);
            l2.add(son);
            dad.setChildren(l1);
            mom.setChildren(l2);

            FileOutputStream fos = new FileOutputStream("C:\\Evgeniy\\test\\test2.txt");
            ObjectOutput oo = new ObjectOutputStream(fos);
            dad.writeExternal(oo);
            mom.writeExternal(oo);
            son.writeExternal(oo);
            fos.close();
            oo.close();

            FileInputStream fis = new FileInputStream("C:\\Evgeniy\\test\\test2.txt");
            ObjectInput oi = new ObjectInputStream(fis);
            Person dad1 = new Person();
            Person mom1 = new Person();
            Person son1 = new Person();
            dad1.readExternal(oi);
            mom1.readExternal(oi);
            son1.readExternal(oi);

            fis.close();
            oi.close();

            System.out.println(dad1.age);
            System.out.println(son1.father.lastName);
            System.out.println(mom1.firstName);
            System.out.println(dad1.children.get(0).firstName);
        }
    }

}
