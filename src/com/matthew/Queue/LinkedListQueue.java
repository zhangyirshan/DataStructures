package com.matthew.Queue;

import com.matthew.LinkedList.LinkedList;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/16 18:48
 * @Version 1.0
 */

public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(int i, E e) {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) throws IllegalAccessException {

    }

    @Override
    public E dequeue() throws IllegalAccessException {
        return null;
    }

    @Override
    public E getFront() throws IllegalAccessException {
        return null;
    }
}
