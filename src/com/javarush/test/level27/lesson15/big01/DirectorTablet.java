package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by Odnolap on 12.01.2016.
 */
public class DirectorTablet
{
    public void printAdvertisementProfit()
    {
        long totalAmount = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        DecimalFormat myFormatter = new DecimalFormat("###.##");
        List<Calendar> dates = StatisticEventManager.getInstance().getDatesByType(EventType.SELECTED_VIDEOS);
        Collections.sort(dates, Collections.reverseOrder());

        for (Calendar cal : dates)
        {
            long amount = StatisticEventManager.getInstance().getAmountByDay(cal);
            totalAmount += amount;
            ConsoleHelper.writeMessage(simpleDateFormat.format(cal.getTime()) + " - " + myFormatter.format(amount * 1.0 / 100));
        }

        ConsoleHelper.writeMessage("Total - " + myFormatter.format(totalAmount * 1.0 / 100));

    }

    public void printCookWorkloading()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        List<Calendar> dates = StatisticEventManager.getInstance().getDatesByType(EventType.COOKED_ORDER);
        Collections.sort(dates, Collections.reverseOrder());

        for (Calendar cal : dates)
        {
            ConsoleHelper.writeMessage(simpleDateFormat.format(cal.getTime()));
            List<String> cooksNames = StatisticEventManager.getInstance().getCooksNamesByDate(cal);
            Collections.sort(cooksNames);

            for (String cookName : cooksNames)
            {
                int i = StatisticEventManager.getInstance().getCookingTimeByDayAndCookName(cal, cookName);
                ConsoleHelper.writeMessage(cookName + " - " + (int)Math.ceil(i * 1.0 / 60) + " min");
            }

            ConsoleHelper.writeMessage("");
        }

    }

    public void printActiveVideoSet()
    {
        for (Advertisement a: StatisticAdvertisementManager.getInstance().getAds(false))
        {
            ConsoleHelper.writeMessage(a.getName() + " - " + a.getHits());
        }
    }

    public void  printArchivedVideoSet()
    {
        for (Advertisement a: StatisticAdvertisementManager.getInstance().getAds(true))
        {
            ConsoleHelper.writeMessage(a.getName());
        }
    }
}
