package com.example.queue;


public class queue<T extends Comparable <T>> {

    /* inherent properties of a queue*/
    protected int size = 0;
    protected node<T> root;
    protected node<T> tail;
    protected node<T> header;

    /*creation of queue*/
    public queue() {
        header = new node<T>(null);
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
        node<T> temp  = root.getNext();

        root.setNext(null);
        root = temp;
        size--;
        return aValue;
    }
    public void print() {
        node<T> temp = root;
        while (temp != header) {
            System.out.println("printing q: " + temp.getV());
            temp = temp.getNext();
        }
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
