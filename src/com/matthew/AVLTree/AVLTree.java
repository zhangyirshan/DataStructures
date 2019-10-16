package com.matthew.AVLTree;

import java.util.ArrayList;

/**
 * @Description TODO 完善二分搜索树实现自平衡
 * @Author Matthew
 * @Date 2019/10/15 18:27
 * @Version 1.0
 */

public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }

    }

    private Node root;
    private int size;
    public AVLTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //判断二叉树是否是一颗平衡树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    //判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);

        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    //判断二叉树是否是一颗二分搜索树
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    //中序遍历
    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    //获得节点node的高度
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    //获得节点node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //向二分搜索树中添加新的元素（key，value）
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //向以node为根的二分搜索树中插入元素（key,value)，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        //更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("unbalanced : " +balanceFactor);
        }
        //平衡维护
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        //RR
        if (balanceFactor < 1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            //左子树左旋为LL
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
            //RL
        if (balanceFactor < 1 && getBalanceFactor(node.right) > 0) {
            //右子树右旋为RR
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    //LL
    //对节点y进行向右旋转操作，返回旋转后新的根节点x
    //          y                       x
    //        /  \                    /   \
    //       x   T4     向右旋转（y） z     y
    //      / \       ------------> / \   / \
    //     z  T3                   T1 T2 T3 T4
    //    / \
    //   T1 T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        //向右旋转
        x.right = y;
        y.left = T3;
        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
        return x;
    }

    //RR
    //对节点y进行向左旋转操作，返回旋转后新的根节点x
    //          y                       x
    //        /  \                    /   \
    //       T1   x     向右旋转（y） y     z
    //           / \ ------------> / \   / \
    //          T2  z             T1 T2 T3 T4
    //             / \
    //            T1 T2
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        //向左旋转
        x.left = y;
        y.right = T2;
        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
        return x;
    }


}
