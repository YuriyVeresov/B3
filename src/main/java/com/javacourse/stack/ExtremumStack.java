package com.javacourse.stack;

/**
 * интерфейс стека с возможностью поиска наименьшего и наибольшего значения
 */
public interface ExtremumStack<ItemTypeT> extends Stack<ItemTypeT>,
                                                  Extremum<ItemTypeT> {

}
