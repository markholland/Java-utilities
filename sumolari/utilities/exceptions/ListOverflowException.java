package sumolari.utilities.exceptions;

/**
 * This class represents the exception that raises when trying to add a new element to a List which is full.
 * This usually happens when the List is internally implemented by means of an array.
 */
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