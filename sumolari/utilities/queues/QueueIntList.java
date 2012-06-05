package sumolari.utilities.queues;

import sumolari.utilities.nodes.NodeInt;
import sumolari.utilities.QueueInt;
import sumolari.utilities.ListInt;
import sumolari.utilities.lists.ListIntLinked;
import sumolari.utilities.lists.ListIntArray;
import sumolari.utilities.exceptions.QueueOverflowException;
import sumolari.utilities.exceptions.ListOverflowException;

/**
 * This class is an implementation of a Queue of integer numbers (int) by means of a list.
 */
public class QueueIntList extends QueueInt
{
	private ListInt		list;

	/**
	 * Creates a queue allowing choosing which implementation of the list want to use internally.
	 * @param implementation 0 for array implementation. Any other value for linked version.
	 */
	public QueueIntList( int implementation )
	{
		if ( implementation == 0 )
		{
			this.list = new ListIntArray();
		}
		else
		{
			this.list = new ListIntLinked();
		}
	}

	public QueueIntList()
	{
		this( -1 );
	}

	public QueueIntList( int[] values ) throws QueueOverflowException
	{
		this( -1 );
		
		for ( int i : values )
		{
			this.enqueue( i );
		}
	}

	@Override public void enqueue( int x ) throws QueueOverflowException
	{
		try
		{
			this.list.pushBack( x );
		}
		catch ( ListOverflowException loe )
		{
			throw new QueueOverflowException();
		}
	}

	@Override public int dequeue() { return this.list.popFront(); }

	@Override public int first() 
	{
		this.list.begin();
		return this.list.get(); 
	}

	@Override public boolean isEmpty() { return this.list.isEmpty(); }
	
	@Override public int size() { return this.list.size(); }

	@Override public String toString()
	{
		return this.list.toString();
	}

}