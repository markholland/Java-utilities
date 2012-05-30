package sumolari.utilities;

import sumolari.utilities.exceptions.ListOverflowException;

public class ListInt
{
	/**
	 * Creates a new empty list
	 */
	public ListInt() { }

	/**
	 * Returns whether the list is empty or not.
	 * @return True when it is empty, false when not.
	 */
	public boolean isEmpty() { return true; }

	/**
	 * Returns if it is found the given number in the list.
	 * @param x Number to be searched
	 * @return True if it is found, false if not.
	 */
	public boolean search( int x ) { return false; }

	/**
	 * Returns if it is found the given number in the list, after the current position of the cursor.
	 * @param x Number to be searched.
	 * @return True if it is found, false if not.
	 */
	public boolean searchNext( int x ) { return false; }

	/**
	 * Returns the number of items in the list.
	 * @return Number of items in the list.
	 */
	public int size() { return 0; }

	/**
	 * Moves the cursor to the first position.
	 */
	public void begin() { }

	/**
	 * Moves the cursor to the last position.
	 */
	public void end() { }

	/**
	 * Moves the cursor to the following position.
	 */
	public void next() { }

	/**
	 * Moves the cursor to the previous position.
	 */
	public void previous() { }

	/**
	 * Returns the value at the current position.
	 * @return Value stored at the current position.
	 */
	public int get() { return -1; }

	/**
	 * Removes the value at the current position from the list.
	 */
	public void remove() { }

	/**
	 * Inserts a new value in the list.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insert( int x ) throws ListOverflowException { }

	/**
	 * Inserts a new value at the last position of the list.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushBack( int x ) throws ListOverflowException { }

	/**
	 * Inserts a new value at the first position of the list.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushFront( int x ) throws ListOverflowException
	{
		this.begin();
		this.insert( x ); 
	}

	/**
	 * Inserts a new value in order, assuming the list is ordered.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 * @note This method is NOT implemented in the implementation by means of array.
	 */
	public void pushInOrder( int x ) throws ListOverflowException { }

	/**
	 * Removes the frontmost item of the list.
	 * @return The first item of the list.
	 */
	public int popFront() 
	{
		this.begin();
		int value = this.get();
		this.remove();
		return value;
	}

	/**
	 * Removes the last item of the list.
	 * @return The last item of the list.
	 */
	public int popBack() 
	{
		this.end();
		int value = this.get();
		this.remove();
		return value;
	}

	/**
	 * Sorts the values stored at the list.
	 * @note This method is NOT implemented in the implementation by means of array.
	 */
	public void sortValues() { }

	/**
	 * Resets the list.
	 */
	public void clear() { }
}