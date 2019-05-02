package queue;

public class FixedIntegerQueue implements Queue<Integer>{
	private final static int MAX_SIZE = 1024;

	private Integer[] queue;
	private int top;

	public FixedIntegerQueue() {
		queue = new Integer[MAX_SIZE];
		top = -1;
	}

	public void enqueue(Integer element) {
		if (element == null) {
			throw new NullPointerException("Push of null item are not allowed!");
		}

		if (top + 1 >= MAX_SIZE) {
			throw new QueueOverflowException("FixedIntegerQueue can't contains more than " + MAX_SIZE + " elements!");
		}
		top++;
		queue[top] = element;
	}

	public Integer dequeue() {
		if (top < 0) {
			throw new EmptyQueueException("Cannot dequeue from an empty queue!");
		}
		Integer popped = queue[0];
		shiftLeft();
		return popped;
	}

	public int length() {
		return top + 1;
	}

	//TODO Maybe batch shift every x elements.
	private void shiftLeft() {
		if (top >= 0) {
			System.arraycopy(queue, 1, queue, 0, top);
		}
		top--;
	}
}
