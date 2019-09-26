package com.matthew.SegmentTree;

/**
 * @Description TODO 线段树测试
 * @Author Matthew
 * @Date 2019/9/25 20:55
 * @Version 1.0
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums,(Integer a,Integer b)->{return a + b;});
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums,(a,b)->a + b);
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0, 2));
        segmentTree.set(2, 0);
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0,2));
    }
}
