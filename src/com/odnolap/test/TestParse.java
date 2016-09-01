package com.odnolap.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Odnolap on 20.04.2015.
 */
public class TestParse
{
    public static void main(String[] args)
    {
        String st = "-c Миронов м 15/04/1990";
        System.out.println(st);
        System.out.println("Миронов");
        String[] params = st.split(" ");
        for (String s : params)
            System.out.println(s);

        Date bd = null;
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try
        {
            bd = sd.parse(params[3]);
        }
        catch (ParseException e) {}

        System.out.println(bd);
    }
}
