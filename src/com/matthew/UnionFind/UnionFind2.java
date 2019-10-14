package com.matthew.UnionFind;

/**
 * @Description TODO Quick Union子孩子指向父节点，合并指向根节点
 * @Author Matthew
 * @Date 2019/10/14 17:46
 * @Version 1.0
 */

public class UnionFind2 implements UF {

    private int[] parent;//第i个元素指向哪个节点

    public UnionFind2(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找过程，查找元素p所对应的集合编号
    //O(h)复杂度，h为树的高度
    private int find(int p){
        if (p < 0 || p >= parent.length) {
            try {
                throw new IllegalAccessException("p is out of bound.");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    //查看元素p和元素q是否所属一个集合
    //O（h）复杂度，h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合
    //O（h）复杂度，h为树得高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}
