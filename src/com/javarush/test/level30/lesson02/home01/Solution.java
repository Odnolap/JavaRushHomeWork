package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110
        Number result2 = convertNumberToOtherNumerationSystem(new Number(NumerationSystemType._2, "120"), NumerationSystemType._2);
        System.out.println(result2);    //expected Exception
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        String s = number.getDigit();
        if (null == s || s.isEmpty() || s.contains("-") || s.contains(".") || s.contains(",")) {
            return null;
        }

        BigInteger resultInt;

        try
        {
            resultInt = new BigInteger(s, number.getNumerationSystem().getNumerationSystemIntValue());
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException();
        }
        String resultString = resultInt.toString(expectedNumerationSystem.getNumerationSystemIntValue());

        return new Number(expectedNumerationSystem, resultString);
    }
}
