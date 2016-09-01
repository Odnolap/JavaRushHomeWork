package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Odnolap on 18.01.2016.
 */
public class MyThread extends Thread
{
    private static volatile int curPriority = -1;

    public MyThread()
    {
        curPriority++;
        this.setPriority(curPriority % 10 + 1);
    }

    public MyThread(Runnable target)
    {
        super(target);
        curPriority++;
        this.setPriority(curPriority % 10 + 1);
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        curPriority++;
        if (curPriority % 10 + 1 > group.getMaxPriority())
            this.setPriority(group.getMaxPriority());
        else
            this.setPriority(curPriority % 10 + 1);
    }

    public MyThread(String name)
    {
        super(name);
        curPriority++;
        this.setPriority(curPriority % 10 + 1);
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        curPriority++;
        if (curPriority % 10 + 1 > group.getMaxPriority())
            this.setPriority(group.getMaxPriority());
        else
            this.setPriority(curPriority % 10 + 1);
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        curPriority++;
        this.setPriority(curPriority % 10 + 1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        curPriority++;
        if (curPriority % 10 + 1 > group.getMaxPriority())
            this.setPriority(group.getMaxPriority());
        else
            this.setPriority(curPriority % 10 + 1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        curPriority++;
        if (curPriority % 10 + 1 > group.getMaxPriority())
            this.setPriority(group.getMaxPriority());
        else
            this.setPriority(curPriority % 10 + 1);
    }

}
