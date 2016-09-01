package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Odnolap on 05.01.2016.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    private List<Advertisement> allVideos;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {
        allVideos = new ArrayList<>(storage.list());
        for (int i = allVideos.size() - 1; i >= 0; i--)
            if (allVideos.get(i).getHits() <= 0)
                allVideos.remove(i);

        Collections.sort(allVideos, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return Long.compare(o1.getDuration(), o2.getDuration());
            }
        });

        List<Advertisement> advertisementsForView;
        if (!allVideos.isEmpty())
        {
            advertisementsForView = getAdFoView2(new ArrayList<Advertisement>(), timeSeconds, 0);

            if (advertisementsForView.isEmpty())
            {
                throw new NoVideoAvailableException();
            }
        }
        else
            throw new NoVideoAvailableException();

        Collections.sort(advertisementsForView);
        long am = 0;
        int d = 0;
        for (Advertisement a : advertisementsForView)
        {
            am += a.getAmountPerOneDisplaying();
            d += a.getDuration();
        }

        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(advertisementsForView, am, d));

        for (Advertisement a : advertisementsForView)
        {
            ConsoleHelper.writeMessage(String.format(a.getName() + " is displaying... %d, %d", a.getAmountPerOneDisplaying(), a.getAmountPerOneDisplaying() * 1000 / a.getDuration()));
            a.revalidate();
        }

    }

    //На вход получаем список с видео и оставшееся время в секундах, а так же номер шага рекурсии, начиная с 0
    public List<Advertisement> getAdFoView2(List<Advertisement> list, int timeLeftSeconds, int step)
    {
        // Все видео в allVideos отсортированы по возрастанию длительности, т.ч. если текущее видео (с индексом step) добавить не получится, то и следующие не получится
        if (timeLeftSeconds < allVideos.get(step).getDuration())
            return list;

        // Если текущее видео имеет 0 или меньше показов и это не последнее видео, то спускаемся дальше по списку
        if (allVideos.get(step).getHits() <= 0 && step != allVideos.size() - 1)
            return getAdFoView2(list, timeLeftSeconds, step + 1);

        // Если текущее видео имеет 0 или меньше показов и это последнее видео, то возвращаем список, полученный на вход
        if (allVideos.get(step).getHits() <= 0 && step == allVideos.size() - 1)
            return list;

        //2-й список получается путем добавления текущего видео (оно влезает по дительности, см. первую проверку) к списку из входного параметра
        List<Advertisement> list2 = new ArrayList<>(list);
        list2.add(allVideos.get(step));

        //Если это последний шаг, то возвращаем 2-й список, т.к. он длиннее на 1 видео
        if (step == allVideos.size() - 1)
            return list2;

        // Рекурсивный вызов функции для обоих списков
        List<Advertisement> result1 = getAdFoView2(list, timeLeftSeconds, step + 1);
        List<Advertisement> result2 = getAdFoView2(list2, timeLeftSeconds - allVideos.get(step).getDuration(), step + 1);

        //Далее идет сравнение полученных результатов
        int bestResult;
        long am1 = 0;
        long am2 = 0;
        long d1 = 0;
        long d2 = 0;
        int c1 = 0;
        int c2 = 0;

        for (Advertisement a : result1)
        {
            am1 += a.getAmountPerOneDisplaying();
            d1 += a.getDuration();
            c1++;
        }
        for (Advertisement a : result2)
        {
            am2 += a.getAmountPerOneDisplaying();
            d2 += a.getDuration();
            c2++;
        }

        if (am1 > am2)
            bestResult = 1;
        else if (am2 > am1)
            bestResult = 2;
        else if (d1 > d2)
            bestResult = 1;
        else if (d2 > d1)
            bestResult = 2;
        else if (c1 < c2)
            bestResult = 1;
        else if (c2 < c1)
            bestResult = 2;
        else
            bestResult = 1;


        if (bestResult == 1)
          return result1;
        else
            return result2;
    }

}
