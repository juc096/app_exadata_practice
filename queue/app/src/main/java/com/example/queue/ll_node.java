package com.example.queue;

public class ll_node<T> {
    public T value;
    public ll_node<T> next;
    public ll_node<T> prev;

    /*creation of node*/
    public ll_node(T v) {
        value = v;
        next = null;
        prev = null;
    }

    /*interface of node */

    public T getV() {return value;}

    public ll_node<T> setNext(ll_node<T> aNode) {
        next = aNode;
        return this;
    }
    public ll_node<T> setPrev(ll_node<T> aNode) {
        prev = aNode;
        return this;
    }

    public ll_node<T> getNext() {
        return next;
    }

    public ll_node<T> getPrev() {return prev;}
}
