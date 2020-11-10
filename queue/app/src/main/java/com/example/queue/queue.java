package com.example.queue;


public class queue<T> {
    /* inherent properties of a queue*/
    private int size = 0;
    private node<T> root;
    private node<T> tail;

    /*creation of queue*/
    public queue() {
        root = null;
        tail = null;
        size = 0;
    }

    /*interface of queue */

    /*enqueue value onto q */
    public queue<T> enqueue(T value) {
        node<T> temp = new node<T>(value);

        if (isEmpty()) {
            tail = temp;
            root = temp;
        }
        else {
            tail.setNext(temp);
            tail = temp;
        }
        size++;
        return this;
    }
    /*dequeue value from q */
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }
        T aValue = root.getV();
        root = root.getNext();
        size--;
        return aValue;
    }
    public int length() {
        return size;
    }
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    /*test main*/
    public static void main(String[] args) {
        queue<Integer> aQueue = new queue();
        for(int i = 0; i < 10; i++) {
            aQueue.enqueue(i);
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("dequeue value: " + aQueue.dequeue());
        }
        try {
            aQueue.dequeue();
        }catch(NullPointerException e){};
        aQueue.enqueue(20);
        System.out.println("dequeue value: " + aQueue.dequeue());
        try {
            aQueue.dequeue();
        }catch(NullPointerException e){};
    }
}
