package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException
        {
            User u = null;

            if (name != null)
                u = new User(age, new String(name));
            else
                u = new User (age, null);
            return u;
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {
        Solution s = new Solution();
        for (Map.Entry<String, User> pair : users.entrySet() )
        {
            if (pair.getKey() != null && pair.getValue() != null)
                s.users.put(new String(pair.getKey()), (User)pair.getValue().clone());
            else if (pair.getKey() != null && pair.getValue() == null)
                s.users.put(new String(pair.getKey()), null);
            else if (pair.getKey() == null && pair.getValue() != null)
                s.users.put(null, (User)pair.getValue().clone());
            else s.users.put(null, null);
        }
        return s;
    }
}
