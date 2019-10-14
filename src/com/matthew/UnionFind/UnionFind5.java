package com.matthew.UnionFind;

/**
 * @Description TODO Quick Union子孩子指向父节点，合并指向根节点，基于size的优化控制合并后的高度,
 *                  路径压缩
 * @Author Matthew
 * @Date 2019/10/14 17:46
 * @Version 1.0
 */

public class UnionFind5 implements UF {

    private int[] parent;//第i个元素指向哪个节点
    private int[] rank;   //rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind5(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
            //路径压缩
            parent[p] = parent[parent[p]];
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
        //根据两个元素所在树的元素个数不同判断合并方向
        //将rank小的集合合并到rank大的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }
}
