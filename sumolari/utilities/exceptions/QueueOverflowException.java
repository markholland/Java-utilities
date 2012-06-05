package sumolari.utilities.exceptions;

/**
 * This class represents the exception that raises when trying to add a new element to a Queue which is full.
 * This usually happens when the Queue is internally implemented by means of an array.
 */
public class QueueOverflowException extends Exception
{

	public QueueOverflowException()
	{
		super( "The queue is full so you cannot add more elements to it." );
	}

	public QueueOverflowException( String message )
	{
		super( message );
	}

}