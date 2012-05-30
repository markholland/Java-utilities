package sumolari.utilities;

public class Printing
{
	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( int[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%d ", array[ i ] );
		}
		System.out.printf( "}\n" );
	}
}