package com.matthew.Queue;

public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e) throws IllegalAccessException;

    E dequeue() throws IllegalAccessException;

    E getFront() throws IllegalAccessException;

}
