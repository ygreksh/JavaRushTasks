package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
/*
    public Solution(){
        first = null;
        last = null;
    }
*/
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        if (!first.equals(solution.first)) return false;
        return last.equals(solution.last);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + last.hashCode();
        return result;
    }*/


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Solution)) return false;

            Solution solution = (Solution) o;

            if(this.hashCode()==solution.hashCode()) {
                if (first.equals(solution.first) && last.equals(solution.last)) return true;
            }
            return false;

        }

        @Override
        public int hashCode() {
            int result =(first!=null) ? first.hashCode() : 0;
            result = 31 * result + ((last!=null) ? last.hashCode():0);
            return result;
        }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        s.add(new Solution("Donald", "Duck"));
        //Solution sol1 = new Solution("Donald", "Duck");
        //Solution sol2 = new Solution("Donald", "Duck");
        //System.out.println(sol1.equals(sol2));

       //System.out.println(new Solution("Donald", "Duck").hashCode());
        //System.out.println(new Solution("Donald", "Duck").hashCode());
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.size());
    }
}
