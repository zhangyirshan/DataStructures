package com.matthew.Array;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/9 19:57
 * @Version 1.0
 */

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 容量大小
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return  元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * @return  容量大小
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断是否为空
     * @return  true为空，false为非空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e 新元素
     */
    public void addLast(E e) throws IllegalAccessException {
        add(size,e);
    }

    /**
     *  向所有元素前添加一个新元素
     * @param e 新元素
     */
    public void addFirst(E e) throws IllegalAccessException {
        add(0,e);
    }

    /**
     *  在第index个位置插入一个新的元素e
     * @param index 插入位置
     * @param e 新元素
     */
    public void add(int index,E e) throws IllegalAccessException {
        if (size == data.length) {
            throw new IllegalAccessException("Add Last failed。Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Add Last failed。Require index >= 0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     *  获取index索引位置的元素
     * @param index 索引
     * @return  索引对应的值
     */
    public E get(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     *  修改index索引位置的元素为e
     * @param index 索引
     * @param e 值
     */
    public void set(int index,E e) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     *  查看数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return  如果返回-1代表没有此元素
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index 要删除的位置
     * @return  删除元素的值
     */
    public E remove(int index) throws IllegalAccessException {
        if (index < 0 || index >= size) {
            throw new IllegalAccessException("Get failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak
        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     * @throws IllegalAccessException
     */
    public E removeFirst() throws IllegalAccessException {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     * @throws IllegalAccessException
     */
    public E removeLast() throws IllegalAccessException {
        return remove(size);
    }

    /**
     * 从数组中删除第一个元素元素e
     * @param e
     * @return 返回是否删除e
     * @throws IllegalAccessException
     */
    public boolean removeElement(E e) throws IllegalAccessException {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
