package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.util.Date;

public class Solution {
    Solution() {}
    Solution(int i) {}
    Solution(String s) {}

    protected Solution(Float f) {}
    protected Solution(Double d) {}
    protected Solution(Date d) {}

    public Solution(Integer i) {}
    public Solution(char c) {}
    public Solution(byte b) {}

    private Solution(long l) {}
    private Solution(boolean b) {}
    private Solution(Long l) {}
}

