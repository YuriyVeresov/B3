package com.javacourse.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxStack<ItemTypeT> implements Stack<ItemTypeT>{
    private static final int DEFAULT_CAPACITY = 10;
    private ItemTypeT[] values;
    private int size = 0;

    @Override
    public void push(ItemTypeT item) {
        if (size == 0) {
            this.values = (ItemTypeT[]) Array.newInstance(item.getClass(), DEFAULT_CAPACITY);
        }
        if (size == values.length) increaseCapacity();
        values[size++] = item;
    }

    @Override
    public ItemTypeT pop() {
        ItemTypeT top = values[--size];
        values[size] = null;
        return top;
    }

    @Override
    public ItemTypeT peek() {
        return values[size - 1];
    }


    /**
     * метод для увеличения ёмкости стека
     */
    private void increaseCapacity() {
        int newSize = size + (int) (size * 1.5) + 1;
        values = Arrays.copyOf(values, newSize);
    }
}

