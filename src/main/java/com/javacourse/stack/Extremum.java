package com.javacourse.stack;

public interface Extremum<ItemTypeT> {

	/**
	 * возвращает наименьший элемент из структуры данных
	 */
	ItemTypeT min();

	/**
	 * возвращает наибольший элемент из структуры данных
	 */
	ItemTypeT max();
}
