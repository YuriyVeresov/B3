package com.javacourse.stack.stack;

import com.antkorwin.commonutils.gc.LeakDetector;
import com.javacourse.stack.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для проверки работы стека с разными типами данных
 */
public interface TypedStackTest extends UntypedStackProvider {


	@Test
	@DisplayName("стек не приводит к утечкам памяти")
	default void leak() {
		Stack<CustomItem> stack = getUntypedStack();
		CustomItem markerObject = new CustomItem(1234567);
		LeakDetector leakDetector = new LeakDetector(markerObject);
		stack.push(markerObject);
		stack.pop();
		markerObject = null;
		leakDetector.assertMemoryLeaksNotExist();
	}

	@Test
	@DisplayName("в стеке можно хранить строки")
	default void stringValue() {
		Stack<String> stack = getUntypedStack();
		stack.push("foo");
		stack.push("bar");
		assertThat(stack.pop()).isEqualTo("bar");
		assertThat(stack.pop()).isEqualTo("foo");
	}

	@Test
	@DisplayName("стек может работать с кастомными объектами")
	default void customTypeValue() {
		Stack<CustomItem> stack = getUntypedStack();
		stack.push(new CustomItem(1));
		stack.push(new CustomItem(2));
		assertThat(stack.pop().getVal()).isEqualTo(2);
		assertThat(stack.pop().getVal()).isEqualTo(1);
	}
}
