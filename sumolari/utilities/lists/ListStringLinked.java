package sumolari.utilities.lists;

import sumolari.utilities.ListString;
import sumolari.utilities.nodes.NodeString;
import sumolari.utilities.exceptions.*;

public class ListStringLinked extends ListString
{
	private NodeString		first;
	private NodeString		cursor;
	private NodeString		last;
	private int				size;

	public ListStringLinked()
	{
		this.clear();
	}
	
	@Override public boolean isEmpty()
	{
		return ( this.size == 0 );
	}

	@Override public int size()
	{
		return this.size;
	}

	@Override public boolean search( String x )
	{
		this.begin();

		if ( this.cursor.value().equals( x ) )
		{
			return true;
		}
		else
		{
			return this.searchNext( x );
		}
	}

	@Override public boolean searchNext( String x )
	{
		next();
	
		while ( this.cursor != null && cursor.value().equals( x ) )
		{
			this.next();
		}

		if ( cursor == null )
		{
			return true;
		}

		return false;
	}

	@Override public void begin()
	{
		this.cursor = this.first;
	}

	@Override public void next()
	{
		this.cursor = this.cursor.next();
	}

	@Override public void previous()
	{
		this.cursor = this.cursor.previous();
	}

	@Override public void end()
	{
		this.cursor = this.last;
	}

	@Override public String get()
	{
		return this.cursor.value();
	}

	@Override public void insert( String x )
	{
		NodeString newElement = new NodeString( x );

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

	@Override public void pushBack( String x )
	{
		NodeString newElement = new NodeString( x );

		if ( last != null )
		{
			last.setNext( newElement );
			newElement.setPrevious( last );
			last = newElement;
		}
		else
		{
			this.first 	= newElement;
			this.last 	= newElement;
			this.cursor = newElement;
		}
	}

	@Override public void pushInOrder( String x )
	{
		if ( size == 0 )
		{
			insert( x );
		}
		else
		{
			NodeString node = last;
			while ( node != null && node.value().compareTo( x ) >= 0 )
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
			NodeString auxPrevious = this.cursor.previous();
			NodeString auxNext		= this.cursor.next();

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
		mergeSort();
	}

	@Override public boolean checkIfAscendingOrder()
	{
		NodeString prev = this.first;
		NodeString current = ( this.first != null ) ? this.first.next() : null;

		boolean ascendingOrder = true;

		while ( current != null && ascendingOrder )
		{
			ascendingOrder = ( prev.value().compareTo( current.value() ) <= 0 );
			prev = current;
			current = current.next();
		}

		return ascendingOrder;
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
			ListStringLinked[] halves = this.split();
			halves[0].mergeSort();
			halves[1].mergeSort();
			this.naturalMerge( halves[0], halves[1] );
		}
	}

	/**
	 * Implementation of NaturalMerge algorithm for Linked Lists.
	 * @note T(n)=log(n)
	 */
	private void naturalMerge( ListStringLinked a, ListStringLinked b )
	{
		this.clear();

		a.begin();
		b.begin();

		while ( !a.isEmpty() && !b.isEmpty() )
		{
			if ( a.get().compareTo( b.get() ) <= 0 )
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
	private ListStringLinked[] split()
	{
		int originalSize = this.size();

		ListStringLinked halfOne = new ListStringLinked();
		ListStringLinked halfTwo = new ListStringLinked();

		while ( this.size() > halfOne.size() )
		{
			String value = this.popFront();
			
			halfOne.pushBack( value );
		}

		halfTwo.first 	= this.first;
		halfTwo.last 	= this.last;
		halfTwo.cursor 	= this.cursor;
		halfTwo.size	= this.size;

		this.clear();

		ListStringLinked[] result = { halfOne, halfTwo };

		return result;
	}

	/**
	 * Implementation of Insertion Sort algorithm in Linked Lists.
	 */
	private void insertionSort()
	{
		ListStringLinked aux = new ListStringLinked();

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