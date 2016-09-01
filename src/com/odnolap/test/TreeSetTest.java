package com.odnolap.test;

import java.util.TreeSet;

/**
 * Created by Odnolap on 04.10.2015.
 */
public class TreeSetTest
{
    static class Dog implements Comparable<Dog>
    {
        int size;
        Dog(int s) {
            size = s;
        }
        @Override
        public int compareTo(Dog o)
        {
            return this.size - o.size;
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> i = new TreeSet<Integer>();
        TreeSet<Dog> d = new TreeSet<Dog>();
        d.add(new Dog(1));
        d.add(new Dog(2));
        d.add(new Dog(1));

        i.add(1);
        i.add(2);
        i.add(3);

        System.out.println(d.size() + " " + i.size());
    }
}
