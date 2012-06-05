package sumolari.utilities.nodes;

/**
 * This class represents a Node that stores a String, as well as references to the following and the previous Node in a list.
 * It is used in the implementation of Stacks, Queues and Lists by means of linked structures.
 */
public class NodeObject
{
	private Object 			value;
	private NodeObject 		next;
	private NodeObject		previous;

	/**
	 * Creates a new node with a given value.
	 * @param value Value of the new node.
	 */
	public NodeObject( Object value )
	{
		this.value = value;
		this.next = null;
	}

	/**
	 * Creates a new node with a given value and a given following node.
	 * @param value Value of the new node.
	 * @param next Next node in the list.
	 */
	public NodeObject( Object value, NodeObject next )
	{
		this.value = value;
		this.next = next;
	}

	/**
	 * Creates a new node with a given value, a given following node and a given previous node.
	 * @param value Value of the new node.
	 * @param next Next node in the list.
	 * @param previous Previous node in the list.
	 */
	public NodeObject( Object value, NodeObject next, NodeObject previous )
	{
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	/**
	 * Retrieves the value of this node.
	 * @return Value of the current node.
	 */
	public Object value() { return this.value; }

	/**
	 * Retrieves the following node.
	 * @return The following node in the list.
	 */
	public NodeObject next() { return this.next; }

	/**
	 * Retrieves the previous node.
	 * @return The previous node in the list.
	 */
	public NodeObject previous() { return this.previous; } 

	/**
	 * Sets a new node as the following node of this node.
	 * @param next New node to be used as next node of the current one.
	 */
	public void setNext( NodeObject next ) { this.next = next; }

	/**
	 * Sets a new node as the previous node of this node.
	 * @param previous New node to be used as previous node of the current one.
	 */
	public void setPrevious( NodeObject previous ) { this.previous = previous; }
}