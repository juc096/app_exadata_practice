package com.example.graph;

import java.util.HashSet;


public class vertex<T> {
    private HashSet<vertex<T> > neighbors;
    private T value;
    vertex(T v) {
        value = v;
        neighbors = new HashSet<vertex<T> >();
    }
    public vertex<T> addNeighbor(vertex<T> v) {
        neighbors.add(v);
        return this;
    }
    public HashSet<vertex<T>> getNeighbors() {return neighbors;}
    public T getV() {return value;}
}
