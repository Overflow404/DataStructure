package stack;

public class FixedIntegerStack implements Stack<Integer>{

	private final static int MAX_SIZE = 1024;

	private Integer[] stack;
	private int top;

	public FixedIntegerStack(){
		stack = new Integer[MAX_SIZE];
		top = -1;
	}

	public void push(Integer element) {
		if (element == null) {
			throw new NullPointerException("Push of null item are not allowed!");
		}

		if (top + 1 >= MAX_SIZE) {
			throw new StackOverflowException("FixedIntegerStack can't contains more than " + MAX_SIZE + " elements!");
		}

		top++;
		stack[top] = element;
	}

	public Integer pop() {
		if (top < 0) {
			throw new EmptyStackException("Cannot pop from an empty stack!");
		}

		Integer popped = stack[top];
		top--;
		return popped;
	}

	public int length() {
		return top + 1;
	}


}
