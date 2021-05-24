package com.javacourse;


import com.javacourse.stack.ArrayStack;


public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayStack<Integer> stack = new ArrayStack<>();


        for (int i = 0; i < 1_000_000; i++) {
            stack.push(i);
        }

        System.out.println(stack.getValues().length);

        while (!stack.isEmpty()) stack.pop();

        System.out.println(stack.getValues().length);

    }
}
