package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == null) return false;
        if (!this.getClass().getName().equals(n.getClass().getName())) return false;
        Solution n2 = (Solution)n;
        if (first == null && n2.first == null && last == null && n2.last == null) return true;
        else if (first == null && n2.first == null && last != null && n2.last != null) return n2.last.equals(last);
        else if (first != null && n2.first != null && last == null && n2.last == null) return n2.first.equals(first);
        else if (first != null && n2.first != null && last != null && n2.last != null) return n2.first.equals(first) && n2.last.equals(last);
        else return false;
    }

    public int hashCode() {
        if (first == null && last == null) return 0;
        else if (first == null) return last.hashCode();
        else if (last == null) return 31 * first.hashCode();
        else return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution s1 = new Solution("Donald", "Duck");
        System.out.println(s1.getClass().getSimpleName());
        System.out.println(s1.getClass());
        s.add(s1);
        Solution s2 = new Solution("Donald", "Duck");
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s.contains(s2));
    }
}
