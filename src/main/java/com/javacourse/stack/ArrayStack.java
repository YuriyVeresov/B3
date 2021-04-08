package com.javacourse.stack;

import java.util.Arrays;

/**
 * Реализация стека на базе массива объектов,
 * с возвомжностью поиска наименьшего/наибольшего значения
 */
public class ArrayStack<ItemTypeT> implements ExtremumStack<ItemTypeT> {
    private static final int DEFAULT_CAPACITY = 10;
    private ItemTypeT[] values;
    private int currentSize;
    private int size;

    /**
     * Конструктор без аргументов должен создаавать валидный стек
     */
    public ArrayStack() {
        this.values = (ItemTypeT[]) new Object[DEFAULT_CAPACITY];
        this.currentSize = -1;
        this.size = values.length;
    }

    @Override
    public void push(ItemTypeT item) {
        if (size - currentSize == 1) {
            values = Arrays.copyOf(values, (int) (size * 1.5) + 1);
            size = values.length;
        }
        values[++currentSize] = item;
    }

    @Override
    public ItemTypeT pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Stack Exception");
        }
        return values[currentSize--];
    }

    @Override
    public ItemTypeT peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Stack Exception");
        }
        return values[currentSize];
    }

    @Override
    public ItemTypeT min() {
        return (ItemTypeT) new MinAndMax<>().min();
    }

    @Override
    public ItemTypeT max() {
        return (ItemTypeT) new MinAndMax<>().max();
    }

    public boolean isEmpty() {
        return currentSize == -1;
    }

    public static class MinAndMax<ItemTypeT extends Comparable<ItemTypeT>> extends ArrayStack<ItemTypeT> {
        private ArrayStack<ItemTypeT> maxValues;
        private ArrayStack<ItemTypeT> minValues;

        public MinAndMax() {
            this.maxValues = new ArrayStack<>();
            this.minValues = new ArrayStack<>();
        }

        /**
         * push only those values, that are greater than previous ones
         */
        private void pushMax(ItemTypeT item) {
            if (!maxValues.isEmpty() && maxValues.peek().compareTo(item) > 0) {
                item = maxValues.pop();
            }
            maxValues.push(item);
        }

        /**
         * push only those values that are less than the previous ones
         */
        private void pushMin(ItemTypeT item) {
            if (!minValues.isEmpty() && minValues.peek().compareTo(item) < 0) {
                item = minValues.pop();
            }
            minValues.push(item);
        }

        @Override
        public ItemTypeT min() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Stack Exception");
            }
            ItemTypeT minimum = minValues.peek();
            if (!super.isEmpty() && minimum == peek()) {
                minValues.pop();
                minimum = peek();
            }
            return minimum;
        }

        @Override
        public ItemTypeT max() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Stack Exception");
            }
            ItemTypeT maximum = maxValues.peek();
            if (!maxValues.isEmpty() && maximum == peek()) {
                maxValues.pop();
                maximum = peek();
            }
            return maximum;
        }

        @Override
        public void push(ItemTypeT item) {
            super.push(item);
            pushMax(item);
            pushMin(item);
        }

        @Override
        public ItemTypeT pop() {
            return super.pop();
        }
    }
}
