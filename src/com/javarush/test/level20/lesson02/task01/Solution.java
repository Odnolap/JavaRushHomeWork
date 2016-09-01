package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("test5", null,  new File("C:\\Evgeniy\\test"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
//            OutputStream outputStream = System.out;
            InputStream inputStream = new FileInputStream(your_file_name);
//            InputStream inputStream = System.in;

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"), new Asset(""), new Asset(null));
            ivanov.save(outputStream);
            outputStream.flush();


            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name);
            System.out.println(somePerson.assets.get(0).getName());
            System.out.println(somePerson.assets.get(0).getPrice());
            System.out.println(somePerson.assets.get(3).getName());
            System.out.println(somePerson.assets.get(3).getPrice());
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            boolean b = ivanov.equals(somePerson);
            System.out.println(b);
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            printWriter.println(assets.size());
            for (Asset asset : assets)
            {
                if (asset != null)
                {
                    printWriter.println("NormalAsset");
                    if (asset.getName() != null)
                    {
                        printWriter.println("NormalName");
                        printWriter.println(asset.getName());
                    } else
                    {
                        printWriter.println("NullName");
                    }

                    printWriter.println(asset.getPrice());
                }
                else
                {
                    printWriter.println("NullAsset");
                }
            }
//            printWriter.flush();
            printWriter.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            name = reader.readLine();
            int assetsCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < assetsCount; i++)
            {
                String isNormalAsset = reader.readLine();
                if ("NormalAsset".equals(isNormalAsset))
                {
                    String isNormalName = reader.readLine();
                    String assetName;
                    if ("NormalName".equals(isNormalName))
                    {
                        assetName = reader.readLine();
                    } else
                    {
                        assetName = null;
                    }
                    Asset asset = new Asset(assetName);
                    asset.setPrice(Double.parseDouble(reader.readLine()));
                    assets.add(asset);
                }
                else
                {
                    assets.add(null);
                }
            }

            reader.close();
        }


    }
}
