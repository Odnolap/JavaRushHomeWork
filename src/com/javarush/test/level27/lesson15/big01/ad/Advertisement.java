package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Odnolap on 05.01.2016.
 */
public class Advertisement implements Comparable<Advertisement>
{
    private Object content; // видео
    private String name; // имя/название
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах

    private long amountPerOneDisplaying;

    private long currentAmount;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        currentAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits > 0)
        {
            amountPerOneDisplaying = Math.round(currentAmount * 1.0 / hits);
        }
        else
            amountPerOneDisplaying = 0;
    }

    public String getName()
    {
        return name;
    }

    public int getDuration()
    {
        return duration;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }

    public int getHits() {return hits; }

    public void revalidate()
    {
        if (hits <= 0)
            throw new UnsupportedOperationException();
        else
        {
            hits--;
            currentAmount -= amountPerOneDisplaying;
            if (hits > 0)
                amountPerOneDisplaying = Math.round(currentAmount * 1.0 / hits);
        }
    }

    @Override
    public int compareTo(Advertisement o)
    {
        if (this.getAmountPerOneDisplaying() == o.getAmountPerOneDisplaying())
        {
            return Long.compare(this.getAmountPerOneDisplaying() * 1000 / this.getDuration(), o.getAmountPerOneDisplaying() * 1000 / o.getDuration());
        }
        else
            return Long.compare(o.getAmountPerOneDisplaying(), this.getAmountPerOneDisplaying());
    }
}
