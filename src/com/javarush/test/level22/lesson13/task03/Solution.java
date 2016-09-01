package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        boolean b = true;
        if (telNumber.charAt(0) == '+') b = b && telNumber.replaceAll("\\D", "").length() == 12;
        if (telNumber.matches("[(|\\d].*")) b = b && telNumber.replaceAll("\\D", "").length() == 10;
        b = b && telNumber.matches("[^-]*-?[^-]+-?[^-]*");
        if (telNumber.indexOf('(') >= 0)
            b = b && telNumber.indexOf('(', telNumber.indexOf('(') + 1) == -1 &&
                    telNumber.indexOf(')') == telNumber.indexOf('(') + 4 &&
                    telNumber.indexOf(')', telNumber.indexOf(')') + 1) == -1 &&
                    (telNumber.indexOf('-') == -1 || telNumber.indexOf(')') < telNumber.indexOf('-'));
        b = b && (telNumber.replaceAll("[a-zA-Z]", "").length() == telNumber.length());
        b = b && telNumber.matches(".*\\d");

        return b;
    }

}
