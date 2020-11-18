package com.example.test_java_q;


import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class java_test {
    // 1) LRU cache in java
    //start time: 8:35
    //end time: 9:07
    public class lru_cache<K, V> extends LinkedHashMap<K, V> {

        private int max_table_size;
        private double load_f; //for our use

        public lru_cache() {
            super(16,3/4, true);
            //side note: 16 is default table size for LinkedHashMap
            //Using a specified initial capacity of 16 for clarity
            max_table_size = 16;
            load_f = 0.75;
        }
        public lru_cache(int tbl_size) {
            super(16,3/4, true);
            max_table_size = tbl_size;
            load_f = 0.75;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > max_table_size;
        }

    }
    // 2) check if two strings are rotations of each other
    // start time:  9:07
    // end time: 9:22


    public static boolean is_rotation(String s1, String s2) {

        if(s1.length() != s2.length())
            return false;

        for (int i = 0; i < (s1.length() - 1); i++) {
            String temp = s1.substring(i) + s1.substring(0, i);
            if (temp.compareTo(s2) == 0)
                return true;
        }
        return false;
    }

    // 3) convert linked list to binary
    // start time: 9:29
    //end time: 10:45
    public class ll_to_binary<T extends Comparable<T>> {
        private class node<T> {
            public T value;
            public node<T> left, right, parent;
            public node(T v) {
                value = v;
                left = null;
                right = null;
                parent = null;
            }
        }
        public node<T> root;
        public int size;
        public ll_to_binary(LinkedList<T> a_list) {
            root = null;
            size = 0;
            convert_ll(a_list);
        }

        public void convert_ll(LinkedList<T> a_list) {
            for (T v : a_list)
                insert(v);
        }

        public ll_to_binary<T> insert(T v) {
            node<T> temp = root;
            node<T> parent = null;

            if (root == null) {
                size++;
                root = new node<T>(v);
                return this;
            }

            //traverse and insert new node in empty spot
            while (temp != null) {
                parent = temp;
                if(v.compareTo(temp.value) > 0) {
                    temp = temp.right;
                    if (temp == null) {
                        temp = new node<T>(v);
                        temp.parent = parent;
                        parent.right = temp;
                        break;
                    }
                }
                else {
                    temp = temp.left;
                    if (temp == null) {
                        temp = new node<T>(v);
                        temp.parent = parent;
                        parent.left = temp;
                        break;
                    }
                }
            }
            //we've inserted and now must bubble up to correct position
            //IN GENERAL: we swap positions with parent when:
            //   case 1) left child is greater in value than its parent
            //   case 2) right child is lesser in value than its parent
            //my implementation has no tree balancing tactic
            //i will always traverse/create in accordance to its value
            //thus we only care about case 1.

            //while the new node is greater than its parent
            while (temp.value.compareTo(parent.value) > 0) {
                //if the new node is the right node of its parent
                //it is already in correct position, thus break out of loop
                if (parent.right == temp)
                    break;
                T temp_value = temp.value;
                temp_value = parent.value;
                parent.value = temp_value;
                temp = temp.parent;
                parent = temp.parent;
            }

            size++;
            return this;
        }
        //8 preorder traversal
        //this is a very generic approach
        public void pre_order_traversal(node<T> aNode) {
            HashSet<node<T>> visited = new HashSet<>();
            Stack<node<T>> st = new Stack<>();

            st.push(aNode);
            while (!st.isEmpty()) {
                node<T> temp = st.peek();
                st.pop();
                if(visited.add(temp)) {
                    System.out.println(temp.value);
                    st.push(temp.left);
                    st.push(temp.right);
                }

            }
        }
    }

    //wrapper class for linkedlist questions
    public class ll_questions<T> {
        //example of a node object
        public class node<T> {
            public T value;
            public node<T> next, prev;
        }

        //linkedlist properties
        public node<T> head, tail;
        public int size;

        //4) find 3rd element from tail end of linkedlist
        //start time: 11:23
        //end time: 11:24
        public node<T> third_element_from_tail() {
            node<T> temp = tail;
            for (int i = 0; i < 3; i++)
                temp = temp.prev;
            return temp;
        }
        //5) check if ll has loop
        //start time 11:25
        //end time 11:35

        public boolean has_loop() {
            //essentially just do dfs and check if previous nodes were visited
            HashSet<node<T>> visited = new HashSet<>();
            node<T> temp = head;

            while (temp != null) {
                if(!visited.add(temp))
                    return true;
                temp = temp.next;
            }
            return false;
        }

        //6) find ll size
        //5min
        public int ll_size() {
            node<T> temp = head;
            int size = 0;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            return size;
        }
        //7) reverse linked list
        //assuming this is doubly linked
        //10m
        public void reverse_ll() {
            node<T> temp = head;
            //for each node, swap prev and next fields
            //null values are also swapped for head/tail pointers
            while (temp != null) {
                node<T> temp_next = temp.next;
                node<T> temp_prev = temp.prev;
                temp.next = temp.prev;
                temp.prev = temp_next;
                temp = temp_next;
            }
            //finally swap head and tail pointers
            temp = tail;
            tail = head;
            head = temp;
        }

    }


    public static void main(String[] args) {
        String s1 = "dabc";
        String s2 = "abcd";
        System.out.println(is_rotation(s1, s2));
    }
}
