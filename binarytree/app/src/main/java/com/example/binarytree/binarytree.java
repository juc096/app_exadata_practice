package com.example.binarytree;

import java.util.Stack;

public class binarytree<T extends Comparable<T> >  {

    public t_node<T> root;
    public int size = 0;


    public binarytree() {
        root = null;
    }
    public binarytree(t_node<T> aNode) {
        root = aNode;
        size++;

    }
    /*
    insert element into tree
        -no rebalancing
        -worst case time complexity: O(N) + O(N) = O(N)
        -avg case (if numbers are random enough): O(logN)
     */
    public binarytree<T> insert(T v) {
        t_node<T> aNode = new t_node<T>(v);

        if(size == 0) {
            root = aNode;
            size++;
            return this;
        }

        t_node<T> temp = root;

        while (temp != null) {
            //traverse right
            if(v.compareTo(temp.getValue()) > 0) {
                if (temp.right == null) {
                    aNode.parent = temp;
                    temp.right = aNode;
                    temp = temp.right;
                    break;

                }

                temp = temp.right;
            }
            //traverse left
            else {
                if (temp.left == null) {
                    aNode.parent = temp;
                    temp.left = aNode;
                    temp = temp.left;
                    break;

                }
                temp = temp.left;
            }

        }

        //start swapping up
        while (temp.getValue().compareTo(temp.parent.getValue()) > 0) {
            if (temp.parent.right == temp)
                break;

            T parent_val = temp.parent.getValue();
            temp.parent.setValue(temp.getValue());
            temp.setValue(parent_val);
            temp = temp.parent;
        }
        return this;
    }

    public void traversal(t_node<T> aNode) { //inorder
        if (aNode == null) {
            return;
        }
        traversal(aNode.left);
        System.out.println(aNode.getValue());
        traversal(aNode.right);

    }


    /*
        avg time complexity: O(logN)
        worst case: O(N)
     */
    public t_node<T> findVal(T v, t_node<T> aNode) {
        if (aNode.getValue().compareTo(v) > 0) {
            return findVal(v, aNode.left);
        }
        if (aNode.getValue().compareTo(v) < 0) {
            return findVal(v, aNode.right);
        }
        return aNode;

    }
    /*
        dfs implemented w/ recursion
     */
    public t_node<T> dfs_rec(T v, t_node<T> aNode) {
        //base cases
        if (aNode == null) // (aNode.isVisited()) OR IF NODE VISITED
            return null;
        if (aNode.getValue().compareTo(v) == 0)
            return aNode;

        //SET NODE VISITED
        //aNode.visited()

        //find neighbors and traverse
        t_node<T> temp = dfs_rec(v, aNode.left);
        if (temp == null)
            temp = dfs_rec(v, aNode.right);
        return temp;

    }
    /*
        dfs using while loop
        Time Complexity: O(|E| + |V|)
        Space Complexity: O(|V|)
     */
    public t_node<T> dfs(T v) {
        //stack mimics depth search behavior
        Stack<t_node<T>> st = new Stack<t_node<T>>();
        st.push(root);
        t_node<T> aNode = null; //node to return

        while(!st.isEmpty()) {
            //pop stack and look at element
            aNode = st.peek();
            st.pop();

            //SET NODE VISITED
            //aNode.visited()

            if (aNode.getValue().compareTo(v) == 0) // (aNode.isVisited()) OR IF NODE VISITED
                break;
            //if value not found, add neighbors onto stack
            if (aNode.left != null)
                st.push(aNode.left);
            if (aNode.right != null)
                st.push(aNode.right);
        }
        return aNode;
    }
    /*test main*/
    public static void main(String[] args) {
       binarytree<Integer> tr = new binarytree();

        int a[] = {3,1,2,7,8,5};
        for(int i = 0; i < 6; i++) {
            tr.insert(a[i]);
        }
        System.out.println("traversing:");
        tr.traversal(tr.root);
        System.out.println("traverse end");
        System.out.println("finding 7: ");
        System.out.println("found: " +  tr.findVal(7, tr.root).getValue());
        try {
            System.out.println("finding 50: ");
            tr.findVal(50, tr.root);
        }
        catch (NullPointerException e) {
            System.out.println("50 not found");
        }
        System.out.println("finding 7 with dfs: ");
        System.out.println("found: " +  tr.dfs(7).getValue());
        System.out.println("finding 7 with dfs rec: ");
        System.out.println("found: " +  tr.dfs_rec(7, tr.root).getValue());
    }


}
