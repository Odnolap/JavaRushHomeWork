package com.javarush.test.level25.lesson02.task02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            Set<Wheel> wheelsSet = new HashSet<>();
            wheels = new LinkedList<>();

            for (String wheelName : loadWheelNamesFromDB())
            {
                try
                {
                    Wheel newWheel = Wheel.valueOf(wheelName);
                    if (!wheelsSet.contains(newWheel))
                    {
                        wheels.add(newWheel);
                        wheelsSet.add(newWheel);
                    } else
                    {
//                        wheels.clear();
                        System.out.println("Это не машина!");
                        return;
                    }
                }
                catch (IllegalArgumentException e)
                {
//                    wheels.clear();
                    System.out.println("Это не машина!");
                }
            }

            if (wheels.size() != 4)
            {
//                wheels.clear();
                System.out.println("Это не машина!");
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}
