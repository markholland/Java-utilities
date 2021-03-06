package sumolari.utilities.queues;

import sumolari.utilities.nodes.NodeInt;
import sumolari.utilities.QueueInt;

/**
 * This class is an implementation of a Queue of integer numbers (int) by means of linked structures.
 */
public class QueueIntLinked extends QueueInt
{
	private NodeInt		first;
	private NodeInt		last;
	private int 		size;

	public QueueIntLinked()
	{
		this.size 	=	 0;
		this.first 	=	 null;
		this.last 	=	 null;
	}

	public QueueIntLinked( int[] values )
	{
		this();
		
		for ( int i : values )
		{
			this.enqueue( i );
		}
	}

	@Override public void enqueue( int x )
	{
		NodeInt newNode = new NodeInt( x );

		if ( last != null ) 
		{
			this.last.setNext( newNode );
		}
		else
		{
			this.first = newNode;
		}

		this.last = newNode;

		size++;
	}

	@Override public int dequeue()
	{
		int x = this.first.value();
		this.first = this.first.next();

		if ( this.first == null )
		{
			this.last = null;
		}

		this.size--;

		return x;
	}

	@Override public int first() { return this.first.value(); }

	@Override public boolean isEmpty() { return ( this.first == null ); }

	@Override public int size() { return this.size; }

	@Override public String toString()
	{
		String output = "{ ";
		NodeInt aNode = this.first;

		while ( aNode != null )
		{
			output += aNode.value() + " ";
			aNode = aNode.next();
		}

		output += "}";

		return output;
	}

}