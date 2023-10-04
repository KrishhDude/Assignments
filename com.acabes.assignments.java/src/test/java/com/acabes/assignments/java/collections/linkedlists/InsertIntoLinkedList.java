package com.acabes.assignments.java.collections.linkedlists;

import java.util.LinkedList;
//
//class Node {
//    int data;
//    Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//

public class InsertIntoLinkedList {


    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();

        list.addFirst(1);
        list.add(3);
        list.addLast(5);
        System.out.println(list);
    }
}
