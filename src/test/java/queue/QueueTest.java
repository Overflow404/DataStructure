package queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

	@Test (expected = NullPointerException.class)
	public void pushNullElement() {
		Queue queue = new Queue();
		queue.push(null);
	}

	@Test (expected = MaximumQueueDimensionException.class)
	public void stackOverflowTest() {
		Queue queue = new Queue();

		for (int i = 0; i < 1024; i++) {
			queue.push(i);
		}

		int extra = 0;
		queue.push(extra);
	}

	@Test (expected = EmptyQueueException.class)
	public void popOnEmptyStackTest() {
		Queue queue = new Queue();
		queue.pop();
	}

	@Test
	public void lengthOfEmptyStackTest() {
		Queue queue = new Queue();
		Assert.assertEquals(0, queue.length());
	}

	@Test
	public void lengthTest() {
		Queue queue = new Queue();
		queue.push(1);
		queue.push(2);
		queue.push(3);

		Assert.assertEquals(queue.length(), 3);
	}

	@Test
	public void popTest() {
		Queue queue = new Queue();
		queue.push(1);
		queue.push(2);
		queue.push(3);

		Assert.assertEquals((int) queue.pop(), 1);
		Assert.assertEquals(queue.length(), 2);

		Assert.assertEquals((int) queue.pop(), 2);
		Assert.assertEquals(queue.length(), 1);

		Assert.assertEquals((int) queue.pop(), 3);
		Assert.assertEquals(queue.length(), 0);
	}
}
