package com.matthew.LinkedList;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/16 17:58
 * @Version 1.0
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
