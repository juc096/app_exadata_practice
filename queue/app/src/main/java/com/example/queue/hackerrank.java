package com.example.queue;

public class hackerrank {
    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {


        SinglyLinkedListNode reverse = null;
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode temp_prev = null;

        while (temp.next != null) {

            while (temp.next != null) {
                temp_prev = temp;
                temp = temp.next;
            }

            if(reverse == null)
                reverse = temp;

            temp.next = temp_prev;
            temp_prev.next = null;
            temp = head;
        }

        return reverse;

    }

    //with recursion
    static boolean first = true;
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

        SinglyLinkedListNode aNode = null;


        if(head.next.next == null) {
            aNode = head.next;
            aNode.next = head;
            return aNode;
        }

        if (first) {
            first = false;
            aNode = reverse(head.next);
            head.next.next = head;
            head.next = null;
            first = true;
            return aNode;
        }

        aNode = reverse(head.next);
        head.next.next = head;
        return aNode;


    }
    static boolean hasCycle(SinglyLinkedListNode head) {
        Set<SinglyLinkedListNode> visited = new HashSet<>();
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            if (!visited.add(temp))
                return true;
            temp = temp.next;
        }
        return false;

    }
}
