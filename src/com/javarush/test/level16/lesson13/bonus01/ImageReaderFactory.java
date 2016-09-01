package com.javarush.test.level16.lesson13.bonus01;

/**
 * Created by Odnolap on 30.03.2015.
 */
import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory
{
    static ImageReader getReader(ImageTypes imageType) throws IllegalArgumentException
    {
        if (imageType == ImageTypes.BMP)
        {
            return new BmpReader();
        }
        if (imageType == ImageTypes.JPG)
        {
            return new JpgReader();
        }
        if (imageType == ImageTypes.PNG)
        {
            return new PngReader();
        }

        if (true) throw new IllegalArgumentException("Неизвестный тип картинки");

        return null;
    }
}
