package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Odnolap on 05.01.2016.
 */
public class Cook extends Observable implements Runnable
{
    private String name;
    private boolean busy = false;
    private LinkedBlockingQueue<Order> orderBlockingQueue;

    public boolean isBusy()
    {
        return busy;
    }

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public void startCookingOrder(Order order)
    {
        busy = true;
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order.toString(), order.getTotalCookingTime()));
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        try
        {
            Thread.sleep(order.getTotalCookingTime() * 10);
        }
        catch (InterruptedException ignored)
        {
        }
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    public void setQueue(LinkedBlockingQueue<Order> orderBlockingQueue)
    {
        this.orderBlockingQueue = orderBlockingQueue;
    }

    @Override
    public void run()
    {
        Order order = null;
        while (true)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {return;}

            if (order == null)
            {
                order = orderBlockingQueue.poll();
            }

            if (order != null)
            {

                if (!isBusy())
                {
                    startCookingOrder(order);
                    order = null;
                }
            }
        }
    }
}
