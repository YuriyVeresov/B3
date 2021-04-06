package com.javacourse.stack;

/**
 * Реализация стека на базе массива объектов,
 * с возвомжностью поиска наименьшего/наибольшего значения
 */
public class ArrayStack<ItemTypeT> implements ExtremumStack<ItemTypeT> {

	/**
	 * Конструктор без аргументов должен создаавать валидный стек
	 */
	public ArrayStack() {

	}

	@Override
	public void push(ItemTypeT item) {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}

	@Override
	public ItemTypeT pop() {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}

	@Override
	public ItemTypeT peek() {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}

	@Override
	public ItemTypeT min() {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}

	@Override
	public ItemTypeT max() {
		// TODO: замените тело метода на полноценную реализацию
		throw new RuntimeException("Method not implemented");
	}
}
