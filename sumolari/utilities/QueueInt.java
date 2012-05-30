package sumolari.utilities;

import sumolari.utilities.exceptions.QueueOverflowException;

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