package com.javarush.test.level23.lesson13.big01;

public class SnakeSection
{
    private int x;
    private int y;


    public SnakeSection(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public int hashCode()
    {
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (!obj.getClass().getName().equals(this.getClass().getName())) return false;

        SnakeSection ss = (SnakeSection)obj;
        return (x == ss.x && y == ss.y);
    }
}
