package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        if (query == null || delimiter == null) return null;

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[tokenizer.countTokens()];
        int i = 0;

        while (tokenizer.hasMoreElements())
        {
            result[i] = tokenizer.nextToken();
            i++;
        }

        return result;
    }

    public static void main(String[] args)
    {
        for (String s : getTokens("level22.lesson13.task01", "."))
        System.out.println(s);
    }
}
