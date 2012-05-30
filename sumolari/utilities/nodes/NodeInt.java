package sumolari.utilities.nodes;

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
		this.value = value;
		this.next = null;
	}

	/**
	 * Creates a new node with a given value and a given following node.
	 * @param value Value of the new node.
	 * @param next Next node in the list.
	 */
	public NodeInt( int value, NodeInt next )
	{
		this.value = value;
		this.next = next;
	}

	/**
	 * Creates a new node with a given value, a given following node and a given previous node.
	 * @param value Value of the new node.
	 * @param next Next node in the list.
	 * @param prevous Previous node in the list.
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