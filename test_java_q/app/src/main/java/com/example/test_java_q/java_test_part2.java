package com.example.test_java_q;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map;
import java.util.TreeSet;

public class java_test_part2 {
    //9) program to print first non repeated character from String
    //30m
    public void first_no_repeat(String s) {
        //using hashmap to tell us which keys are duplicates or not
        //using linkedhashmap as the insertion is in-order and is unaffected by
        //subsequent insertions
        LinkedHashMap<Character, Boolean> dupe_letters = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Boolean visited = dupe_letters.containsKey(c);
            dupe_letters.put(c, visited);
        }

        //linkedhashmap's key set is ordered by insertion
        for (Character c : dupe_letters.keySet()) {
            Boolean visited = dupe_letters.get(c);
            if(!visited) {
                System.out.println("first no repeat character: " + c);
                return;
            }
        }

        System.out.println("no characters in this string are unique");
        return;
    }

    //10 check if two strings are anagrams
    // 20-30min

    public boolean are_anagrams(String s1, String s2) {
        //if string lengths are unequal, theyre not anagrams
        if(s1.length() != s2.length())
            return false;

        //use a hashmap to count the amount of letters per string
        HashMap<Character, Integer> temp1 = new HashMap<>();
        HashMap<Character, Integer> temp2 = new HashMap<>();

        //iterate through string and put into hashmap
        //increment their count values when encountered
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            int count = temp1.containsKey(c) ? (temp1.get(c) + 1) : 1;
            temp1.put(c, count);

            c = s2.charAt(i);
            count = temp2.containsKey(c) ? (temp2.get(c) + 1) : 1;
            temp2.put(c, count);
        }

        //finally, check hashmaps to see if they have equal counts per letter
        for (Character c : temp1.keySet()) {
            //check if string 1 has a letter not found in string 2 -- this is a fast fail
            if (!temp2.containsKey(c))
                return false;
            if (temp1.get(c) != temp2.get(c))
                return false;
        }

        return true;
    }
    //11
    //Assuming s1 has no punctuation/space
    //10min
    public void letter_count(String s1) {
        String vowel = "aeiou";
        HashMap<Character, Integer> temp1 = new HashMap<>();

        for (int i = 0; i < vowel.length(); i++)
            temp1.put(vowel.charAt(i), 0);

        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            if (temp1.containsKey(c))
                temp1.put(c, temp1.get(c) + 1);
        }

        Integer vowel_count = 0;
        for (int i = 0; i < vowel.length(); i++)
            vowel_count += temp1.get(vowel.charAt(i));

        Integer consonant_count = s1.length() - vowel_count;
        System.out.println("vowel count: " + vowel_count);
        System.out.println("consonant count: " + consonant_count);
    }
    //12
    //time: 1min
    public String replace_char(String s1, char c, char r) {
        return s1.replace(c, r);
    }
     //14 find continuous sub array whose sum is equal to given number
    //time: 10min
    public int[] find_subarray(int[] a, int k) {

        for (int i = 0; i < a.length; i++) {
            int cur_sum = k;
            for (int j = i+1; j < a.length; j++) {
                cur_sum -= a[i];
                if (cur_sum < 0)
                    break;
                if (cur_sum == 0)
                    return Arrays.copyOfRange(a, i, j);
            }

        }
        return null;
    }


        //15
        //find intersection of two arrays in java
        //time: 5-10min
        public Set<Integer> find_intersection(int[] a, int[] b) {
            Set<Integer> a1 = new HashSet<>();
            Set<Integer> b1 = new HashSet<>();
            for (int i = 0; i < a.length; i++)
                a1.add(a[i]);
            for (int i = 0; i < b.length; i++)
                b1.add(b[i]);

            a1.retainAll(b1);
            return a1;

        }

        //16 separate 0s from non 0s in array
        //time: 5-10min
        public LinkedList<Integer> separate_zeros(int[] a) {

            LinkedList<Integer> q = new LinkedList<>();

            for (int i = 0; i < a.length; i++) {
                if (a[i] != 0)
                    q.addLast(a[i]);
                if (a[i] == 0)
                    q.addFirst(0);
            }

            return q;

        }
        //17 find longest substring without repeating characters in a string
        //time: 20min
    public String find_longest_sub(String s) {
        LinkedHashMap<Character, Boolean> dupe_letters = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Boolean visited = dupe_letters.containsKey(c);
            dupe_letters.put(c, visited);
        }
        int first_i, last_i, longest;
        first_i = last_i = longest = 0;

        for (Character c : dupe_letters.keySet()) {
            if(!dupe_letters.get(c)) {
                int temp_first_i = s.indexOf(c);

                for (int i = s.indexOf(c); i < s.length(); i++) {
                    Character temp_c = s.charAt(c);

                    if (dupe_letters.get(temp_c) == false)
                        continue;

                    if ((i - temp_first_i) > longest) {
                            first_i = temp_first_i;
                            last_i = i;
                            longest = last_i - first_i;
                    }
                    break;
                }
            }
        }

        return s.substring(first_i, last_i);

    }
    //18 Find the maximum value in Array without using Collection
    //time: 1min
    public int find_max(int a[]) {
            int max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (max < a[i])
                    max = a[i];
            }
            return max;
    }

    //19 sort HashMap in java by keys and values
    //time: 5-10min
    public TreeMap<Integer,Integer> sort_map_key(HashMap<Integer,Integer> a) {
            return new TreeMap<>(a);
    }
    public TreeSet<Map.Entry<Integer, Integer>> sort_map_value(HashMap<Integer, Integer> a) {

            Comparator<Map.Entry<Integer, Integer>> comp =
                (Map.Entry<Integer, Integer> b1, Map.Entry<Integer, Integer> b2) ->
                        (b1.getValue().compareTo(b2.getValue()));

            TreeSet<Map.Entry<Integer, Integer>> t = new TreeSet<>(comp);
            t.addAll(a.entrySet());
            return t;

    }
    //20 Write a java program to iterate over HashSet in java
    //time: 2 min
    public void iterate_hashset(HashSet<Integer> a) {
        for (Iterator<Integer> it = a.iterator(); it.hasNext(); )
            System.out.println(it.next());
    }


}
