package sumolari.utilities.lists;

import sumolari.utilities.ListObject;
import sumolari.utilities.nodes.NodeObject;
import sumolari.utilities.exceptions.*;

/**
 * This class is an implementation of a List of Object by means of linked structures.
 */
public class ListObjectLinked extends ListObject
{
	private NodeObject		first;
	private NodeObject		cursor;
	private NodeObject		last;
	private int				size;

	public ListObjectLinked()
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

	@Override public boolean search( Object x )
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

	@Override public boolean searchNext( Object x )
	{
		this.next();
	
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

	@Override public boolean isAtTheEnd()
	{
		return ( this.cursor == this.last );
	}

	@Override public Object get()
	{
		return this.cursor.value();
	}

	@Override public void insert( Object x )
	{
		NodeObject newElement = new NodeObject( x );

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

		this.size++;
	}

	@Override public void pushBack( Object x )
	{
		NodeObject newElement = new NodeObject( x );

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

		this.size++;
	}

	/*
	@Override public void pushInOrder( Object x )
	{
		if ( size == 0 )
		{
			insert( x );
		}
		else
		{
			
		}
	}
	*/
	/* This method could be implemented in a future... or could not. */

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
			NodeObject auxPrevious 	= this.cursor.previous();
			NodeObject auxNext		= this.cursor.next();

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

	/*
	@Override public void sortValues()
	{
	}
	*/
	/* This method could be implemented in a future... or could not. */

	/*
	@Override public boolean checkIfAscendingOrder()
	{
	}
	*/
	/* This method could be implemented in a future... or could not. */

	@Override public void clear()
	{
		this.first 	= null;
		this.last 	= null;
		this.cursor	= null;
		this.size 	= 0;
	}

}