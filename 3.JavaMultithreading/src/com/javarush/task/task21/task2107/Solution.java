package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
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

        @Override
        protected User clone() throws CloneNotSupportedException {
            User newuser = new User(this.age, this.name);
            return newuser;
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution newsol = new Solution();
        Map<String, User> newusers = new LinkedHashMap<>(this.users);
        newsol.users = newusers;
        return newsol;
    }
}
