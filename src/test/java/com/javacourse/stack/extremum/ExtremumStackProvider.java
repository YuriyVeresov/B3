package com.javacourse.stack.extremum;

import com.javacourse.stack.ExtremumStack;

public interface ExtremumStackProvider {

	ExtremumStack<Integer> getExtremumStackImpl();
}
