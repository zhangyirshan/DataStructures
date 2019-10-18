package com.matthew.AVLTree;

import com.matthew.Set.Set;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/18 20:20
 * @Version 1.0
 */

public class AVLSet<E extends Comparable<E>> implements Set<E> {
    private AVLTree<E, Object> avlTree;

    public AVLSet() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e, null);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public int getSize() {
        return avlTree.size();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
