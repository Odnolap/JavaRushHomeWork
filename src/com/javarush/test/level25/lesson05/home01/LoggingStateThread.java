package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Odnolap on 21.09.2015.
 */
public class LoggingStateThread extends Thread
{
    private Thread loggedThread;

    public LoggingStateThread(Thread loggedThread)
    {
        this.loggedThread = loggedThread;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        State state = loggedThread.getState();

        System.out.println(state);

        while (state != State.TERMINATED)
        {
            if (state != loggedThread.getState())
            {
                state = loggedThread.getState();
                System.out.println(state);
            }
        }
    }
}
