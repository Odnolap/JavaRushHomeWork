package com.odnolap.test;

import java.util.Arrays;

/**
 * Created by Odnolap on 16.08.2015.
 */
public class TestRegExp
{
    public static void main(String[] args)
    {
        String s = "ABc:\\test.txt";
        System.out.println(s);
        System.out.println(s.replaceAll("c:\\\\.*", "___"));

        s = "Good news everyone!";

        System.out.println(s.matches("\\.*news\\.*"));

        System.out.println("abcdefGH123UZ".replace("fGH1", String.format("%" + "fGH1".length() + "s", "").replace(' ', '*')));

        // email
        System.out.println("---- EMAIL ----");
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
        System.out.println("+-lskjf.kjd.dk@skljd.gghgj.jkfdd".matches(EMAIL_PATTERN));
        System.out.println("a@bcd.mail.com".matches(EMAIL_PATTERN));
        System.out.println("a@bcd.mail.com".matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"));
        //url
        System.out.println("---- URL ----");
        System.out.println("http://mail.ru".matches("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"));
        //words in line
        System.out.println("---- WORDS IN LINE ----");
        String line = "Hello! this is a line. It can't be hard to split into \"words\", can it?";
        String[] words = line.split("[^\'\\w]+");
//        String[] words = line.split("(?<=[,.])|(?=[,.])|\\s+");
//        String[] words = line.split("[^\\s\"']+|\"[^\"]*\"|'[^']*'");

        for (String word : words) System.out.println(word);
        System.out.println(Arrays.toString(words));

        System.out.println(Arrays.toString("   200   5 ".trim().replaceAll("[ ]+", " ").split(" ")));
        System.out.println("   200   5 ".trim().replaceAll("[ ]+", "").replaceAll("\\d", "").isEmpty());
        System.out.println("   200   5 ".matches("\\d+ \\d+"));
        System.out.println("200   5".matches("\\d+ \\d+"));
        System.out.println("200 5".matches("\\d+ \\d+"));

        System.out.println("1".matches("[1-4]"));
        System.out.println("11".matches("[1-4]"));
        System.out.println("61".matches("[1-4]{1}"));
        System.out.println("12".matches("[1-4]{2}"));

    }
}
