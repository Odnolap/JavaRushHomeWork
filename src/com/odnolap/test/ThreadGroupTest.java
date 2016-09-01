package com.odnolap.test;

/**
 * Created by Odnolap on 10.06.2016.
 */
public class ThreadGroupTest
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent().getName());
        Thread t = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println("t started and finished.");
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException ignored) {
                }
            }
        });
        t.start();
//        Exception e = new Exception("Test");
//        e.printStackTrace(System.out);
        Thread.sleep(100);
//        e.printStackTrace(System.err);
        System.out.println("----------");
        Thread[] ta = new Thread[3];
        int j = threadGroup.enumerate(ta);
        System.out.println(j);
        for (int i = 0; i < ta.length; i++) {
            System.out.println(ta[i]);
        }
        ta[2].interrupt();
        Thread.sleep(1000);
        System.out.println(t.getState());
        ta[2] = null;
        j = threadGroup.enumerate(ta);
        System.out.println(j);
        for (int i = 0; i < ta.length; i++) {
            System.out.println(ta[i]);
        }
        System.out.println("----------");
        threadGroup.list();
    }
}
