package com.matthew.Stack;

import com.matthew.Array.Array;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
//        ArrayStack<Integer> stack = new ArrayStack<>();
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);

        double time1 = testStack(new LinkedListStack<>(), 10000000);
        System.out.println("LinkedListStack : " + time1 + " s");
        double time2 = testStack(new ArrayStack<>(), 10000000);
        System.out.println("ArrayStack : " + time2 + " s");
    }

    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            try {
                stack.push(random.nextInt(Integer.MAX_VALUE));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < opCount; i++) {
            try {
                stack.peek();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0;

    }

}
