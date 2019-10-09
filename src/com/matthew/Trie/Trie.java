package com.matthew.Trie;

import java.util.TreeMap;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/9 22:03
 * @Version 1.0
 */

public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //获得Trie中存储的单词数量
    public int getSize() {
        return size;
    }

    //向Trie中添加一个新的单词word
    public void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        if (!current.isWord) {
            current.isWord = true;
            size++;
        }


    }

}
