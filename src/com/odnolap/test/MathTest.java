package com.odnolap.test;

/**
 * Created by Odnolap on 02.08.2015.
 */
public class MathTest
{
    public static void main(String[] args)
    {

        System.out.println(Math.round(2.1)); // 2
        System.out.println(Math.round(2.7)); // 3
        System.out.println(Math.ceil(2.1)); // 3.0
        System.out.println(Math.ceil(2.7)); // 3.0
        System.out.println(Math.floor(2.1)); // 2.0
        System.out.println(Math.floor(2.7)); // 2.0
        System.out.println(Math.rint(2.1)); // 2.0
        System.out.println(Math.rint(2.7)); // 3.0
        System.out.println(Math.log10(322)); // 2.507855871695831

        int i = (int)Math.ceil(Math.log10(584)); // 3
        System.out.println(i);

        int i2 = (i << (i % 2)); // 6
        System.out.println(i2);

        System.out.println("BINARY TEST");
        byte[] ba = new byte[]{(byte) 192, (byte) 168, 0, 1};
        System.out.println(ba[1]); // -88
        System.out.println(Integer.toBinaryString(168)); // 10101000
        String s1 = Integer.toBinaryString(512 + (int) ba[1]).substring(1);
        System.out.println(s1); // 10101000
        System.out.println((int) ba[1]); // -88
        String s2 = Integer.toBinaryString(512 + (int) ba[1]);
        System.out.println(s2); // 110101000
        System.out.println(s2.length()); // 9
        System.out.println(s2.length() - 8); // 1
        System.out.println(s2.substring(s2.length() - 8)); // 10101000

        System.out.println(Integer.toBinaryString(256 + 168)); // 110101000
        System.out.println(Integer.toHexString(256 + 168)); // 1a8
        System.out.println("-- >>> VVVVVV <<< --");
        long l = 33;
        System.out.println(Long.toBinaryString(l)); // 100001
        System.out.println(Long.toBinaryString(l >> 0)); // 100001
        System.out.println(Long.toBinaryString(l >> 1)); // 10000
        System.out.println(Long.toBinaryString(l >> 2)); // 1000
        System.out.println(Long.toBinaryString(l >> 3)); // 100
        System.out.println(Long.toBinaryString(l >> 4)); // 10
        System.out.println(Long.toBinaryString(l >> 5)); // 1
        System.out.println(Long.toBinaryString(l >> 6)); // 0

        String s = Long.toBinaryString(l >> 5); // 1
        int k = Integer.parseInt(s.substring(s.length() - 1));
        System.out.println(k);
        if ('1' == s.charAt(s.length() - 1))
            System.out.println("ok");
        else
            System.out.println("no");
        System.out.println("-- >>> ^^^^^^ <<< --");



        System.out.println(Integer.toBinaryString((byte) 168)); //       11111111111111111111111110101000
        System.out.println(Integer.toBinaryString((int) (byte) 168)); // 11111111111111111111111110101000
        System.out.println((int)(byte)168); // -88
        System.out.println(Integer.toBinaryString(((byte)192) & 0xFF)); // 11000000
        System.out.println(Integer.toBinaryString(((byte)168) & 0xFF)); // 10101000
        System.out.println(Integer.toBinaryString((1) & 0xFF)); // 1
        System.out.println(Integer.toBinaryString((0) & 0xFF)); // 0
        System.out.println(Integer.toString(23, 19));
        System.out.println(Integer.parseInt("14", 19));
        System.out.println(Integer.toBinaryString(Integer.parseInt("14", 19)));
        System.out.println(Integer.toOctalString(Integer.parseInt("14", 19)));
        System.out.println(Integer.toHexString(Integer.parseInt("14", 19)));

    }
}
