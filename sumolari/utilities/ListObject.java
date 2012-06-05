package sumolari.utilities;

import sumolari.utilities.lists.ListObjectLinked;
import sumolari.utilities.exceptions.ListOverflowException;

/**
 * This class represents a List of objects of class Object.
 * This kind of structures can be implemented in different ways, so this class is just a wrapper that can be use
 * regardless which implementation is used internally.
 * This class should not be used to create new objects: it should be used to specify datatypes of parameters and
 * work with Lists of Object in an abstract way.
 */
public class ListObject
{
	/**
	 * Creates a new empty list
	 */
	public ListObject() { }

	/**
	 * Returns whether this list is empty or not.
	 * @return True when it is empty, false when not.
	 */
	public boolean isEmpty() { return true; }

	/**
	 * Returns if it is found the given object in this list.
	 * @param x Object to be searched
	 * @return True if it is found, false if not.
	 */
	public boolean search( Object x ) { return false; }

	/**
	 * Returns if it is found the given object in this list, after the current position of the cursor.
	 * @param x Object to be searched.
	 * @return True if it is found, false if not.
	 */
	public boolean searchNext( Object x ) { return false; }

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
	public Object get() { return null; }

	/**
	 * Removes the value at the current position from this list.
	 */
	public void remove() { }

	/**
	 * Removes the given value from this list.
	 * @param x Value to be removed.
	 * @return True when the value was found and removed, false when not.
	 */
	public boolean remove( Object x )
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
	public void insert( Object x ) throws ListOverflowException { }

	/**
	 * Inserts a new value in this list, after the position of the cursor.
	 * @param x Value to be inserted.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void insertAfter( Object x ) throws ListOverflowException
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
	public void insertWithNoDuplicates( Object x, boolean before ) throws ListOverflowException
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
	public void pushBack( Object x ) throws ListOverflowException { }

	/**
	 * Inserts a new value at the first position of this list.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	public void pushFront( Object x ) throws ListOverflowException
	{
		this.begin();
		this.insert( x ); 
	}

	/*
	 * Inserts a new value in order, assuming this list is ordered.
	 * @param x Value to be inserted.
	 * @exception ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	/*
	public void pushInOrder( Object x ) throws ListOverflowException { }
	*/
	/* This method could be implemented in a future... or could not. */

	/**
	 * Removes the frontmost item of this list.
	 * @return The first item of this list.
	 */
	public Object popFront() 
	{
		this.begin();
		Object value = this.get();
		this.remove();
		return value;
	}

	/**
	 * Removes the last item of this list.
	 * @return The last item of this list.
	 */
	public Object popBack() 
	{
		this.end();
		Object value = this.get();
		this.remove();
		return value;
	}

	/*
	 * Sorts the values stored at this list.
	 */
	//public void sortValues() { }
	/* This method could be implemented in a future... or could not. */

	/*
	 * Checks if this list is ascendently sorted
	 * @return True if it is ascendently sorted, false if not.
	 */
	//public boolean checkIfAscendingOrder() { return false; }
	/* This method could be implemented in a future... or could not. */

	/**
	 * Resets this list.
	 */
	public void clear() { }

	/*
	 * Returns the union set of the current list and a given list.
	 * @param a Given list.
	 * @return The union set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	/*
	public ListObject unionSet( ListObject a ) throws ListOverflowException
	{
		return ListObject.unionSet( a, this );
	}
	*/
	/* This method could be implemented in a future... or could not. */

	/*
	 * Returns the interseciton set of the current list and a given list.
	 * @param a Given list.
	 * @return The intersection set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	/*
	public ListObject intersectionSet( ListObject a ) throws ListOverflowException
	{
		return ListObject.intersectionSet( a, this );
	}
	*/
	/* This method could be implemented in a future... or could not. */

	/*
	 * Returns the union set of two given lists.
	 * @param a Given list.
	 * @param b Other given list.
	 * @return The union set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	/*
	public static ListObject unionSet( ListObject a, ListObject b ) throws ListOverflowException
	{
		a.sortValues();
		b.sortValues();

		ListObject c = new ListObjectLinked();

		a.begin();
		b.begin();

		while ( !a.isAtTheEnd() && !b.isAtTheEnd() )
		{
			Object vA = a.get();
			Object vB = b.get();

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
	*/
	/* This method could be implemented in a future... or could not. */

	/*
	 * Returns the intersection set of two given lists.
	 * @param a Given list.
	 * @param b Other given list.
	 * @return The intersection set.
	 * @throws ListOverflowException Thrown when working with the array implementation and the maximum size of the array wil be exceeded if the operation is performed.
	 */
	/*
	public static ListObject intersectionSet( ListObject a, ListObject b ) throws ListOverflowException
	{
		a.sortValues();
		b.sortValues();

		ListObject c = new ListObjectLinked();

		a.begin();
		b.begin();

		while ( !a.isAtTheEnd() && !b.isAtTheEnd() )
		{
			Object vA = a.get();
			Object vB = b.get();

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
	*/
	/* This method could be implemented in a future... or could not. */

	@Override public String toString()
	{
		String output = "\n{\n";

		this.begin();
		while ( !this.isAtTheEnd() )
		{
			output += "\t" + this.get() + "\n";
			this.next();
		}

		output += "}";

		return output;
	}

}