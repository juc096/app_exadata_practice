package com.example.graph;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class graph<T> {

    private Hashtable<T, vertex<T>> vertices;

    public graph() {vertices = new Hashtable<T, vertex<T>>();}

    public boolean add(T v) {
        if (vertices.put(v, new vertex<T>(v)) != null)
            return false;
        return true;
    }

    public boolean connect(T v1, T v2) {
        if (vertices.get(v1) == null || vertices.get(v2) == null)
            return false;
        vertices.get(v1).addNeighbor(vertices.get(v2));
        vertices.get(v2).addNeighbor(vertices.get(v1));
        return true;
    }

    public int size() {
        return vertices.size();
    }

    public void dfs_traversal(T start) {
        Stack<T> st = new Stack<T>();
        Set<T> visited = new HashSet<>();
        st.push(start);
        while (!st.isEmpty()) {
            T temp = st.peek();
            st.pop();

            if (!visited.contains(temp)) {
                System.out.print(temp + " ");
                visited.add(temp);
                vertex<T> aNode = vertices.get(temp);
                for (vertex<T> v : aNode.getNeighbors()) {
                    st.push(v.getV());
                }
            }
        }
    }
    public void bfs_traversal(T start) {
        Queue<T> q = new LinkedList<T>();
        Set<T> visited = new HashSet<>();
        q.add(start);
        while (!q.isEmpty()) {
            T temp = q.peek();
            q.poll();

            if (!visited.contains(temp)) {
                System.out.print(temp + " ");
                visited.add(temp);
                vertex<T> aNode = vertices.get(temp);
                for (vertex<T> v : aNode.getNeighbors()) {
                    q.add(v.getV());
                }
            }
        }
    }

    /* djikstras algorithm basically */
    public Hashtable<T, Integer> shortest_path(T start) {
        Hashtable<T, Integer> sp_table = new Hashtable<>();
        for (T vtx : vertices.keySet())
            sp_table.put(vtx, -1);
        sp_table.put(start, 0);

        Queue<T> q = new LinkedList<T>();
        Set<T> visited = new HashSet<>();

        q.add(start);

        while (!q.isEmpty()) {
            T temp = q.peek();
            q.poll();

            if(!visited.contains(temp)) {
                visited.add(temp);
                vertex<T> aNode = vertices.get(temp);
                for (vertex<T> v : aNode.getNeighbors()) {
                    q.add(v.getV());

                    int edge_weight = 1;
                    Integer neighbor_sp = sp_table.get(v.getV());
                    int distance = sp_table.get(temp);

                    if ((neighbor_sp == -1 ) ||
                            (distance + edge_weight < neighbor_sp))
                        sp_table.put(v.getV(), distance + edge_weight);
                }
            }
        }


        return sp_table;
    }
    public static void main(String[] args) {
        graph<Integer> g = new graph<Integer>();
        for (int i = 0; i < 8; i++)
            g.add(i);
        System.out.println("Vertices : " + g.size());
        for (int j = 0; j < 4; j++) {
            g.connect(j, j+1);
        }
        g.connect(1, 5);
        g.connect(5,6);
        g.connect(0,7);
        /*
                0
               / \
              1   7
             / \
            2   5
           /     \
          3       6
         /
        4
      */

        System.out.print("dfs : ");
        g.dfs_traversal(0);
        System.out.println();
        System.out.print("bfs : ");
        g.bfs_traversal(0);
        System.out.println();

        g.connect(1,4);
        Hashtable<Integer, Integer> sp = g.shortest_path(7);
        for (int i = 0; i < 8; i++)
            System.out.println("shortest path from 7" +
                    " to " + i + ": " + sp.get(i));



    }
}
