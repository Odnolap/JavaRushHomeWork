package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Odnolap on 11.01.2016.
 */
public class StatisticEventManager
{
    private static StatisticEventManager instance = new StatisticEventManager();
    private static StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticEventManager()
    {

    }

    public static StatisticEventManager getInstance()
    {
        return instance;
    }

    public void register(EventDataRow data)
    {
        statisticStorage.put(data);
    }

    public long getAmountByDay(Calendar cal)
    {
        long result = 0;

        for (EventDataRow row : statisticStorage.getRowsByType(EventType.SELECTED_VIDEOS))
        {
            Calendar rowCal = Calendar.getInstance();
            rowCal.setTime(row.getDate());
            rowCal.set(Calendar.HOUR_OF_DAY, 0);
            rowCal.set(Calendar.MINUTE, 0);
            rowCal.set(Calendar.SECOND, 0);
            rowCal.set(Calendar.MILLISECOND, 0);


            if (rowCal.equals(cal))
                result += ((VideoSelectedEventDataRow)row).getAmount();
        }

        return result;
    }

    public List<Calendar> getDatesByType(EventType eventType)
    {
        ArrayList<Calendar> result;
        Set<Calendar> calendarSet = new HashSet<>();

        for (EventDataRow row : statisticStorage.getRowsByType(eventType))
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(row.getDate());
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            calendarSet.add(cal);
        }

        result = new ArrayList<>(calendarSet);

        return result;
    }

    public List<String> getCooksNamesByDate(Calendar cal)
    {
        ArrayList<String> result;
        Set<String> cooksNamesSet = new HashSet<>();

        for (EventDataRow row : statisticStorage.getRowsByType(EventType.COOKED_ORDER))
        {
            Calendar rowCal = Calendar.getInstance();
            rowCal.setTime(row.getDate());
            rowCal.set(Calendar.HOUR_OF_DAY, 0);
            rowCal.set(Calendar.MINUTE, 0);
            rowCal.set(Calendar.SECOND, 0);
            rowCal.set(Calendar.MILLISECOND, 0);

            if (rowCal.equals(cal))
                cooksNamesSet.add(((CookedOrderEventDataRow)row).getCookName());
        }

        result = new ArrayList<>(cooksNamesSet);

        return result;
    }

    public int getCookingTimeByDayAndCookName(Calendar cal, String cookName)
    {
        int result = 0;

        for (EventDataRow row : statisticStorage.getRowsByType(EventType.COOKED_ORDER))
        {
            Calendar rowCal = Calendar.getInstance();
            rowCal.setTime(row.getDate());
            rowCal.set(Calendar.HOUR_OF_DAY, 0);
            rowCal.set(Calendar.MINUTE, 0);
            rowCal.set(Calendar.SECOND, 0);
            rowCal.set(Calendar.MILLISECOND, 0);


            if (rowCal.equals(cal) && cookName.equals(((CookedOrderEventDataRow)row).getCookName()))
                result += row.getTime();
        }

        return result;
    }

    private static class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> map;

        private StatisticStorage()
        {
            map = new HashMap<>();
            for (EventType e : EventType.values())
                map.put(e, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data)
        {
            map.get(data.getType()).add(data);
        }

        private List<EventDataRow> getRowsByType(EventType eventType)
        {
            return map.get(eventType);
        }

    }

}
