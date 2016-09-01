package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution {

    public static class Person implements Serializable{
        private static final long serialVersionUID = 1L;
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString =  "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex{
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws Exception
    {
        Person p1 = new Person("Igpr", "Petrov", "RF", Sex.MALE);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(p1);

        baos.close();
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        Person p2 = (Person)ois.readObject();

        bais.close();
        ois.close();

        System.out.println(p2.firstName);
        System.out.println(p2.lastName);
        System.out.println(p2.fullName);
        System.out.println(p2.greetingString);
        System.out.println(p2.country);
        System.out.println(p2.sex);
        System.out.println(p2.outputStream);
        System.out.println(p2.logger);
    }

}
