package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!this.getClass().getName().equals(o.getClass().getName())) return false;
        Solution n = (Solution) o;
        if (first == null && n.first == null && last == null && n.last == null) return true;
        else if (first == null && n.first == null && last != null && n.last != null) return n.last.equals(last);
        else if (first != null && n.first != null && last == null && n.last == null) return n.first.equals(first);
        else if (first != null && n.first != null && last != null && n.last != null) return n.first.equals(first) && n.last.equals(last);
        else return false;
    }

    @Override
    public int hashCode()
    {
        if (first == null && last == null) return 0;
        else if (first == null) return last.hashCode();
        else if (last == null) return first.hashCode();
        else return first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
