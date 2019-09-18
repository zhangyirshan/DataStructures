package com.matthew.Queue;

import java.util.Random;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/12 20:20
 * @Version 1.0
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
//        ArrayQueue<Integer> queue = new ArrayQueue<>();
//        LoopQueue<Integer> queue = new LoopQueue<>();
        /*Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }*/
        int opCount = 100000;
        Queue<Integer> queue = new ArrayQueue<>();
        double time1 = testQueue(queue, opCount);
        System.out.println("ArrayQueue: " + time1 + "s");

        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(queue, opCount);
        System.out.println("LoopQueue: " + time2 + "s");

        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(queue, opCount);
        System.out.println("LinkedListQueue: " + time3 + "s");

    }

    public static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            try {
                queue.enqueue(random.nextInt(Integer.MAX_VALUE));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < opCount; i++) {
            try {
                queue.dequeue();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0;
    }
}
