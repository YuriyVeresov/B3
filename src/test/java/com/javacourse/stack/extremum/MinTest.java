package com.javacourse.stack.extremum;

import com.javacourse.stack.ExtremumStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public interface MinTest extends ExtremumStackProvider {

	@Test
	@DisplayName("min() комплексный тест")
	default void minAfterSequenceOfPop() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(3);
		stack.push(2);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(1);
		stack.push(9);
		assertThat(stack.min()).isEqualTo(1);
		stack.pop();
		assertThat(stack.min()).isEqualTo(1);
		stack.pop();
		assertThat(stack.min()).isEqualTo(2);
		stack.pop();
		assertThat(stack.min()).isEqualTo(2);
		stack.pop();
		assertThat(stack.min()).isEqualTo(2);
		stack.pop();
		assertThat(stack.min()).isEqualTo(2);
		stack.pop();
		assertThat(stack.min()).isEqualTo(3);
		stack.pop();
		assertThrows(RuntimeException.class, stack::pop);
	}

	@Test
	@DisplayName("min(3, 2, 8, 1, 9) = 1")
	default void minTest() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(3);
		stack.push(2);
		stack.push(8);
		stack.push(1);
		stack.push(9);
		assertThat(stack.min()).isEqualTo(1);
	}

	@Test
	@DisplayName("min(0, 2, 8, 1, 9) = 0")
	default void minFirstElem() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(0);
		stack.push(2);
		stack.push(8);
		stack.push(1);
		stack.push(9);
		assertThat(stack.min()).isEqualTo(0);
	}

	@Test
	@DisplayName("min(7, 2, 8, 1, 0) = 0")
	default void minLastElem() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(7);
		stack.push(2);
		stack.push(8);
		stack.push(1);
		stack.push(0);
		assertThat(stack.min()).isEqualTo(0);
	}

	@Test
	@DisplayName("min() на пустом стеке приводит к исключению")
	default void minOnEmptyStack() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		RuntimeException exc = assertThrows(RuntimeException.class, stack::min);
		assertThat(exc).hasMessage("Empty Stack Exception");
	}
}
