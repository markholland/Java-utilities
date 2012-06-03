package sumolari.utilities;

import sumolari.utilities.lists.ListStringLinked;
import sumolari.utilities.exceptions.ListOverflowException;

public class ListString
{
	/**
	 * Creates a new empty list
	 */
	public ListString() { }

	/**
	 * Returns whether this list is empty or not.
	 * @return True when it is empty, false when not.
	 */
	public boolean isEmpty() { return true; }

	/**
	 * Returns if it is found the given number in this list.
	 * @param x Number to be searched
	 * @return True if it is found, false if not.
	 */
	public boolean search( String x ) { return false; }

	/**
	 * Returns if it is found the given number in this list, after the current position of the cursor.
	 * @param x Number to be searched.
	 * @return True if it is found, false if not.
	 */
	public boolean searchNext( String x ) { return false; }

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
	public String get() { return null; }

	/**
	 * Removes the value at the current position from this list.
	 */
	public void remove() { }

	/**
	 * Removes the given value from this list.
	 * @param x Value to be removed.
	 * @return True when the value was found and removed, false when not.
	 */
	public boolean remove( String x )
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
	 * Inserts a new value in this list.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insert( String x ) throws ListOverflowException { }

	/**
	 * Inserts a new value in this list, after the position of the cursor.
	 * @param x Value to be inserted.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insertAfter( String x ) throws ListOverflowException
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
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insertWithNoDuplicates( String x, boolean before ) throws ListOverflowException
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
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushBack( String x ) throws ListOverflowException { }

	/**
	 * Inserts a new value at the first position of this list.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushFront( String x ) throws ListOverflowException
	{
		this.begin();
		this.insert( x ); 
	}

	/**
	 * Inserts a new value in order, assuming this list is ordered.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 * @note This method is NOT implemented in the implementation by means of array.
	 */
	public void pushInOrder( String x ) throws ListOverflowException { }

	/**
	 * Removes the frontmost item of this list.
	 * @return The first item of this list.
	 */
	public String popFront() 
	{
		this.begin();
		String value = this.get();
		this.remove();
		return value;
	}

	/**
	 * Removes the last item of this list.
	 * @return The last item of this list.
	 */
	public String popBack() 
	{
		this.end();
		String value = this.get();
		this.remove();
		return value;
	}

	/**
	 * Sorts the values stored at this list.
	 * @note This method is NOT implemented in the implementation by means of array.
	 */
	public void sortValues() { }

	/**
	 * Checks if this list is ascendently sorted
	 * @return True if it is ascendently sorted, false if not.
	 */
	public boolean checkIfAscendingOrder() { return false; }

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
	public ListString unionSet( ListString a ) throws ListOverflowException
	{
		return ListString.unionSet( a, this );
	}

	/**
	 * Returns the interseciton set of the current list and a given list.
	 * @param a Given list.
	 * @return The intersection set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public ListString intersectionSet( ListString a ) throws ListOverflowException
	{
		return ListString.intersectionSet( a, this );
	}

	/**
	 * Returns the union set of two given lists.
	 * @param a Given list.
	 * @param b Other given list.
	 * @return The union set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public static ListString unionSet( ListString a, ListString b ) throws ListOverflowException
	{
		a.sortValues();
		b.sortValues();

		ListString c = new ListStringLinked();

		a.begin();
		b.begin();

		while ( !a.isAtTheEnd() && !b.isAtTheEnd() )
		{
			String vA = a.get();
			String vB = b.get();

			if ( c.isEmpty() || c.get().compareTo( vA ) != 0 && c.get().compareTo( vB ) != 0 )
			{
				if ( vA.compareTo( vB ) < 0 )
				{
					c.pushBack( vA );
					a.next();
				}
				else if ( vA.compareTo( vB ) > 0 )
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
	public static ListString intersectionSet( ListString a, ListString b ) throws ListOverflowException
	{
		a.sortValues();
		b.sortValues();

		ListString c = new ListStringLinked();

		a.begin();
		b.begin();

		while ( !a.isAtTheEnd() && !b.isAtTheEnd() )
		{
			String vA = a.get();
			String vB = b.get();

			if ( vA.compareTo( vB ) < 0 )
			{
				a.next();
			}
			else if ( vA.compareTo( vB ) > 0 )
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