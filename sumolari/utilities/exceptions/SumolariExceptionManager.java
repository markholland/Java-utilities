package sumolari.utilities.exceptions;

public class SumolariExceptionManager
{
	public static void catchException( Exception e )
	{
		System.err.println( e.getMessage() );
		e.printStackTrace( System.err );

		System.out.println( "Ey pal! Something bad has happened, but I can handle that! Don't worry be happy :)" );
	}
}