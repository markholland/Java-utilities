package sumolari.utilities.lists;

import sumolari.utilities.Sorting;
import sumolari.utilities.ListInt;
import sumolari.utilities.exceptions.ListOverflowException;

public class ListIntArray extends ListInt
{
	private 				int[]	theArray;
	private 				int 	size;
	private 				int 	cursor;
	private static final 	int 	MAX = 100;

	public ListIntArray() 
	{
		this.clear();
	}

	@Override public boolean isEmpty () 
	{ 
		return ( this.size == 0 ); 
	}

	@Override public boolean search( int x )
	{
		this.begin();
		this.cursor = -1;

		return searchNext( x );
	}

	@Override public boolean searchNext( int x )
	{
		this.next();

		while( this.cursor < this.size && this.theArray[cursor] != x )
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
		if ( this.isAtTheEnd() )
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

	@Override public int get() 
	{
		return this.theArray[cursor];
	}

	@Override public void insert( int x ) throws ListOverflowException
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

	@Override public void pushBack( int x )
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

	@Override public void pushInOrder( int x )
	{
		if ( this.isEmpty() )
		{
			this.insert( x );
		}
		else
		{

			int index = this.size;
			while ( index >= 0 && theArray[ index ] >= x )
			{
				index--;
			}

			if ( index < 0 ) 
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
			else if ( index == this.size )
			{
				this.pushBack( x );
			}
			else
			{
				this.cursor = index;
				this.cursor.next();
				this.insert( x );
			}
		}
	}

	@Override public void remove()
	{
		int aux = this.theArray[ cursor ];

		for ( int k = this.cursor + 1; k < this.size; k++ )
		{
			this.theArray[ k - 1 ] = this.theArray[ k ];
		}

		this.size--;
	}

	@Override public void sortValues() 
	{
		Sorting.sort( this );
	}

	@Override public void clear()
	{
		this.theArray = new int[ MAX ];
		this.size = 0;
		this.cursor = 0;
	}

}