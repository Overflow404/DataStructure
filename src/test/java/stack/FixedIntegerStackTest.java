package stack;

import org.junit.Assert;
import org.junit.Test;

public class FixedIntegerStackTest {

	@Test (expected = NullPointerException.class)
	public void pushNullElementTest() {
		FixedIntegerStack stack = new FixedIntegerStack();
		stack.push(null);
	}

	@Test (expected = StackOverflowException.class)
	public void stackOverflowTest() {
		FixedIntegerStack stack = new FixedIntegerStack();

		for (int i = 0; i < 1024; i++) {
			stack.push(i);
		}

		int extra = 0;
		stack.push(extra);
	}

	@Test (expected = EmptyStackException.class)
	public void popOnEmptyStackTest() {
		FixedIntegerStack stack = new FixedIntegerStack();
		stack.pop();
	}

	@Test
	public void popTest(){
		FixedIntegerStack stack = new FixedIntegerStack();

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
		FixedIntegerStack stack = new FixedIntegerStack();
		Assert.assertEquals(0, stack.length());
	}

	@Test
	public void lengthTest() {
		FixedIntegerStack stack = new FixedIntegerStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		Assert.assertEquals(stack.length(), 3);
	}
}
