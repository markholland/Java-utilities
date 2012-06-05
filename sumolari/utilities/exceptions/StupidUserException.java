package sumolari.utilities.exceptions;

/**
 * This class represents the exception that raises when the user makes an mistake.
 * <p>
 * Is this excepcion useful? Yes! Imagine that you ask for a number in the range [0 4], and the user inputs 5. Is this an InputMistmatchException? 
 * Not really, in fact it is just a mistake of the user, so this exception should be raised.
 * Everything that has happened due to the user can be considered as a StupidUserException.
 */
public class StupidUserException extends Exception
{

	public StupidUserException()
	{
		super( "Error between keyboard and chair." );
	}

	public StupidUserException( String message )
	{
		super( message );
	}

}