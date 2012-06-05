package sumolari.utilities;

import sumolari.utilities.exceptions.StackOverflowException;

/**
 * This class represents a Stack (Last-In First-Out structure) of objects of class Object.
 * This kind of structures can be implemented in different ways, so this class is just a wrapper that can be use
 * regardless which implementation is used internally.
 * This class should not be used to create new objects: it should be used to specify datatypes of parameters and
 * work with Stacks of objects in an abstract way.
 */
public class StackObject
{
	/**
	 * Pushes a new item to the top of the stack.
	 * @param value Item to be pushed.
	 */
	public void push( Object value ) throws StackOverflowException { }

	/**
	 * Consults and extracts the topmost item of the stack.
	 * @return The topmost item of the stack.
	 */
	public Object pop() { return 0; }

	/**
	 * Consults the topmost item of the stack.
	 * @return The topmost item of the stack.
	 */
	public Object top() { return 0; }

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