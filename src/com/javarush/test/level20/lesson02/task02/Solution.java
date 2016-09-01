package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("test6", null,  new File("C:\\Evgeniy\\test"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User u1 = new User();
            u1.setFirstName("Igor");
            u1.setLastName("Petrov");
            u1.setBirthDate(new Date("01/05/1985"));
            u1.setMale(true);
            u1.setCountry(User.Country.RUSSIA);

            User u2 = new User();
            u2.setFirstName("Ira");
            u2.setLastName("Ivanova");
            u2.setBirthDate(new Date("08/20/1980"));
            u2.setMale(false);
            u2.setCountry(User.Country.UKRAINE);

            User u3 = new User();
            u3.setFirstName("Vadim");
            u3.setLastName("Sidorov");
            u3.setBirthDate(new Date("04/15/1983"));
            u3.setMale(true);
            u3.setCountry(User.Country.OTHER);

            javaRush.users.add(u1);
            javaRush.users.add(u2);
            javaRush.users.add(u3);
            javaRush.users.add(null);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            printWriter.println(users.size());
            for (User u : users)
            {
                if (u != null)
                {
                    printWriter.println("NormalUser");

                    if (u.getFirstName() == null)
                    {
                        printWriter.println("!");
                    }
                    else
                    {
                        printWriter.println("_" + u.getFirstName());
                    }

                    if (u.getLastName() == null)
                    {
                        printWriter.println("!");
                    }
                    else
                    {
                        printWriter.println("_" + u.getLastName());
                    }

                    if (u.getBirthDate() == null)
                    {
                        printWriter.println("!");
                    }
                    else
                    {
                        printWriter.println("_" + dateFormat.format(u.getBirthDate()));
                    }

                    printWriter.println(u.isMale());

                    if (u.getCountry() == null)
                    {
                        printWriter.println("!");
                    }
                    else
                    {
                        printWriter.println("_" + u.getCountry().getDisplayedName());
                    }
                }
                else
                {
                    printWriter.println("NullUser");
                }

            }

            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int usersCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < usersCount; i++)
            {

                String userType = reader.readLine();

                if ("NullUser".equals(userType))
                {
                    users.add(null);
                }
                else
                {
                    User u = new User();

                    String firstName = reader.readLine();
                    String lastName = reader.readLine();
                    String birthDate = reader.readLine();
                    String isMale = reader.readLine();
                    String countryName = reader.readLine();

                    if (firstName.charAt(0) != '!')
                    {
                        u.setFirstName(firstName.substring(1));
                    }

                    if (lastName.charAt(0) != '!')
                    {
                        u.setLastName(lastName.substring(1));
                    }

                    if (birthDate.charAt(0) != '!')
                    {
                        u.setBirthDate(new Date(birthDate.substring(1)));
                    }

                    if ("true".equals(isMale))
                    {
                        u.setMale(true);
                    }

                    if (countryName.charAt(0) != '!')
                    {
                        switch (countryName.substring(1))
                        {
                            case "Ukraine":
                                u.setCountry(User.Country.UKRAINE);
                                break;
                            case "Russia":
                                u.setCountry(User.Country.RUSSIA);
                                break;
                            default:
                                u.setCountry(User.Country.OTHER);

                        }
                    }

                    users.add(u);
                }

            }

            reader.close();
        }
    }
}
