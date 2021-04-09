package com.javacourse.stack;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Реализация стека на базе массива объектов,
 * с возвомжностью поиска наименьшего/наибольшего значения
 */
public class ArrayStack<ItemTypeT extends Comparable<ItemTypeT>> implements ExtremumStack<ItemTypeT> {
    private static final int DEFAULT_CAPACITY = 10;
    private ItemTypeT[] values;
    private int size = -1;
    private Stack<ItemTypeT> maxValues;
    private Stack<ItemTypeT> minValues;

    /**
     * Конструктор без аргументов должен создаавать валидный стек
     */
    public ArrayStack() {
        this.maxValues = new Stack<>();
        this.minValues = new Stack<>();
    }

    @Override
    public void push(ItemTypeT item) {
        if (isEmpty()) {
            this.maxValues.push(item);
            this.minValues.push(item);
            this.values = (ItemTypeT[]) Array.newInstance(item.getClass(), DEFAULT_CAPACITY);
        }
        size++;
        if (size == values.length) increaseCapacity();
        values[size] = item;

        if (this.size == 0) return;
        pushOnlyMinValues(item);
        pushOnlyMaxValues(item);
    }

    /**
     * пушим все встречающиеся максы
     */
    private void pushOnlyMaxValues(ItemTypeT item) {
        if (item != null && maxValues.peek().compareTo(item) <= 0) {
            maxValues.push(item);
        }
    }

    /**
     * пушим все встречающиеся минимумы
     */
    private void pushOnlyMinValues(ItemTypeT item) {
        if (item != null && minValues.peek().compareTo(item) >= 0) {
            minValues.push(item);
        }
    }

    @Override
    public ItemTypeT pop() {
        if (isEmpty()) throw new RuntimeException("Empty Stack Exception");
        ItemTypeT top = values[size];
        values[size--] = null;
        if (top == maxValues.peek()) maxValues.pop();
        if (top == minValues.peek()) minValues.pop();
        return top;
    }

    @Override
    public ItemTypeT peek() {
        if (isEmpty()) throw new RuntimeException("Empty Stack Exception");
        return values[size];
    }

    @Override
    public ItemTypeT min() {
        if (isEmpty()) throw new RuntimeException("Empty Stack Exception");
        return this.minValues.peek();
    }

    @Override
    public ItemTypeT max() {
        if (isEmpty()) throw new RuntimeException("Empty Stack Exception");
        return this.maxValues.peek();
    }

    public boolean isEmpty() {
        return size == -1;
    }

    /**
     * увеличиваем размер стека
     */
    private void increaseCapacity() {
        int newSize = size + (int) (size * 1.5) + 1;
        values = Arrays.copyOf(values, newSize);
    }
}