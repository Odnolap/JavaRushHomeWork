package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(1.0d, "One");
        labels.put(2.0d, "Two");
        labels.put(3.0d, "Three");
        labels.put(4.0d, "Four");
        labels.put(0.0d, "Zero");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
