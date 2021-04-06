package com.javacourse.stack;

public interface Extremum<ItemTypeT> {

	/**
	 * Возвращает наименьший элемент из структуры данных.
	 *
	 * Если структура не содержит значений(стек пуст),
	 * то происходит бросок исключения RuntimeException
	 * с текстом сообщения "Empty Stack Exception"
	 */
	ItemTypeT min();

	/**
	 * возвращает наибольший элемент из структуры данных
	 *
	 * Если структура не содержит значений(стек пуст),
	 * то происходит бросок исключения RuntimeException
	 * с текстом сообщения "Empty Stack Exception"
	 */
	ItemTypeT max();
}
