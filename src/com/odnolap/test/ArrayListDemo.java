package com.odnolap.test;

/**
 * Created by Odnolap on 04.04.2015.
 */
import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {

        // create an empty array list with an initial capacity
        ArrayList<Integer> arrlist = new ArrayList<Integer>();

        // use add() method to add values in the list
        arrlist.add(10);
        arrlist.add(12);
        arrlist.add(31);
        arrlist.add(49);

        System.out.println("Printing elements of array1");

        // let us print all the elements available in list
        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }

        // toArray copies content into other array
        Integer[] list2 = new Integer[arrlist.size() + 1];
        list2[list2.length - 1] = -2;
        Integer[] list3;
        list3 = arrlist.toArray(list2);

        System.out.println("Printing elements of array2");

        // let us print all the elements available in list
        for (Integer number : list2) {
            System.out.println("Number = " + number);
        }

        for (Integer i : list3)
        {
            System.out.println("3 N = " + i);
        }

        System.out.println(list2);
        System.out.println(arrlist);
    }
}
