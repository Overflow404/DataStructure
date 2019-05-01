package stack;

import java.util.EmptyStackException;

public class Stack {

	private final static int MAX_SIZE = 1024;

	private Integer[] stack;
	private int top;

	public Stack(){
		stack = new Integer[MAX_SIZE];
		top = -1;
	}

	public void push(Integer element) {
		if (element == null) {
			throw new NullPointerException("Push of null item are not allowed!");
		}

		if (top + 1 >= MAX_SIZE) {
			throw new MaximumStackDimensionException("Stack can't contains more than " + MAX_SIZE + " elements!");
		}

		top++;
		stack[top] = element;
	}

	public Integer pop() {
		if (top < 0) {
			throw new EmptyStackException();
		}

		Integer popped = stack[top];
		top --;
		return popped;
	}

	public int length() {
		return top + 1;
	}


}
