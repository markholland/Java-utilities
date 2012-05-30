package sumolari.utilities.exceptions;

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