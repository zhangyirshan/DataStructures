package com.matthew.LinkedList;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/14 21:10
 * @Version 1.0
 */

public class LinkedList<E> {

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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }



    //在链表index(0-based)位置添加新的元素e
    //在链表中不是一个常用的操作，练习用
    public void add(int index, E e) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Add failed,Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表头添加新的元素e
    public void addFirst(E e) throws IllegalAccessException {
        add(0, e);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) throws IllegalAccessException {
        add(size,e);
    }

    //获得链表的第index（0-based）个位置的元素
    //在链表中不是一个常用的操作，练习用
    public E get(int index) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Get failed,Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表的第一个元素
    public E getFirst() throws IllegalAccessException {
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast() throws IllegalAccessException {
        return get(size - 1);
    }

    // 更改链表中的index位置的值
    public void set(int index, E e) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Set failed,Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e == e) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    //从链表中删除index（0-based）位置的元素，返回删除的元素
    //在链表中不是一个常用的操作，练习用
    public E remove(int index) throws IllegalAccessException {
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Remove failed,Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node returnNode = prev.next;
        prev.next = returnNode.next;
        returnNode.next = null;
        size--;
        return returnNode.e;
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst() throws IllegalAccessException {
        return remove(0);
    }

    //从链表中删除最后一个元素，返回删除的元素
    public E removeLast() throws IllegalAccessException {
        return remove(size-1);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            stringBuilder.append(cur).append("->");
        }
        stringBuilder.append("Null");

        return stringBuilder.toString();
    }
}
