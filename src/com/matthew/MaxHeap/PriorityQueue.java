package com.matthew.MaxHeap;

import com.matthew.Queue.Queue;

/**
 * @Description TODO 优先队列
 * @Author Matthew
 * @Date 2019/9/23 20:32
 * @Version 1.0
 */

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) throws IllegalAccessException {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() throws IllegalAccessException {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() throws IllegalAccessException {
        return maxHeap.findMax();
    }
}
