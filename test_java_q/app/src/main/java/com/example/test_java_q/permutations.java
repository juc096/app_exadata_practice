package com.example.test_java_q;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

//13
//time: 1hr

public class permutations {

    public LinkedList<Character> str;
    public Set<String> all_permutations;

    public permutations(String s) {

        str = new LinkedList<>();
        all_permutations = new HashSet<>();

        //linkedlist to represent string
        for (int i = 0; i < s.length(); i++)
            str.add(s.charAt(i));

    }
    //recursive function to calculate permutations
    //we return a stack filled with string combinations
    private Stack<String> permute() {
        //stack is initiated and used as string builder
        Stack<String> st = new Stack<>();
        //base case
        if (str.size() == 0) {
            st.push("\0");
            return st;
        }

        //loop based on linkedlist size
        //note: as we recurse down, linkedlist will shrink to size 0, then as we
        //recurse up, size/elements will be restored
        for (int i = 0; i < str.size(); i++) {
            //get the first value from the top of linkedlist and pop it off
            Character first_c = str.getFirst();
            str.removeFirst();

            //recursive call -- next recurse will operate on a smaller linked list without
            //the first char
            Stack<String> temp = permute();

            //now we got combinations in stack, we start prepending the first char to each string
            //in stack
            while (!temp.empty()) {
                String temp_s = first_c + temp.peek();
                //all_permutations holds them all in a set
                all_permutations.add(temp_s);
                //stack is used as a string builder
                st.push(temp_s);
                temp.pop();
            }
            //add element back into linkedlist tail-end
            //loop will run through all elements this way
            str.addLast(first_c);
        }

        return st;
    }

    public Set<String> get_permutations() {
        this.permute();
        return all_permutations;
    }

    public static void main(String[] args) {
        permutations perm = new permutations("abcd");
        Set<String> perm_set = perm.get_permutations();
        for (Iterator<String> it = perm_set.iterator(); it.hasNext();)
            System.out.println(it.next());

        //check if the size of the set is correct using some math based on a string size = 4
        if (perm_set.size() != ((4*3*2*1) + (4*3*2) + (4*3) + (4*1)))
            System.out.println("Something when wrong");

        String s = "ab";
        String s1 = "az";
        System.out.println("Hi");
        System.out.println(s.compareTo(s1));
        System.out.println(s1.compareTo(s));

    }
}

