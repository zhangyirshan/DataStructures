package com.matthew.Queue;

import com.matthew.Array.Array;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/12 19:48
 * @Version 1.0
 */

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 加入队尾元素
     * @param e
     * @throws IllegalAccessException
     */
    @Override
    public void enqueue(E e) throws IllegalAccessException {
        array.addLast(e);
    }

    /**
     * 移除队首元素
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public E dequeue() throws IllegalAccessException {
        return array.removeFirst();
    }

    /**
     * 查看队首元素
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public E getFront() throws IllegalAccessException {
        return array.getFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue : ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            try {
                res.append(array.get(i));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
