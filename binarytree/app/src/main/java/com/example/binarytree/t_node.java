package com.example.binarytree;

public class t_node<T extends Comparable<T> >  {
    public t_node<T> left, right, parent;
    private T value;

    public t_node<T> setValue(T v) {
        value = v;
        return this;
    }
    public T getValue() {return value;}

    public t_node(T v) {
        parent = null;
        left = null;
        right = null;
        value = v;
    }
    public boolean hasChildren() {
        if (left != null || right != null)
            return true;
        return false;
    }

}
