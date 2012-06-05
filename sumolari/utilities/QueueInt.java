package sumolari.utilities;

import sumolari.utilities.exceptions.QueueOverflowException;

/**
 * This class represents a Queue (First-In First-Out structure) of integer numbers (int).
 * This kind of structures can be implemented in different ways, so this class is just a wrapper that can be use
 * regardless which implementation is used internally.
 * This class should not be used to create new objects: it should be used to specify datatypes of parameters and
 * work with Queues of integer numbers in an abstract way.
 */
public class QueueInt
{
	/**
	 * Adds a new item to the queue.
	 */
	public void enqueue( int x ) throws QueueOverflowException { }

	/**
	 * Returns the first item of the queue and removes it from the queue.
	 * @return First item added to the queue.
	 */
	public int dequeue() { return 0; }

	/**
	 * Gets the first item of the queue.
	 * @return First item added to the queue.
	 */
	public int first() { return 0; }

	/**
	 * Returns wheter the queue os empty or not.
	 * @return True if it is empty, false if not.
	 */
	public boolean isEmpty() { return true; }

	/**
	 * Returns how many elements has the queue.
	 * @return Number of elements in the queue.
	 */
	public int size() { return 0; }
}