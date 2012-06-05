package sumolari.utilities.queues;

import sumolari.utilities.nodes.NodeObject;
import sumolari.utilities.QueueObject;
import sumolari.utilities.ListObject;
import sumolari.utilities.lists.ListObjectLinked;
import sumolari.utilities.lists.ListObjectArray;
import sumolari.utilities.exceptions.QueueOverflowException;
import sumolari.utilities.exceptions.ListOverflowException;

/**
 * This class is an implementation of a Queue of objects by means of a list.
 */
public class QueueObjectList extends QueueObject
{
	private ListObject		list;

	/**
	 * Creates a queue allowing choosing which implementation of the list want to use internally.
	 * @param implementation 0 for array implementation. Any other value for linked version.
	 */
	public QueueObjectList( int implementation )
	{
		if ( implementation == 0 )
		{
			this.list = new ListObjectArray();
		}
		else
		{
			this.list = new ListObjectLinked();
		}
	}

	public QueueObjectList()
	{
		this( -1 );
	}

	public QueueObjectList( Object[] values ) throws QueueOverflowException
	{
		this( -1 );
		
		for ( Object i : values )
		{
			this.enqueue( i );
		}
	}

	@Override public void enqueue( Object x ) throws QueueOverflowException
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

	@Override public Object dequeue() { return this.list.popFront(); }

	@Override public Object first() 
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