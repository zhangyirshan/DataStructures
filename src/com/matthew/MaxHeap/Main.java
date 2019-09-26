package com.matthew.MaxHeap;

import java.util.Random;

/**
 * @Description TODO 最大堆，使用自己实现的数组
 * @Author Matthew
 * @Date 2019/9/23 18:23
 * @Version 1.0
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        int n = 30000000;
        int[] a = new int[]{2,2};
        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, true);
        double time2 = testHeap(testData, false);
        System.out.println("time1 : " + time1);
        System.out.println("time2 : " + time2);


    }

    private static double testHeap(Integer[] testData, boolean isHeapify) throws IllegalAccessException {
        long startTime = System.currentTimeMillis();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer num : testData) {
                maxHeap.add(num);
            }
        }

        long endTime = System.currentTimeMillis();

        return (endTime - startTime) / 1000.0;
    }
}
