package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        Thread t1 = new TestThread1();
        Thread t2 = new TestThread2();
        Thread t3 = new TestThread3();
        Thread t4 = new TestThread4();
        Thread t5 = new TestThread5();

        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);
    }

    static class TestThread1 extends Thread
    {
        public void run()
        {
            while (true) {}
        }
    }

    static class TestThread2 extends Thread
    {
        public void run()
        {
            try
            {
                while (true)
                {
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }

        }
    }

    static class TestThread3 extends Thread
    {
        public void run()
        {
            try
            {
                while (true)
                {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e) {}

        }
    }

    static class TestThread4 extends Thread implements Message
    {
        public void showWarning()
        {
            try
            {
                this.interrupt();
                this.join();
            }
            catch (InterruptedException e) {}
        }

        public void run()
        {
            try
            {
                while (true)
                {
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e) {}
        }

    }

    static class TestThread5 extends Thread
    {
        double d;
        String s = null;
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public void run()
        {
            try
            {
                s = reader.readLine();
                while (!"N".equals(s))
                {
                    d += Double.parseDouble(s);
                    s = reader.readLine();
                }
                System.out.println(d);

            }
            catch (IOException e) {}

        }
    }
}
