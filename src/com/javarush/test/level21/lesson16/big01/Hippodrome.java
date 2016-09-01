package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Odnolap on 09.08.2015.
 */
public class Hippodrome
{
    public static Hippodrome game;

    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Prodigy", 3, 0));
        game.getHorses().add(new Horse("Flash", 3, 0));
        game.getHorses().add(new Horse("Arrow", 3, 0));
        game.run();
        game.printWinner();
    }

    public void move()
    {
        for(Horse h: horses)
        {
            h.move();
        }

    }

    public void print()
    {
        for(Horse h: horses)
        {
            h.print();
        }

        System.out.println("");
        System.out.println("");
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {

            }
        }
    }

    public Horse getWinner()
    {
        Horse winner = null;
        for (Horse h : horses)
        {
            if (winner == null && h != null)
                winner = h;
            else if (winner.getDistance() < h.getDistance())
                winner = h;
        }

        return winner;
    }

    public void printWinner()
    {
        System.out.printf("Winner is %s!", getWinner().getName());
    }
}
