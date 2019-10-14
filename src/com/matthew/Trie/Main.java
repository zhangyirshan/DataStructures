package com.matthew.Trie;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/10/9 22:03
 * @Version 1.0
 */

public class Main {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("hello word");
        System.out.println(trie.contains("hello word"));
    }
}
