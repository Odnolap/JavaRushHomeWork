package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Odnolap on 18.06.2016.
 */
public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(500);
            Thread currentThread = Thread.currentThread();
            while (!currentThread.isInterrupted()) {
                ShareItem item = queue.take();
                System.out.println("Processing " + item);
            }
        }
        catch (InterruptedException ignored) { }
    }
}
