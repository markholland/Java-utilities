package sumolari.utilities;

import sumolari.utilities.exceptions.ListOverflowException;
import sumolari.utilities.lists.ListIntLinked;

public class ListInt
{
	/**
	 * Creates a new empty list
	 */
	public ListInt() { }

	/**
	 * Returns whether this list is empty or not.
	 * @return True when it is empty, false when not.
	 */
	public boolean isEmpty() { return true; }

	/**
	 * Returns if it is found the given number in this list, and moves the internal cursor to it.
	 * @param x Number to be searched
	 * @return True if it is found, false if not.
	 */
	public boolean search( int x ) { return false; }

	/**
	 * Returns if it is found the given number in this list, after the current position of the cursor, and moves the internal cursor to it.
	 * @param x Number to be searched.
	 * @return True if it is found, false if not.
	 */
	public boolean searchNext( int x ) { return false; }

	/**
	 * Returns the number of items in this list.
	 * @return Number of items in this list.
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
	 * Returns whether the cursor is at the end of this list or not.
	 * @return True when it is as the end, false when not.
	 */
	public boolean isAtTheEnd() { return true; }

	/**
	 * Returns the value at the current position.
	 * @return Value stored at the current position.
	 */
	public int get() { return -1; }

	/**
	 * Removes the value at the current position from this list.
	 */
	public void remove() { }

	/**
	 * Removes the given value from this list.
	 * @param x Value to be removed.
	 * @return True when the value was found and removed, false when not.
	 */
	public boolean remove( int x )
	{
		if ( this.search( x ) )
		{
			remove();
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Inserts a new value in this list, before the position of the cursor.
	 * @param x Value to be inserted.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insert( int x ) throws ListOverflowException { }

	/**
	 * Inserts a new value in this list, after the position of the cursor.
	 * @param x Value to be inserted.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insertAfter( int x ) throws ListOverflowException
	{
		if ( this.isAtTheEnd() )
		{
			this.pushBack( x );
		}
		else
		{
			this.next();
			this.insert( x );
		}
	}

	/**
	 * Inserts a new value in this list if it didn't exist yet.
	 * @param x Value to be inserted.
	 * @param before If true, the value is inserted at the beginning of this list, if false it is inserted at the end.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insertWithNoDuplicates( int x, boolean before ) throws ListOverflowException
	{
		if ( !this.search( x ) )
		{
			if ( before )
			{
				this.pushFront( x );
			}
			else
			{
				this.pushBack( x );
			}
		}
	}

	/**
	 * Inserts a new value at the last position of this list.
	 * @param x Value to be inserted.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushBack( int x ) throws ListOverflowException { }

	/**
	 * Inserts a new value at the first position of this list.
	 * @param x Value to be inserted.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushFront( int x ) throws ListOverflowException
	{
		this.begin();
		this.insert( x ); 
	}

	/**
	 * Inserts a new value in order, assuming this list is ordered.
	 * @param x Value to be inserted.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushInOrder( int x ) throws ListOverflowException { }

	/**
	 * Removes the frontmost item of this list.
	 * @return The first item of this list.
	 */
	public int popFront() 
	{
		this.begin();
		int value = this.get();
		this.remove();
		return value;
	}

	/**
	 * Removes the last item of this list.
	 * @return The last item of this list.
	 */
	public int popBack() 
	{
		this.end();
		int value = this.get();
		this.remove();
		return value;
	}

	/**
	 * Sorts the values stored at this list.
	 */
	public void sortValues() { }

	/**
	 * Resets this list.
	 */
	public void clear() { }

	/**
	 * Returns the union set of the current list and a given list.
	 * @param a Given list.
	 * @return The union set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public ListInt unionSet( ListInt a ) throws ListOverflowException
	{
		return ListInt.unionSet( a, this );
	}

	/**
	 * Returns the interseciton set of the current list and a given list.
	 * @param a Given list.
	 * @return The intersection set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public ListInt intersectionSet( ListInt a ) throws ListOverflowException
	{
		return ListInt.intersectionSet( a, this );
	}

	/**
	 * Returns the union set of two given lists.
	 * @param a Given list.
	 * @param b Other given list.
	 * @return The union set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public static ListInt unionSet( ListInt a, ListInt b ) throws ListOverflowException
	{
		a.sortValues();
		b.sortValues();

		ListInt c = new ListIntLinked();

		a.begin();
		b.begin();

		while ( !a.isAtTheEnd() && !b.isAtTheEnd() )
		{
			int vA = a.get();
			int vB = b.get();

			if ( c.isEmpty() || c.get() != vA && c.get() != vB )
			{
				if ( vA < vB )
				{
					c.pushBack( vA );
					a.next();
				}
				else if ( vA > vB )
				{
					c.pushBack( vB );
					b.next();
				}
				else
				{
					c.pushBack( vA );
					a.next();
					b.next();
				}
			}

		}

		while ( !a.isAtTheEnd() )
		{
			c.pushBack( a.get() );
			a.next();
		}

		while ( !b.isAtTheEnd() )
		{
			c.pushBack( b.get() );
			b.next();
		}

		return c;
	}

	/**
	 * Returns the intersection set of two given lists.
	 * @param a Given list.
	 * @param b Other given list.
	 * @return The intersection set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public static ListInt intersectionSet( ListInt a, ListInt b ) throws ListOverflowException
	{
		a.sortValues();
		b.sortValues();

		ListInt c = new ListIntLinked();

		a.begin();
		b.begin();

		while ( !a.isAtTheEnd() && !b.isAtTheEnd() )
		{
			int vA = a.get();
			int vB = b.get();

			if ( vA < vB )
			{
				a.next();
			}
			else if ( vA > vB )
			{
				b.next();
			}
			else
			{
				if ( c.isEmpty() || vA != c.get() )
				{
					c.pushBack( vA );
				}
				a.next();
				b.next();
			}
		}

		return c;
	}
}