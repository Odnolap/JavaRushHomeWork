package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Odnolap on 04.01.2016.
 */
public class Tablet
{
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private AdvertisementManager advertisementManager;
    private LinkedBlockingQueue<Order> orderBlockingQueue;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        Order order = null;

        try
        {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());

            if (!order.isEmpty())
            {
                realizeOrder(order);
            }
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public void createTestOrder()
    {
        Order order = null;

        try
        {
            order = new TestOrder(this);
            ConsoleHelper.writeMessage(order.toString());

            if (!order.isEmpty())
            {
                realizeOrder(order);
            }
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void realizeOrder(Order order)
    {

        orderBlockingQueue.add(order);

        advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
        advertisementManager.processVideos();
    }

    @Override
    public String toString()
    {
        return "Tablet{number=" + number + "}";
    }

    public void setQueue(LinkedBlockingQueue<Order> orderBlockingQueue)
    {
        this.orderBlockingQueue = orderBlockingQueue;
    }
}
