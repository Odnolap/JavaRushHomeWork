package com.javarush.test.level20.lesson10.bonus03;

import java.util.LinkedList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> lw = detectAllWords(crossword, "home", "same", "jj");
        System.out.println(lw.size());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> resultList = new LinkedList<>();

        if (crossword.length == 0) return resultList;
        int sY = crossword.length;
        if (crossword[0].length == 0) return resultList;
        int sX = crossword[0].length;

        int startX;
        int startY;
        int endX;
        int endY;

        boolean b;
        int iNapr;
        int xIncr = 0;
        int yIncr = 0;

        for (String w : words)
        {
            b = false;

            for (int y = 0; y < sY; y++)
            {
                for (int x = 0; x < sX; x++)
                {
                    if (crossword[y][x] == w.charAt(0))
                    {
                        b = false;
                        startX = x;
                        startY = y;
                        iNapr = 0;

                        while (iNapr < 8 && !b)
                        {
                            b = true;
                            switch (iNapr)
                            {
                                case 0: xIncr = 0; yIncr = -1; break;
                                case 1: xIncr = 1; yIncr = -1; break;
                                case 2: xIncr = 1; yIncr = 0; break;
                                case 3: xIncr = 1; yIncr = 1; break;
                                case 4: xIncr = 0; yIncr = 1; break;
                                case 5: xIncr = -1; yIncr = 1; break;
                                case 6: xIncr = -1; yIncr = 0; break;
                                case 7: xIncr = -1; yIncr = -1; break;
                            }


                            for(int k = 1; k < w.length(); k++)
                            {
                                if (!(b && (y + k * yIncr >= 0) && (y + k * yIncr < sY) && (x + k * xIncr >= 0) && (x + k * xIncr < sX) && (crossword[y + k * yIncr][x + k * xIncr] == w.charAt(k))))
                                {
                                    b = false;
                                }
                            }

                            iNapr++;
                        }

                        if (b)
                        {
                            endX = x + (w.length() - 1) * xIncr;
                            endY = y + (w.length() - 1) * yIncr;
                            Word word = new Word(w);
                            word.setStartPoint(startX, startY);
                            word.setEndPoint(endX, endY);
                            resultList.add(word);
                            // System.out.println(word);
                        }

                    }

                    //if (b) break;
                }

                //if (b) break;
            }
        }

        return resultList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
