package queue;

public class Queue {
	private final static int MAX_SIZE = 1024;
	private Integer[] queue;
	private int tail;

	public Queue() {
		queue = new Integer[MAX_SIZE];
		tail = -1;
	}

	public void push(Integer element) {
		if (element == null) {
			throw new NullPointerException("Push of null item are not allowed!");
		}

		if (tail + 1 >= MAX_SIZE) {
			throw new MaximumQueueDimensionException("Stack can't contains more than " + MAX_SIZE + " elements!");
		}
		tail++;
		queue[tail] = element;
	}

	public Integer pop() {
		if (tail < 0) {
			throw new EmptyQueueException("Cannot pop on empty queue!");
		}
		Integer popped = queue[0];
		shiftLeft();
		return popped;
	}

	public int length() {
		return tail + 1;
	}

	private void shiftLeft() {
		if (tail >= 0) {
			System.arraycopy(queue, 1, queue, 0, tail);
		}
		tail--;
	}
}
