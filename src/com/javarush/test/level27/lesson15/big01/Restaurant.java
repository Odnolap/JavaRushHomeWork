package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Odnolap on 04.01.2016.
 */
public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderLinkedBlockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {
        Cook c1 = new Cook("Amigo");
        c1.setQueue(orderLinkedBlockingQueue);
        Cook c2 = new Cook("Ivanov");
        c2.setQueue(orderLinkedBlockingQueue);
        Waitor w = new Waitor();
        c1.addObserver(w);
        c2.addObserver(w);

        List<Tablet> tablets = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderLinkedBlockingQueue);
            tablets.add(tablet);
        }

        Thread tc1 = new Thread(c1);
//        tc1.setDaemon(true);
        tc1.start();
        Thread tc2 = new Thread(c2);
//        tc2.setDaemon(true);
        tc2.start();

        RandomOrderGeneratorTask rgt = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread t = new Thread(rgt);
        t.start();
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ignored)
        {

        }

        t.interrupt();

        DirectorTablet d = new DirectorTablet();
        d.printAdvertisementProfit();
        d.printCookWorkloading();
        d.printActiveVideoSet();
        d.printArchivedVideoSet();

    }
}
