package com.example.queue;

public class node<T> {

    /* inherent properties of a node*/
    private T value;
    private node<T> next;

    /*creation of node*/
    public node(T v) {
        value = v;
        next = null;
    }

    /*interface of node */

    public T getV() {return value;}

    public node<T> setNext(node<T> aNode) {
        next = aNode;
        return this;
    }

    public node<T> getNext() {
        return next;
    }
}
