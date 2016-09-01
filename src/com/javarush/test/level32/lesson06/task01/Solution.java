package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] ba = new byte[8];
        boolean isGoodSet = false;

        while (!isGoodSet) {
            boolean hasDigit = false;
            boolean hasBigLetter = false;
            boolean hasSmallLetter = false;

            for (int i = 0; i < 8; i++) {
                ba[i] = (byte)(Math.random() * 3); // 0 - digit (48-57); 1 - BIG LETTER (65-90); 2 - small letter (97-122)
                switch (ba[i]) {
                    case 0 : hasDigit = true; break;
                    case 1 : hasBigLetter = true; break;
                    case 2 : hasSmallLetter = true; break;
                }
            }
            isGoodSet = hasDigit && hasBigLetter && hasSmallLetter;
        }

        for (int i = 0; i < 8; i++) {
            switch (ba[i]) {
                case 0 : ba[i] = (byte)(48 + (Math.random() * 10)); break;
                case 1 : ba[i] = (byte)(65 + (Math.random() * 26)); break;
                case 2 : ba[i] = (byte)(97 + (Math.random() * 26)); break;
            }
        }

        try {
            baos.write(ba);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baos;
    }
}
