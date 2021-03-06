package sumolari.utilities.queues;

import sumolari.utilities.exceptions.QueueOverflowException;
import sumolari.utilities.exceptions.SumolariExceptionManager;
import sumolari.utilities.QueueInt;

/**
 * This class is an implementation of a Queue of integer numbers (int) by means of an array.
 */
public class QueueIntArray extends QueueInt
{
	private int[]				array;
	private int 				first;
	private int 				last;
	private int 				size;
	private static final int 	MAX = 100;

	public QueueIntArray()
	{
		this.array 	=	 new int[ MAX ];
		this.size 	=	 0;
		this.first 	=	 0;
		this.last 	=	 -1;
	}

	public QueueIntArray( int[] values )
	{
		this();

		for ( int i : values )
		{
			try
			{
				this.enqueue( i );
			}
			catch ( QueueOverflowException qoe )
			{
				SumolariExceptionManager.catchException( qoe );
			}
		}
	}

	@Override public void enqueue( int x ) throws QueueOverflowException
	{
		if ( size == MAX )
			throw new QueueOverflowException();

		this.last = this.increment( last );
		this.array[ last ] = x;
		this.size++;
	}

	@Override public int dequeue()
	{
		int x = this.array[ first ];

		this.first = this.increment( first );
		this.size--;

		return x;
	}

	@Override public int first() { return this.array[ first ]; }

	@Override public boolean isEmpty() { return ( this.size == 0 ); }

	@Override public int size() { return this.size; }

	@Override public String toString()
	{
		String output = "{ ";

		for ( int i : this.array )
		{
			output += i + " ";
		}

		output += " }";

		return output;
	}

	/**
	 * Internal method that returns the increased value of a given parameter according to how many values can be stored in the queue.
	 * @param x Value to be increased one position.
	 * @return Value increased one unit.
	 */
	private int increment( int x )
	{
		return ( x + 1 ) % MAX;
	}
}