package com.matthew.Stack;

import com.matthew.LinkedList.LinkedList;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/16 18:25
 * @Version 1.0
 */

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) throws IllegalAccessException {
        list.addFirst(e);
    }

    @Override
    public E pop() throws IllegalAccessException {
        return list.removeFirst();
    }

    @Override
    public E peek() throws IllegalAccessException {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
