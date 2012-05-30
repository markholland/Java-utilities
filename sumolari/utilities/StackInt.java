package sumolari.utilities;

import sumolari.utilities.exceptions.StackOverflowException;

public class StackInt
{
	/**
	 * Pushes a new item to the top of the stack.
	 * @param value Item to be pushed.
	 */
	public void push( int value ) throws StackOverflowException { }

	/**
	 * Consults and extracts the topmost item of the stack.
	 * @return The topmost item of the stack.
	 */
	public int pop() { return 0; }

	/**
	 * Consults the topmost item of the stack.
	 * @return The topmost item of the stack.
	 */
	public int top() { return 0; }

	/**
	 * Returns whether the stack is empty or not.
	 * @return True when empty, false when not.
	 */
	public boolean isEmpty() { return true; }

	/**
	 * Returns the number of items in the stack.
	 * @return Count of items in the stack.
	 */
	public int size() { return 0; }

	@Override public String toString() { return "{ }"; }

}