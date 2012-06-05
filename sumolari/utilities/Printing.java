package sumolari.utilities;

/**
 * This class features some methods for printing common data types and save boilerplate code, like printing arrays.
 */
public class Printing
{
	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( byte[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%d ", array[ i ] );
		}
		System.out.printf( "}\n" );
	}

	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( short[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%d ", array[ i ] );
		}
		System.out.printf( "}\n" );
	}

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

	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( long[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%d ", array[ i ] );
		}
		System.out.printf( "}\n" );
	}

	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( float[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%f ", array[ i ] );
		}
		System.out.printf( "}\n" );
	}

	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( double[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%f ", array[ i ] );
		}
		System.out.printf( "}\n" );
	}

	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( boolean[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%s ", ( array[ i ] ) ? "True" : "False" );
		}
		System.out.printf( "}\n" );
	}

	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( char[] array )
	{
		System.out.printf( "{ " );
		for ( int i = 0; i < array.length; i++ )
		{
			System.out.printf( "%c ", array[ i ] );
		}
		System.out.printf( "}\n" );
	}

	/**
	 * Prints the content of a given array.
	 * @param array Array whose content will be printed.
	 */
	public static void printArray( Object[] array )
	{
		System.out.printf( "\n{\n" );
		for ( int i = 0; i < array.length; i++ )
		{
			if ( array[ i ] != null )
			{
				System.out.printf( "\t%s\n", array[ i ].toString() );
			}
		}
		System.out.printf( "}\n" );
	}

}