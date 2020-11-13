package com.example.queue;

public class linked_list_custom<T> {
    ll_node<T> head, tail;
    int size = 0;

    public linked_list_custom() {
        head = null;
        tail = null;
        size = 0;
    }
     public linked_list_custom<T> add(T v) {
        ll_node<T> aNode = new ll_node<>(v);
        if (size == 0) {
            aNode.next = null;
            aNode.prev = null;
            head = aNode;
            tail = aNode;
            size++;
            return this;
        }
        if (head == tail) {
            head.next = aNode;
            aNode.next = null;
            aNode.prev = tail;
            tail = aNode;

            size++;
            return this;
        }

        aNode.next = null;
        tail.next = aNode;
        aNode.prev = tail;

        tail = aNode;
        System.out.println((tail.prev.value));
         //System.out.println((head.value));
        size++;
        return this;

     }

     public linked_list_custom<T> rotate(int n) {
        int to_shift = n % size;
        ll_node<T> tempT = tail;
        ll_node<T> tempH = head;
        tail.next = head;
        head.prev = tail;

        for (int i = 0; i < to_shift; i++) {
            tempT = tempT.prev;
        }

        tail = tempT;
        head = tempT.next;
        head.prev = null;
        tail.next = null;

        return this;

     }

     public void print() {
        ll_node<T> temp = head;
        while (temp != null) {
            System.out.print(" " + temp.value);
            temp = temp.next;
        }
     }

     public static void main(String[] args) {
        linked_list_custom<Integer> ll = new linked_list_custom<>();
        for (int i = 0; i < 10; i++)
            ll.add(i);
        System.out.print("list: ");
        ll.print();
        System.out.println();
         System.out.print("list after rotate 3: ");
        ll.rotate(3);
        ll.print();
         System.out.println();

     }
}
