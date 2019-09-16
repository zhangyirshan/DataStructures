package com.matthew.Stack;

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e) throws IllegalAccessException;

    E pop() throws IllegalAccessException;

    E peek() throws IllegalAccessException;

}
