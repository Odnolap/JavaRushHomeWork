package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            OutputStream outputStream = new FileOutputStream("C:\\Evgeniy\\test\\test.txt");
            InputStream inputStream = new FileInputStream("C:\\Evgeniy\\test\\test.txt");

            Object object = new Object();
            object.string1 = new String();   //string #1
//            object.string1 = null;
//            object.string2 = new String();   //string #2
            object.string2 = null;
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            if (loadedObject.string1 != null)
                loadedObject.string1.print();
            else
                System.out.println("S1 = null");
            if (loadedObject.string2 != null)
                loadedObject.string2.print();
            else
                System.out.println("S2 = null");
            System.out.println(countStrings);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintStream consoleStream = System.out;
            PrintStream printStream = new PrintStream(outputStream);
            System.setOut(printStream);
            if (string1 == null)
            {
                System.out.println("nullString");
            }
            else
            {
                string1.print();
            }
            if (string2 == null)
            {
                System.out.println("nullString");
            }
            else
            {
                string2.print();
            }
            System.setOut(consoleStream);
//            outputStream.close();
            printStream.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            java.lang.String s = reader.readLine();
            if ("nullString".equals(s))
            {
                string1 = null;
            }
            else
            {
                int i = Integer.parseInt(s.substring(s.indexOf('#') + 1));
                int curCountStrings = countStrings;
                countStrings = i - 1;
                string1 = new String();
                countStrings = curCountStrings;
            }

            s = reader.readLine();
            if ("nullString".equals(s))
            {
                string2 = null;
            }
            else
            {
                int i = Integer.parseInt(s.substring(s.indexOf('#') + 1));
                int curCountStrings = countStrings;
                countStrings = i - 1;
                string2 = new String();
                countStrings = curCountStrings;
            }
            reader.close();

        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
