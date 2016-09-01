package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Odnolap on 13.01.2016.
 */
public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();

    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance()
    {
        return instance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public List<Advertisement> getAds(boolean isArchive)
    {
        ArrayList<Advertisement> result = new ArrayList<>();
        for (Advertisement a : advertisementStorage.list())
        {
            if (a.getHits() > 0 && !isArchive ||
                    a.getHits() <= 0 && isArchive)
                result.add(a);

        }

        Collections.sort(result, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        return result;
    }
}
