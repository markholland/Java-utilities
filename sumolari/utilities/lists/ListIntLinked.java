package sumolari.utilities.lists;

import sumolari.utilities.ListInt;
import sumolari.utilities.nodes.NodeInt;
import sumolari.utilities.exceptions.*;

public class ListIntLinked extends ListInt
{
	private NodeInt		first;
	private NodeInt		cursor;
	private NodeInt		last;
	private int			size;

	public ListIntLinked()
	{
		this.clear();
	}
	
	@Override public boolean isEmpty()
	{
		return ( this.size == 0 );
	}

	@Override public boolean search( int x )
	{
		this.begin();

		if ( this.cursor.value() == x )
		{
			return true;
		}
		else
		{
			return this.searchNext( x );
		}
	}

	@Override public boolean searchNext( int x )
	{
		next();
	
		while ( this.cursor != null && cursor.value() != x )
		{
			this.next();
		}

		if ( cursor == null )
		{
			return true;
		}

		return false;
	}

	@Override public int size()
	{
		return this.size;
	}

	@Override public void begin()
	{
		this.cursor = this.first;
	}

	@Override public void end()
	{
		this.cursor = this.last;
	}

	@Override public void next()
	{
		this.cursor = this.cursor.next();
	}

	@Override public void previous()
	{
		this.cursor = this.cursor.previous();
	}

	@Override public boolean isAtTheEnd()
	{
		return ( this.cursor == this.last );
	}

	@Override public int get()
	{
		return this.cursor.value();
	}

	@Override public void insert( int x )
	{
		NodeInt newElement = new NodeInt( x );

		/* The list was empty */
		if ( this.first == null )
		{
			this.first 	= newElement;
			this.last 	= newElement;
		}
		else if ( this.cursor == this.first )
		{
			newElement.setNext( first );
			this.first.setPrevious( newElement );

			this.first 	= newElement;
		}
		else
		{
			newElement.setNext( this.cursor );
			newElement.setPrevious( this.cursor.previous() );
			this.cursor.previous().setNext( newElement );
			this.cursor.setPrevious( newElement );
		}

		this.cursor = newElement;
	}

	@Override public void pushBack( int x )
	{
		NodeInt newElement = new NodeInt( x );

		if ( last != null )
		{
			this.last.setNext( newElement );
			newElement.setPrevious( last );
			this.last = newElement;
		}
		else
		{
			this.first 	= newElement;
			this.last 	= newElement;
			this.cursor = newElement;
		}
	}

	@Override public void pushInOrder( int x )
	{
		if ( this.isEmpty() )
		{
			this.insert( x );
		}
		else
		{
			NodeInt node = this.last;
			while ( node != null && node.value() >= x )
			{
				node = node.previous();
			}

			if ( node == null ) 
			{
				try
				{
					this.pushFront( x );
				}
				catch ( ListOverflowException loe )
				{
					SumolariExceptionManager.catchException( loe );
				}
			}
			else if ( node == last )
			{
				this.pushBack( x );
			}
			else
			{
				this.cursor = node.next();
				this.insert( x );
			}
		}
	}

	@Override public void remove()
	{
		if ( this.isEmpty() )
		{
			// List is empty!
		}
		else if ( this.cursor == this.first )
		{
			this.first 	= this.cursor.next();
			this.cursor = this.cursor.next();
			
			this.size--;	

			if ( size == 0 )
			{
				this.first 	= null;
				this.last 	= null;
				this.cursor = null;
			}
		}
		else if ( this.cursor == this.last )
		{
			this.last 	= this.cursor.previous();
			this.cursor = this.cursor.previous();
			this.last.setNext( null );
			
			this.size--;
		}
		else
		{
			NodeInt auxPrevious = this.cursor.previous();
			NodeInt auxNext		= this.cursor.next();

			if ( auxNext != null ) 		auxNext.setPrevious( auxPrevious );
			if ( auxPrevious != null )	auxPrevious.setNext( auxNext );

			this.size--;

			if ( auxPrevious != null )
			{
				this.cursor = auxPrevious;
			}
			else
			{
				this.cursor = auxNext;
			}
		}
	}

	@Override public void sortValues()
	{
		this.mergeSort();
	}

	@Override public void clear()
	{
		this.first 	= null;
		this.last 	= null;
		this.cursor	= null;
		this.size 	= 0;
	}

	/**
	 * Implementation of MergeSort algorithm for Linked Lists.
	 * @note T(n)=nlog(n)
	 */
	private void mergeSort()
	{
		if ( this.size() > 1 )
		{
			ListIntLinked[] halves = this.split();
			halves[0].mergeSort();
			halves[1].mergeSort();
			this.naturalMerge( halves[0], halves[1] );
		}
	}

	/**
	 * Implementation of NaturalMerge algorithm for Linked Lists.
	 * @note T(n)=log(n)
	 */
	private void naturalMerge( ListIntLinked a, ListIntLinked b )
	{
		this.clear();

		a.begin();
		b.begin();

		while ( !a.isEmpty() && !b.isEmpty() )
		{
			if ( a.get() <= b.get() )
			{
				this.pushBack( a.popFront() );
			}
		}

		while ( !a.isEmpty() ) this.pushBack( a.popFront() );
		while ( !b.isEmpty() ) this.pushBack( b.popFront() );
	}

	/**
	 * Splits the list in two equal parts.
	 * @note T(n)=n
	 */
	private ListIntLinked[] split()
	{
		int originalSize = this.size();

		ListIntLinked halfOne = new ListIntLinked();
		ListIntLinked halfTwo = new ListIntLinked();

		while ( this.size() > halfOne.size() )
		{
			int value = this.popFront();
			
			halfOne.pushBack( value );
		}

		halfTwo.first 	= this.first;
		halfTwo.last 	= this.last;
		halfTwo.cursor 	= this.cursor;
		halfTwo.size	= this.size;

		this.clear();

		ListIntLinked[] result = { halfOne, halfTwo };

		return result;
	}

	/**
	 * Implementation of Insertion Sort algorithm in Linked Lists.
	 */
	private void insertionSort()
	{
		ListIntLinked aux = new ListIntLinked();

		aux.first 	= this.first;
		aux.last 	= this.last;
		aux.cursor 	= this.cursor;
		aux.size 	= this.size;

		this.clear();

		while ( !aux.isEmpty() )
		{
			this.pushInOrder( aux.popFront() );
		}
	}
}