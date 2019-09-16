package com.matthew.Stack;

import com.matthew.Array.Array;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/11 21:23
 * @Version 1.0
 */

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) throws IllegalAccessException {
        array.addLast(e);
    }

    @Override
    public E pop() throws IllegalAccessException {
        return array.removeLast();
    }

    @Override
    public E peek() throws IllegalAccessException {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayStack:[");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
                if (i != array.getSize() - 1) {
                    res.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        res.append("] top");
        return String.valueOf(res);
    }
}
