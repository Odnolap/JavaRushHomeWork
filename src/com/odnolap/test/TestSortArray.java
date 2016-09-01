package com.odnolap.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Odnolap on 17.08.2015.
 */
public class TestSortArray
{
    /*public static void main(String[] args)
    {
        String[] sa = {"First", "Second", "Third", "Fourth"};
        Arrays.sort(sa);
        for(int i = 0; i < sa.length; i++)
            System.out.println(sa[i]);
    }*/

    public static void main(String[] args)
    {
        orderedGuests1(new String[] { "в", "а", "б" });
        orderedGuests2(new String[]{"c", "a", "b"});
        orderedGuests3(new String[]{"в", "а", "б"});
        System.out.println("-----------");
        fruitSortTest();
    }

    public static void orderedGuests1(String[] sa)
    {
        Arrays.sort(sa);
        System.out.println(Arrays.toString(sa));
    }

    public static void orderedGuests2(String[] sa)
    {
        Collections.sort(Arrays.asList(sa));
        System.out.println(Arrays.toString(sa));
    }

//    Сортировка со своим собственным правилом сравнения (хорошо бы проверять, равны ли сравниваемые элементы и не пусты ли они)
    public static void orderedGuests3(String[] sa)
    {
        Arrays.sort(sa, new Comparator<String>(){
            public int compare(String s1, String s2)
            {
                if (s1 == "а") return 1;
                else if (s2 == "а") return  - 1;
                else return s1.compareTo(s2);
            }
        });
        System.out.println(Arrays.toString(sa));
    }


    static class Fruit
    {

        private String fruitName;
        private String fruitDesc;
        private int quantity;

        public Fruit(String fruitName, String fruitDesc, int quantity) {
            super();
            this.fruitName = fruitName;
            this.fruitDesc = fruitDesc;
            this.quantity = quantity;
        }

        public String getFruitName() {
            return fruitName;
        }
        public void setFruitName(String fruitName) {
            this.fruitName = fruitName;
        }
        public String getFruitDesc() {
            return fruitDesc;
        }
        public void setFruitDesc(String fruitDesc) {
            this.fruitDesc = fruitDesc;
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public static void fruitSortTest()
    {
        Fruit[] fruits = new Fruit[4];

        Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70);
        Fruit apple = new Fruit("Apple", "Apple description",100);
        Fruit orange = new Fruit("Orange", "Orange description",80);
        Fruit banana = new Fruit("Banana", "Banana description",90);

        fruits[0]=pineappale;
        fruits[1]=apple;
        fruits[2]=orange;
        fruits[3]=banana;

        Comparator<Fruit> fruitComparator = new Comparator<Fruit>()
        {
            @Override
            public int compare(Fruit o1, Fruit o2)
            {
                String fruitName1 = o1.getFruitName().toUpperCase();
                String fruitName2 = o2.getFruitName().toUpperCase();

                //ascending order
                return fruitName1.compareTo(fruitName2);

                //descending order
                //return fruitName2.compareTo(fruitName1);
            }
        };

        Arrays.sort(fruits, fruitComparator);
        int i = 0;
        for(Fruit temp: fruits){
            System.out.println("fruits " + ++i + " : " + temp.getFruitName() +
                    ", Quantity : " + temp.getQuantity());
        }

        System.out.println("----");

        Arrays.sort(fruits, Collections.reverseOrder(fruitComparator));

        i = 0;
        for(Fruit temp: fruits){
            System.out.println("fruits " + ++i + " : " + temp.getFruitName() +
                    ", Quantity : " + temp.getQuantity());
        }


    }

}
