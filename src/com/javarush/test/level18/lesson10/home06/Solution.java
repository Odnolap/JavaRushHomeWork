package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream f = new FileInputStream(args[0]);
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();

        while (f.available() > 0)
        {
            byte b = (byte)f.read();
            if (map.containsKey(b))
            {
                map.put(b, map.get(b) + 1);
            }
            else
            {
                map.put(b, 1);
            }
        }

        f.close();

        Byte[] ba = new Byte[map.size()];
        ba = map.keySet().toArray(ba);

        boolean isEnd = false;
        byte b2;

        while (!isEnd)
        {
            isEnd = true;
            for (int i = 1; i < ba.length; i++)
            {
                if (ba[i] < ba[i - 1])
                {
                    isEnd = false;
                    b2 = ba[i];
                    ba[i] = ba[i - 1];
                    ba[i - 1] = b2;
                }
            }
        }

        for(byte b : ba)
        {
            System.out.println((char)b + " " + map.get(b));
        }

    }
}
