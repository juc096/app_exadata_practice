package com.example.graph;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class reverseshufflemerge {
    static String reverseShuffleMerge(String s) {
        HashSet<Character> letters = new HashSet<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        LinkedList<Character> ll = new LinkedList<>();
        Stack<Character> st = new Stack<>();

        String reverse= "";
        String smallest = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
            letters.add(s.charAt(i));
        }
        for (Character c: letters)
            pq.add(c);
        for (Character c: pq)
            ll.add(c);
        while (!pq.isEmpty()) {
            Character a_char = ll.getFirst();
            ll.removeFirst();
            int idx = s.indexOf(a_char);
            while (s.indexOf(a_char, idx+1) != -1) {

            }
            pq.poll();


        }
        return "";
    }


}
