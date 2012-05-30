package sumolari.utilities;

public class Searching
{
	/**
	 * Retrieves the position of a given value in an array.
	 * @note T(n)=n
	 * @param array Array of data.
	 * @param x Value to be searched.
	 * @return Index of that value.
	 */
	public static int linearSearch( int[] array, int x )
	{
		boolean found = false;
		int i = 0;

		for ( i = 0; i < array.length && !found; i++ )
		{
			if ( array[ i ] == x ) found = true;
		}

		return ( found ) ? i - 1 : - 1;
	}

	/**
	 * Retrieves the position of a given value in an ordered array.
	 * @note T(n)=log(n)
	 * @param array Array of data.
	 * @param x Value to be searched.
	 * @return Index of that value.
	 */
	public static int binarySearch( int[] array, int x )
	{
		int left = 0, right = array.length - 1, k = 0;
		boolean found = false;

		while ( left <= right && !found )
		{
			k = ( left + right ) / 2;
			if ( x == array[ k ] )
			{
				found = true;
			}
			else if ( array[ k ] < x )
			{
				left = k + 1;
			}
			else
			{
				right = k - 1;
			}
		}

		return ( found ) ? k : -1;
	}
}
