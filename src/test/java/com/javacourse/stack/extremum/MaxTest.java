package com.javacourse.stack.extremum;

import com.javacourse.stack.ArrayStack;
import com.javacourse.stack.ExtremumStack;
import com.javacourse.stack.stack.IntegerStackProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public interface MaxTest extends ExtremumStackProvider {

	@Test
	@DisplayName("max() комплексный тест")
	default void maxAfterSequenceOfPop() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(2);
		stack.push(3);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(1);
		stack.push(9);
		assertThat(stack.max()).isEqualTo(9);
		stack.pop();
		assertThat(stack.max()).isEqualTo(8);
		stack.pop();
		assertThat(stack.max()).isEqualTo(8);
		stack.pop();
		assertThat(stack.max()).isEqualTo(8);
		stack.pop();
		assertThat(stack.max()).isEqualTo(8);
		stack.pop();
		assertThat(stack.max()).isEqualTo(3);
		stack.pop();
		assertThat(stack.max()).isEqualTo(2);
		stack.pop();
		assertThrows(RuntimeException.class, stack::pop);
	}

	@Test
	@DisplayName("max(3, 2, 8, 1, 6) = 8")
	default void max() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(3);
		stack.push(2);
		stack.push(8);
		stack.push(1);
		stack.push(6);
		assertThat(stack.max()).isEqualTo(8);
	}

	@Test
	@DisplayName("min(0, 2, 8, 1, 9) = 9")
	default void maxLastElem() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(0);
		stack.push(2);
		stack.push(8);
		stack.push(1);
		stack.push(9);
		assertThat(stack.max()).isEqualTo(9);
	}

	@Test
	@DisplayName("max(7, 2, 5, 1, 0) = 7")
	default void maxFirstElem() {
		ExtremumStack<Integer> stack = getExtremumStackImpl();
		stack.push(7);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(0);
		assertThat(stack.max()).isEqualTo(7);
	}
}
