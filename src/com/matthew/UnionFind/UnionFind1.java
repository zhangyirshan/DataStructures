package com.matthew.UnionFind;

/**
 * @Description TODO Quick find
 * @Author Matthew
 * @Date 2019/10/11 19:29
 * @Version 1.0
 */

public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查找元素p所对应的集合编号
    public int find(int p) throws IllegalAccessException {
        if (p < 0 || p > id.length) {
            throw new IllegalAccessException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q){
        try {
            return find(p)==find(q);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void unionElements(int p, int q) {
        try {
            int pID = find(p);
            int qID = find(q);
            if (pID == qID) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    id[i] = qID;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
