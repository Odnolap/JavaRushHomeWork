package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Odnolap on 14.01.2016.
 */
public class RandomOrderGeneratorTask implements Runnable
{
    private List<Tablet> tablets = new ArrayList<>();
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(interval);
                int i = ThreadLocalRandom.current().nextInt(0, tablets.size());
                tablets.get(i).createTestOrder();
            }
            catch (InterruptedException e)
            {
                return;
            }
        }
    }
}
