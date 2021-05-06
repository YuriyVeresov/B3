package com.javacourse.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinStack<ItemTypeT> implements Stack<ItemTypeT> {
    private static final int DEFAULT_CAPACITY = 10;
    private ItemTypeT[] valuesMin;
    private int size = 0;

    public ItemTypeT[] getValuesMin() {
        return valuesMin;
    }

    public void setValuesMin(ItemTypeT[] valuesMin) {
        this.valuesMin = valuesMin;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void push(ItemTypeT item) {
        if (size == 0) {
            this.valuesMin = (ItemTypeT[]) Array.newInstance(item.getClass(), DEFAULT_CAPACITY);
        }
        if (size == valuesMin.length) increaseCapacity();
        valuesMin[size++] = item;
    }

    @Override
    public ItemTypeT pop() {
        ItemTypeT top = valuesMin[--size];
        valuesMin[size] = null;
        return top;
    }

    @Override
    public ItemTypeT peek() {
        return valuesMin[size - 1];
    }


    /**
     * метод для увеличения ёмкости стека
     */
    private void increaseCapacity() {
        int newSize = (int) (size * 1.5) + 1;
        valuesMin = Arrays.copyOf(valuesMin, newSize);
    }
}
