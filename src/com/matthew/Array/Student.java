package com.matthew.Array;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/10 20:10
 * @Version 1.0
 */

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException {
        Array<Student> array = new Array<>();
        array.addLast(new Student("Alice",100));
        array.addLast(new Student("Bob",89));
        array.addLast(new Student("Charlie",23));

        System.out.println(array);
    }
}
