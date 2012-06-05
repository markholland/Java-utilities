package sumolari.utilities.lists;

import sumolari.utilities.Sorting;
import sumolari.utilities.ListObject;
import sumolari.utilities.exceptions.ListOverflowException;

/**
 * This class is an implementation of a List of Object by means of arrays.
 */
public class ListObjectArray extends ListObject
{
	private 				Object[]	theArray;
	private 				int 		size;
	private 				int 		cursor;
	private static final 	int 		MAX = 100;

	public ListObjectArray() 
	{
		this.clear();
	}

	@Override public boolean isEmpty() 
	{ 
		return ( this.size == 0 ); 
	}

	@Override public boolean search( Object x )
	{
		this.begin();
		this.cursor = -1;

		return searchNext( x );
	}

	@Override public boolean searchNext( Object x )
	{
		this.next();

		while( this.cursor < this.size && this.theArray[ cursor ] != x )
		{
			this.next();
		}
		
		return ( this.cursor < this.size ) ? true : false;
	}

	@Override public int size() 
	{ 
		return this.size; 
	}

	@Override public void begin() 
	{
		this.cursor = 0;
	}

	@Override public void end()
	{
		if ( this.size() > 0 )
		{
			this.cursor = this.size - 1;
		}
		else
		{
			this.begin();
		}	
	}

	@Override public void next()
	{
		if ( !this.isAtTheEnd() )
		{
			this.cursor++;
		}
		else
		{
			this.end();
		}
	}

	@Override public void previous()
	{
		if ( this.cursor > 0 )
		{
			this.cursor--;
		}
		else
		{
			this.begin();
		}
	}	
	
	@Override public boolean isAtTheEnd() 
	{ 
		return ( this.cursor >= this.size - 1 ); 
	}

	@Override public Object get() 
	{
		return this.theArray[ cursor ];
	}

	@Override public void insert( Object x ) throws ListOverflowException
	{
		if ( this.size() == MAX )
		{
			throw new ListOverflowException();
		}
		else 
		{
			for( int k = this.size - 1; k >= this.cursor; k-- )
			{	
				this.theArray[ k + 1 ] = this.theArray[ k ];
			}

			this.theArray[ cursor ] = x;

			this.size++; 
		}
	}

	@Override public void pushBack( Object x ) throws ListOverflowException
	{
		if ( this.size() == MAX )
		{
			throw new ListOverflowException();
		}
		else 
		{
			this.theArray[ size++ ] = x;
			this.end();
		}
	}

	/*
	@Override public void pushInOrder( Object x ) throws ListOverflowException
	{
		if ( this.isEmpty() )
		{
			this.insert( x );
		}
		else
		{

		}
	}
	*/
	/* This method could be implemented in a future... or could not. */

	@Override public void remove()
	{
		Object aux = this.theArray[ cursor ];

		for ( int k = this.cursor + 1; k < this.size; k++ )
		{
			this.theArray[ k - 1 ] = this.theArray[ k ];
		}

		this.size--;
	}

	/*
	@Override public void sortValues() 
	{
	}
	*/
	/* This method could be implemented in a future... or could not. */

	@Override public void clear()
	{
		this.theArray = new String[ MAX ];
		this.size = 0;
		this.cursor = 0;
	}

}