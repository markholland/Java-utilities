package sumolari.utilities.exceptions;

/**
 * This class represents the exception that raises when trying to add a new element to a Stack which is full.
 * This usually happens when the Stack is internally implemented by means of an array.
 */
public class StackOverflowException extends Exception
{

	public StackOverflowException()
	{
		super( "The stack is full so you cannot add more elements to it." );
	}

	public StackOverflowException( String message )
	{
		super( message );
	}

}