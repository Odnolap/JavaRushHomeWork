package com.javarush.test.level13.lesson11.bonus02;

import java.util.List;

public class Person implements RepkaItem
{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh)
    {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public void pull(Person person)
    {
        System.out.println(name + " за " + person.getNamePadezh());
    }

    public String getNamePadezh()
    {
        return namePadezh;
    }
}
