package com.matthew.SegmentTree;

/**
 * @Description TODO 通过空间换时间，数组容量为4*array.length，时间复杂度为logn，单纯数组时间为n
 * @Author Matthew
 * @Date 2019/9/25 20:29
 * @Version 1.0
 */

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger) {
        data = (E[])new Object[arr.length];
        /*for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }*/
        System.arraycopy(arr, 0, data, 0, arr.length);
        tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;
        buildSegmentTree(0,0,data.length-1);
    }

    //在treeIndex的位置创建表示区间[l...r]的线段树，递归
    private void buildSegmentTree(int treeIndex, int l, int r) {
        //终止条件
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;//防止l+r整形溢出
        //构建左右子树
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        //每个节点的值和业务相关，综合左右子树构建该节点的信息
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index) throws IllegalAccessException {
        if (index < 0 || index >= data.length) {
            throw new IllegalAccessException("Index is illegal.");
        }
        return data[index];
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL, int queryR) throws IllegalAccessException {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalAccessException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以treeID为根的线段树中[l...r]的范围里，搜索区域[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            return merger.merge(query(leftTreeIndex, l, mid, queryL, mid),query(rightTreeIndex, mid + 1, r, mid + 1, queryR));
        }
    }

    //将index位置的值，更新为e
    public void set(int index, E e) throws IllegalAccessException {
        if (index < 0 || index >= data.length) {
            throw new IllegalAccessException("Index is illegal");
        }
        data[index] = e;
        set(0,0,data.length-1,index);
    }
    //在以treeIndex为根的线段树中更新index的值为data[index]
    private void set(int treeIndex, int l, int r, int index) {
        if (l == r) {
            tree[treeIndex] = data[index];
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index <= mid) {
            set(leftTreeIndex, l, mid, index);
        } else {
            set(rightTreeIndex, mid + 1, r, index);
        }
        //更新父辈节点
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
