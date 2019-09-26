package com.matthew.MaxHeap;

import com.matthew.Array.Array;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/23 18:23
 * @Version 1.0
 */

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) throws IllegalAccessException {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    //返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) throws IllegalAccessException {
        if (index == 0) {
            throw new IllegalAccessException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) throws IllegalAccessException {
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    //上浮
    private void siftUp(int i) throws IllegalAccessException {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    //看堆中的最大元素
    public E findMax() throws IllegalAccessException {
        if (data.getSize() == 0) {
            throw new IllegalAccessException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() throws IllegalAccessException {
        E ret = findMax();
        //保证最大堆是完全二叉树
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //下沉
    private void siftDown(int i) throws IllegalAccessException {
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(i);
            }
            //data【j】是leftChild和rightChild中的最大值
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(i, j);
            i = j;
        }
    }

    //取出堆中的最大元素，并且替换成元素e
    public E replace(E e) throws IllegalAccessException {
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }


}
