package com.odnolap.test;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by Odnolap on 08.08.2015.
 */
public class TestFile
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Пробная строка кирилицей");
        String s = "C:\\Evgeniy\\test\\test.txt8";
        File f = new File(s);
        if (f.exists() && !f.isDirectory())
            System.out.println(s + " is a real file");
        else if (f.isDirectory())
            System.out.println(s + " is a directory!");
        else System.out.println(s + " is not a file and not a directory!");

        URL website = new URL("http://vk.com/images/join/prof_m.png");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("C:\\Evgeniy\\test\\test.png");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();

        BufferedInputStream in = new BufferedInputStream(new URL("http://vk.com/images/join/prof_m.png").openStream());
        FileOutputStream fos2 = new FileOutputStream("C:\\Evgeniy\\test\\test2.png");
        BufferedOutputStream bout = new BufferedOutputStream(fos2);
        byte data[] = new byte[1024];
        int read;
        while((read = in.read(data,0,1024))>=0)
        {
            System.out.println(read);
            bout.write(data, 0, read);
        }
        System.out.println(read); // -1
        bout.close();
        in.close();

        // Create a directory; all non-existent ancestor directories are
        // automatically created
        System.out.println(" ---- CREATE FOLDER ----");
        boolean success = new File("D:\\Evgeniy\\test\\Test Folder 2").mkdirs();
        if (!success) {
            // Directory creation failed
            System.out.println("Папка не создалась. Not OK");
        }
        else
        {
            System.out.println("Папка создалась. OK");
        }


    }
}
