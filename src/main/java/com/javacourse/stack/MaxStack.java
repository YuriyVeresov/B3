package com.javacourse.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxStack<ItemTypeT> implements Stack<ItemTypeT> {
    private static final int DEFAULT_CAPACITY = 10;
    private ItemTypeT[] valuesMax;
    private int size = 0;

    public ItemTypeT[] getValuesMax() {
        return valuesMax;
    }

    public void setValuesMax(ItemTypeT[] valuesMax) {
        this.valuesMax = valuesMax;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void push(ItemTypeT item) {
        if (size == 0) {
            this.valuesMax = (ItemTypeT[]) Array.newInstance(item.getClass(), DEFAULT_CAPACITY);
        }
        if (size == valuesMax.length) increaseCapacity();
        valuesMax[size++] = item;
    }

    @Override
    public ItemTypeT pop() {
        ItemTypeT top = valuesMax[--size];
        valuesMax[size] = null;
        return top;
    }

    @Override
    public ItemTypeT peek() {
        return valuesMax[size - 1];
    }


    /**
     * метод для увеличения ёмкости стека
     */
    private void increaseCapacity() {
        int newSize = (int) (size * 1.5) + 1;
        valuesMax = Arrays.copyOf(valuesMax, newSize);
    }
}

