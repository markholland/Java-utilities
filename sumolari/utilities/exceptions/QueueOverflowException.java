package sumolari.utilities.exceptions;

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