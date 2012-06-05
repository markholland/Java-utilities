package sumolari.utilities.nodes;

/**
 * This class represents a Node that stores an integer number (int), as well as references to the following and the previous Node in a list.
 * It is used in the implementation of Stacks, Queues and Lists by means of linked structures.
 */
public class NodeInt
{
	private int 		value;
	private NodeInt 	next;
	private NodeInt		previous;

	/**
	 * Creates a new node with a given value.
	 * @param value Value of the new node.
	 */
	public NodeInt( int value )
	{
		 this( value, null, null );
	}

	/**
	 * Creates a new node with a given value and a given following node.
	 * @param value Value of the new node.
	 * @param next Next node in the list.
	 */
	public NodeInt( int value, NodeInt next )
	{
		this( value, next, null );
	}

	/**
	 * Creates a new node with a given value, a given following node and a given previous node.
	 * @param value Value of the new node.
	 * @param next Next node in the list.
	 * @param previous Previous node in the list.
	 */
	public NodeInt( int value, NodeInt next, NodeInt previous )
	{
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	/**
	 * Retrieves the value of this node.
	 * @return Value of the current node.
	 */
	public int value() { return this.value; }

	/**
	 * Retrieves the following node.
	 * @return The following node in the list.
	 */
	public NodeInt next() { return this.next; }

	/**
	 * Retrieves the previous node.
	 * @return The previous node in the list.
	 */
	public NodeInt previous() { return this.previous; } 

	/**
	 * Sets a new node as the following node of this node.
	 * @param next New node to be used as next node of the current one.
	 */
	public void setNext( NodeInt next ) { this.next = next; }

	/**
	 * Sets a new node as the previous node of this node.
	 * @param previous New node to be used as previous node of the current one.
	 */
	public void setPrevious( NodeInt previous ) { this.previous = previous; }
}