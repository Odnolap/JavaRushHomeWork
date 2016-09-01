package com.odnolap.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Odnolap on 19.01.2016.
 */
public class TestExecutorService
{
    public static void main(String[] args) throws InterruptedException
    {
        //1. Создаем ThreadPoolExecutor
        ExecutorService service = Executors.newFixedThreadPool(5);

        //2 помещаем в него задачу для выполнения
        Future<String> task = service.submit(new ReverseString("Amigo"));

        //5 останавливаем ThreadPool.
        service.shutdown();
        //На самом деле, запрещаем добавлять в него новые таски: следующая строка вызовет ошибку java.util.concurrent.RejectedExecutionException
        // Future<String> task2 = service.submit(new ReverseString("Amigo2"));

        //3 ждем пока задача выполнится
        while(!task.isDone())
        {
            Thread.sleep(1000);
        }

        //4 пробуем получить результат задачи
        //получим или результат или исключение, если оно было при выполнении задачи
        try
        {
            System.out.println("Развернутая строка : " + task.get());
        }
        catch (Exception ie)
        {
            ie.printStackTrace(System.err);
        }

    }

    public static class ReverseString implements Callable<String>
    {
        String str;

        ReverseString(String str)
        {
            this.str = str;
        }

        public String call() throws Exception
        {
            StringBuilder builder = new StringBuilder(str);
            builder.reverse();
            return builder.toString();
        }
    }
}
