package com.javacourse;


import com.javacourse.stack.ArrayStack;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(2);
        stack.push(3);
        stack.push(0);
        stack.push(1);
        stack.push(10);
        stack.push(3);
        stack.push(2);
        stack.push(10);
        stack.push(0);

        System.out.println(stack);
    }
}
