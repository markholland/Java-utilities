package sumolari.utilities.exceptions;

public class ListOverflowException extends Exception
{

	public ListOverflowException()
	{
		super( "The list is full so you cannot add more elements to it." );
	}

	public ListOverflowException( String message )
	{
		super( message );
	}

}