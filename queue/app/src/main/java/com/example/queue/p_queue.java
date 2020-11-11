package com.example.queue;

//it's basically a queue with a fancy insert
public class p_queue<T extends Comparable<T>> extends queue<T> {

    /* enqueue will automatically put values in sorted order. because my
     queue is implemented like a list, a sorted insertion functions similarly to the
    insertion sort algorithm

       avg complexity: O(N)

      side note: if i used a binary tree to implement, insertion will be O(logN)~O(N) depending
      on tree balancing
     */
    public p_queue<T> enqueue(T value) {
        node<T> temp = new node<T>(value);

        if (isEmpty()) {
            size++;
            header.setNext(temp);
            temp.setNext(header);
            root = temp;
            return this;
        }

        node<T> n = root;
        node<T> pos = header;

        /* keep a node position variable to keep track where we should insert
        the new value, again similar to insertion sort
         */
        while (n != header) {
            if (value.compareTo(n.getV()) >= 0) {
                if(n.getV().compareTo(pos.getNext().getV()) >= 0)
                    pos = n;
            }
            n = n.getNext();
        }
        temp.setNext(pos.getNext());
        pos.setNext(temp);
        if (pos == header)
            root = temp;
        size++;

        return this;
    }

    /*test main*/
    public static void main(String[] args) {
        p_queue<Integer> aQueue = new p_queue();
        int a[] = { 1, 2, 7, 8, 5, 20, 10, 6,3};
        System.out.println();
        System.out.print("inserting : ");
        for (int i = 0; i < 9; i++) {
            System.out.print(a[i] + " ");
            aQueue.enqueue(a[i]);
        }
        System.out.println();
        System.out.println("starting dequeue: values should be dequeued from small->large");
        for (int i = 0; i < 9; i++) {
            System.out.println("dequeue value: " + aQueue.dequeue());
        }
        System.out.println("dequeue end");
        try {
            aQueue.dequeue();
        } catch (NullPointerException e) {
        }
        ;

    }
}
