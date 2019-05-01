package stack;

import org.junit.Assert;
import org.junit.Test;
import java.util.EmptyStackException;

public class StackTest {

	@Test (expected = NullPointerException.class)
	public void pushNullElementTest() {
		Stack stack = new Stack();
		stack.push(null);
	}

	@Test (expected = MaximumStackDimensionException.class)
	public void stackOverflowTest() {
		Stack stack = new Stack();

		for (int i = 0; i < 1024; i++) {
			stack.push(i);
		}

		int extra = 0;
		stack.push(extra);
	}

	@Test (expected = EmptyStackException.class)
	public void popOnEmptyStackTest() {
		Stack stack = new Stack();
		stack.pop();
	}

	@Test
	public void popTest(){
		Stack stack = new Stack();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		Assert.assertEquals(stack.length(), 3);
		Assert.assertEquals(3, (int) stack.pop());

		Assert.assertEquals(stack.length(), 2);
		Assert.assertEquals(2, (int) stack.pop());

		Assert.assertEquals(stack.length(), 1);
		Assert.assertEquals(1, (int) stack.pop());

		Assert.assertEquals(stack.length(), 0);
	}

	@Test
	public void lengthOfEmptyStackTest() {
		Stack stack = new Stack();
		Assert.assertEquals(0, stack.length());
	}

	@Test
	public void lengthTest() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		Assert.assertEquals(stack.length(), 3);
	}
}
