package queue;

import org.junit.Assert;
import org.junit.Test;

public class FixedIntegerQueueTest {

	@Test (expected = NullPointerException.class)
	public void pushNullElement() {
		FixedIntegerQueue queue = new FixedIntegerQueue();
		queue.enqueue(null);
	}

	@Test (expected = QueueOverflowException.class)
	public void stackOverflowTest() {
		FixedIntegerQueue queue = new FixedIntegerQueue();

		for (int i = 0; i < 1024; i++) {
			queue.enqueue(i);
		}

		int extra = 0;
		queue.enqueue(extra);
	}

	@Test (expected = EmptyQueueException.class)
	public void popOnEmptyStackTest() {
		FixedIntegerQueue queue = new FixedIntegerQueue();
		queue.dequeue();
	}

	@Test
	public void lengthOfEmptyStackTest() {
		FixedIntegerQueue queue = new FixedIntegerQueue();
		Assert.assertEquals(0, queue.length());
	}

	@Test
	public void lengthTest() {
		FixedIntegerQueue queue = new FixedIntegerQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Assert.assertEquals(queue.length(), 3);
	}

	@Test
	public void popTest() {
		FixedIntegerQueue queue = new FixedIntegerQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		Assert.assertEquals((int) queue.dequeue(), 1);
		Assert.assertEquals(queue.length(), 2);

		Assert.assertEquals((int) queue.dequeue(), 2);
		Assert.assertEquals(queue.length(), 1);

		Assert.assertEquals((int) queue.dequeue(), 3);
		Assert.assertEquals(queue.length(), 0);
	}
}
