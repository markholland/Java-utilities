package sumolari.utilities.exceptions;

/**
 * This class features some methods common to handle with exception that may raise and are not so important to have a custom behaviour when caught.
 */
public class SumolariExceptionManager
{
	public static void catchException( Exception e )
	{
		System.err.println( e.getMessage() );
		e.printStackTrace( System.err );

		System.out.println( "Ey pal! Something bad has happened, but I can handle that! Don't worry, be happy :)" );
	}
}