package com.odnolap.test;

import java.io.IOException;

/**
 * Created by Odnolap on 01.07.2016.
 */
public class ThrowsExceptionTest
{
    public static void main(String[] args)
    {
        try
        {
            throw new IOException("IOException text");
        }
        catch (IOException e) {
            System.out.println("IOE thrown - " + e.getMessage());
            throw new IndexOutOfBoundsException("IOOBE text"); // Этот выброс исключения пролетает все следующие блоки catch у этого try и пробросится дальше
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IOOBE thrown - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception thrown");
        }
    }
}
