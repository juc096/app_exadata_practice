package com.example.test_java_q;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

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
    // 30-40m

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
    //1min
    public String replace_char(String s1, char c, char r) {
        return s1.replace(c, r);
    }
    //13
    Set<String> perms = new HashSet<>();
    public void permutations(String s) {
        //base cases
        if (s.length() == 1) {
            perms.add(s);
            return;
        }
        if (s.length() == 2) {

        Set<String> perms = new HashSet<>();
        Stack<Character> st = new Stack<>();
        permutations(s)

    }

}
