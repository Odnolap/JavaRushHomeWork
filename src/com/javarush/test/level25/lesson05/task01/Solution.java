package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread t : threads)
        {
            switch (t.getState())
            {
                case NEW: t.start(); break;
                case WAITING: case TIMED_WAITING: case BLOCKED: t.interrupt(); break;
                case RUNNABLE: t.isInterrupted() ; break;
                case TERMINATED:
                    System.out.println(t.getPriority()); break;
                default: break;
            }
        }
    }
}
