package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Odnolap on 04.10.2015.
 */
public class CurrencyManipulator
{
    String currencyCode;
    Map<Integer, Integer> denominations;

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    public int getTotalAmount()
    {
        int totalSum = 0;

        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            totalSum += pair.getKey() * pair.getValue();
        }

        return totalSum;
    }

    public boolean hasMoney()
    {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Integer[] cashNominals = denominations.keySet().toArray(new Integer[1]);
        Arrays.sort(cashNominals, Collections.reverseOrder());
        int currentNominalIndex = 0; // Начинаем с максимальной купюры
        Map<Integer, Integer> cashNominalsCount = new HashMap<>(); // Номиналы с количеством для выдачи
        cashNominalsCount.put(cashNominals[currentNominalIndex], denominations.get(cashNominals[currentNominalIndex])); // Рассматриваем возможность использования всех купюр текущего номинала в банкомате
        int countOfCurrentNominal;
        int sumLeft = expectedAmount; // Осталось добрать до нужной суммы
        boolean isOk = false;

        while (!isOk)
        {
            countOfCurrentNominal = sumLeft / cashNominals[currentNominalIndex];
            if (countOfCurrentNominal < cashNominalsCount.get(cashNominals[currentNominalIndex]))
                cashNominalsCount.put(cashNominals[currentNominalIndex], countOfCurrentNominal);
            sumLeft -= cashNominals[currentNominalIndex] * cashNominalsCount.get(cashNominals[currentNominalIndex]); // Осталось добрать до требуемой суммы

            if (sumLeft == 0)
            {
                isOk = true;
            }
            else
            {
                currentNominalIndex++; // Переход на меньший номинал

                while (currentNominalIndex >= denominations.size()) // Если меньшего номинала нет, т.е. дошли до последнего номинала, но не смогли набрать нужную сумму
                {
                    do {
                        currentNominalIndex--;
                    }
                    while (currentNominalIndex >= 0 && cashNominalsCount.get(cashNominals[currentNominalIndex]) == 0); // Переходим на номиналы побольше, чтобы там была хотя бы 1 купюра в нашем наборе

                    // Не смогли набрать нужную сумму
                    if (currentNominalIndex < 0)
                        throw new NotEnoughMoneyException();
                    else
                    {
                        cashNominalsCount.put(cashNominals[currentNominalIndex], cashNominalsCount.get(cashNominals[currentNominalIndex]) - 1); // Уменьшаем количество купюр на 1
                        sumLeft += cashNominals[currentNominalIndex]; // Увеличиваем сумму, которую надо добрать на стоимость удаленной купюры
                        currentNominalIndex++; // Переход на меньший номинал
                    }
                }

                cashNominalsCount.put(cashNominals[currentNominalIndex], denominations.get(cashNominals[currentNominalIndex])); // Рассматриваем возможность использования всех купюр текущего номинала в банкомате
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = cashNominalsCount.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<Integer, Integer> item = it.next();
            if (item.getValue() == 0)
                it.remove();
            else
                denominations.put(item.getKey(), denominations.get(item.getKey()) - item.getValue());
        }

        /*
        for (Map.Entry<Integer, Integer> pair : cashNominalsCount.entrySet())
        {
            denominations.put(pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
        }
        */

        return cashNominalsCount;
    }

}
