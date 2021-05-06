package com.javacourse;


import com.javacourse.stack.ArrayStack;


public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 1_000_000; i++) {
            stack.push(i);
        }

        stack.trim();

        while (!stack.isEmpty()) {
            stack.pop();
        }

    }
}
