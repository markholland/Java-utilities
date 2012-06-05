package sumolari.utilities;

/**
 * This class features different sorting algorithms for arrays of integer numbers and arrays of Strings.
 */
public class Sorting
{
	/**
	 * Sorts ascendently a given array using the fastest algorithm available.
	 * T(n)=[n nlog(n)]
	 * @see #countingSort(int[])
	 */
	public static void sort( int[] array )
	{
		countingSort( array );
	}

	/**
	 * Sorts ascendently a given array using the fastest algorithm available.
	 * T(n)=nlog(n)
	 * @see #mergeSort(String[])
	 */
	public static void sort( String[] array )
	{
		mergeSort( array );
	}

	/**
	 * Selection Sort sorting algorithm.
	 * T(n)=n^2
	 * @param array Array to be ordered ascendently.
	 * @see #swap(int[], int, int)
	 * @see #posMin(int[])
	 */
	public static void selectionSort( int[] array )
	{
		for ( int i = 0; i < array.length - 1; i++ )
		{
			int posMin = posMin( array );
			swap( array, i, posMin );
		}
	}

	/**
	 * Insertion Sort sorting algorithm.
	 * T(n)=[n, n^2]
	 * @param array Array to be ordered ascendently.
	 * @see #swap(int[], int, int)
	 */
	public static void insertionSort( int[] array )
	{
		for ( int i = 1; i < array.length; i++ )
		{
			int j = i;
			while ( j > 0 && array[ j ] < array[ j - 1 ] )
			{
				swap( array, j, j - 1 );
				j--;
			}
		}
	}

	/**
	 * Bubble Sort sorting algorithm.
	 * T(n)=n^2
	 * @param array Array to be ordered ascendently.
	 * @see #swap(int[], int, int)
	 */
	public static void bubbleSort( int[] array )
	{
		for ( int i = 1; i < array.length; i++ )
		{
			for ( int j = 1; j < array.length; j++ )
			{
				if ( array[ j ] < array[ j - 1 ] ) swap( array, j, j - 1);
			}
		}
	}

	/**
	 * Merge Sort sorting algorithm.
	 * T(n)=nlog(n)
	 * @param array Array to be ordered.
	 * @see #mergeSort(int[], int, int)
	 * @see #naturalMerge(int[], int, int, int)
	 */
	public static void mergeSort( int[] array )
	{
		mergeSort( array, 0, array.length - 1 );
	}

	/**
	 * Internal method that applies the Merge Sort algorithm in a given range.
	 * T(n)=nlog(n)
	 * @param array Array to be ordered.
	 * @param start First index of the range.
	 * @param end Last index of the range.
	 * @see #naturalMerge(int[], int, int, int)
	 */
	private static void mergeSort( int[] array, int start, int end )
	{
		if ( start < end )
		{
			int half = ( start + end ) / 2;
			mergeSort( array, start, half );
			mergeSort( array, half + 1, end );
			naturalMerge( array, start, half, end );
		}
	}

	/**
	 * Internal method that merges two parts of a given array ordered.
	 * T(n)=n
	 * @param array Array to be ordered.
	 * @param start Start of the range of values of the "first" array.
	 * @param hald End of the range of values of the "first" array.
	 * @param end End of the range of values of the "second" array.
	 */
	private static void naturalMerge( int[] array, int start, int half, int end )
	{
		int[] aux = new int[ end - start + 1 ];
		int a = start, b = half + 1, c = 0;
		while ( a <= half && b <= end )
		{
			if ( array[ a ] < array[ b ] )
			{
				aux[ c++ ] = array[ a++ ];
			}
			else
			{
				aux[ c++ ] = array[ b++ ];
			}
		}

		while ( a <= half ) aux[ c++ ] = array[ a++ ];
		while ( b <= end ) aux[ c++ ] = array[ b++ ];

		for ( int i = 0; i < aux.length; i++ )
		{
			array[ start + i ] = aux[ i ];
		}
	}

	/**
	 * Internal method that merges two ordered arrays into a new ordered array.
	 * T(n)=n
	 * @param a First array.
	 * @param b Second array.
	 * @return An ordered array with the values of the given arrays,
	 */
	private static int[] naturalMerge( int[] a, int[] b )
	{
		int[] c = new int[ a.length + b.length ];
		int k = 0, i = 0, j = 0;

		while ( i < a.length && j < b.length )
		{
			if ( a[ i ] < b[ j ] )
			{
				c[ k++ ] = a[ i++ ];
			}
			else
			{
				c[ k++ ] = b[ j++ ];
			}
		}

		while ( i < a.length ) c[ k++ ] = a[ i++ ];
		while ( j < b.length ) c[ k++ ] = b[ j++ ];

		return c;
	}

	/**
	 * Merge Sort sorting algorithm.
	 * T(n)=nlog(n)
	 * @param array Array to be ordered.
	 * @see #mergeSort(String[], int, int)
	 * @see #naturalMerge(String[], int, int, int)
	 */
	public static void mergeSort( String[] array )
	{
		mergeSort( array, 0, array.length - 1 );
	}

	/**
	 * Internal method that applies the Merge Sort algorithm in a given range.
	 * T(n)=nlog(n)
	 * @param array Array to be ordered.
	 * @param start First index of the range.
	 * @param end Last index of the range.
	 * @see #naturalMerge(String[], int, int, int)
	 */
	private static void mergeSort( String[] array, int start, int end )
	{
		if ( start < end )
		{
			int half = ( start + end ) / 2;
			mergeSort( array, start, half );
			mergeSort( array, half + 1, end );
			naturalMerge( array, start, half, end );
		}
	}

	/**
	 * Internal method that merges two parts of a given array ordered.
	 * T(n)=n
	 * @param array Array to be ordered.
	 * @param start Start of the range of values of the "first" array.
	 * @param hald End of the range of values of the "first" array.
	 * @param end End of the range of values of the "second" array.
	 */
	private static void naturalMerge( String[] array, int start, int half, int end )
	{
		String[] aux = new String[ end - start + 1 ];
		int a = start, b = half + 1, c = 0;
		while ( array[ a ] != null && array[ b ] != null && a <= half && b <= end )
		{
			if ( array[ a ].compareTo( array[ b ] ) < 0 )
			{
				aux[ c++ ] = array[ a++ ];
			}
			else
			{
				aux[ c++ ] = array[ b++ ];
			}
		}

		while ( a <= half ) aux[ c++ ] = array[ a++ ];
		while ( b <= end ) aux[ c++ ] = array[ b++ ];

		for ( int i = 0; i < aux.length; i++ )
		{
			array[ start + i ] = aux[ i ];
		}
	}

	/**
	 * Internal method that merges two ordered arrays into a new ordered array.
	 * T(n)=n
	 * @param a First array.
	 * @param b Second array.
	 * @return An ordered array with the values of the given arrays,
	 */
	private static String[] naturalMerge( String[] a, String[] b )
	{
		String[] c = new String[ a.length + b.length ];
		int k = 0, i = 0, j = 0;

		while ( i < a.length && j < b.length )
		{
			if ( a[ i ].compareTo( b[ j ] ) < 0 )
			{
				c[ k++ ] = a[ i++ ];
			}
			else
			{
				c[ k++ ] = b[ j++ ];
			}
		}

		while ( i < a.length ) c[ k++ ] = a[ i++ ];
		while ( j < b.length ) c[ k++ ] = b[ j++ ];

		return c;
	}

	/**
	 * Quick Sort sorting algorithm.
	 * T(n)=[nlog(n) n^2]
	 * @param array Array to be ordered.
	 * @see #quickSort(int[], int, int)
	 */
	public static void quickSort( int[] array )
	{
		quickSort( array, 0, array.length - 1 );
	}

	/**
	 * Internal method that applies Quick Sort sorting algorithm in a given range.
	 * T(n)=[nlog(n) n^2]
	 * @param array Array to be ordered.
	 * @param left Start of the range.
	 * @param right End of the range.
	 */
	private static void quickSort( int[] array, int left, int right )
	{
		int index = partition( array, left, right);

		if ( left < index - 1 )
		{
			quickSort( array, left, index - 1 );
		}
		if ( index < right )
		{
			quickSort( array, index, right );
		}
	}	

	/**
	 * Internal method for Quick Sort algorithm that moves values to the first or the second part of an array.
	 * T(n)=n
	 * @param array Array to be partitioned.
	 * @param left Start of the range of the array to be partitioned.
	 * @param right End of the range of the array to be partitioned.
	 * @return Index that divides the first and the second part.
	 */
	private static int partition( int[] array, int left, int right )
	{
		int i = left, j = right;
		int pivot = array[ ( left + right ) / 2 ];

		while ( i <= j )
		{
			while ( array[ i ] < pivot ) i++;
			while ( array[ j ] > pivot ) j--;

			if ( i <= j )
			{
				swap( array, i, j );
				i++;
				j--;
			}
		}

		return i;
	}

	/**
	 * Heap Sort sorting algorithm.
	 * T(n)=[n nlog(n)]
	 * @param array Array to be ordered
	 * @see #createHeap(int[]) 
	 * @see #heapSort(int[], int[])
	 */
	public static void heapSort( int[] array )
	{
		int[] heap = array;

		createHeap( heap );
		heapSort( array, heap );
	}

	/**
	 * Internal method to sort using Heap Sort algorithm.
	 * T(n)=[n nlog(n)]
	 * @param array Array to be sorted. 
	 * @param heap Array to be used as heap.
	 * @see #createHeap(int[])
	 */
	private static void heapSort( int[] array, int[] heap )
	{
		for ( int heapsize = ( heap.length - 1 ); heapsize > 0; heapsize-- )
		{

			swap( heap, 0, heapsize );
			int i = 0;

			while ( true )
			{

				int left = ( i * 2 ) + 1;

				if ( left >= heapsize ) break;

				int right = left + 1;

				if ( right >= heapsize )
				{
					if ( heap[ left ] > heap[ i ] ) swap( heap, left, i );
				
					break;
				}

				if ( heap[ left ] > heap[ i ] )
				{
					if ( heap[ left ] > heap[ right ] )
					{
						swap( heap, left, i );
						i = left;
						continue;
					}
					else
					{
						swap ( heap, right, i );
						i = right;
						continue;
					}
				}
				else
				{
					if ( heap[ right ] > heap[ i ] )
					{
						swap( heap, right, i );
						i = right;
						continue;
					}
					else
					{
						break;
					}	
				}

			}

		}
	}

	/**
	 * Internal method to create the Heap of the Heap Sort algorithm.
	 * T(n)=n
	 * @param heap Array to be used as heap.
	 * @see #heapApp(int, int, int[])
	 */
	private static void createHeap( int[] heap )
	{
		int size = 0;
		for ( int i = 0; i < heap.length; i++ )
		{
			int e = heap[ i ];
			size = heapAdd( size, e, heap );
		}
	}

	/**
	 * Internal method to add items to the Heap of the Heap Sort algorithm.
	 * T(n)=log(n)
	 * @param size Current index of the last non-null item in the Heap.
	 * @param e Item to be added.
	 * @param array Array to be used as Heap.
	 * @return New index of the last non-null item in the Heap.
	 * @see #swap(int[], int, int)
	 */
	private static int heapAdd( int length, int element, int[] heap )
	{
		int i = length;
		heap[ length++ ] = element;

		int e = heap[ i ];
		int parentIndex = ( ( i - 1 ) / 2 );
		int parent = heap[ parentIndex ];

		while ( e > parent )
		{
			swap( heap, parentIndex, i );
			i = parentIndex;
			e = heap[ i ];
			parentIndex = ( ( i - 1 ) / 2 );
			parent = heap[ parentIndex ];
		}

		return length;
	}

	/**
	 * Counting Sort sorting algorithm.
	 * T(n)=n
	 * @param array Array to be sorted.
	 */
	public static void countingSort( int[] array )
	{
		int min = getMin( array );
		int range = getMax( array ) - min + 1;

		int[] counts = new int[ range ];

		for ( int i = 0; i < array.length; i++ ) counts[ array[ i ] - min ]++;

		int outputPos = 0;
		for ( int i = 0; i < range; i++ )
		{
			for ( int j = 0; j < counts[ i ]; j++ )
			{
				array[ outputPos ] = i + min;
				outputPos++;
			}
		}
	}

	/*
	 * METHOD NOT IMPLEMENTED
	 */
	/*
	public static void radixSort( int[] array )
	{

	}
	*/	

	/*
	 * METHOD NOT IMPLEMENTED
	 */
	/*
	public static void bucketSort( int[] array )
	{

	}
	*/

	/**
	 * Retrieves the index of the lowest value in the array.
	 * T(n)=n
	 * @param array Array with data.
	 * @return Index of the lowest value.
	 */
	public static int posMin( int[] array )
	{
		return posMin( array, 0, array.length - 1 );
	}

	/**
	 * Retrieves the lowest value in the array.
	 * T(n)=n
	 * @param array Array with data.
	 * @return Lowest value in the array.
	 * @see #posMin(int[])
	 */
	public static int getMin( int[] array )
	{
		return array[ posMin(array) ];
	}

	/**
	 * Internal method for obtaning the minimum value in a range.
	 * T(n)=n
	 * @param array Array with data.
	 * @param start Start of the range.
	 * @param end End of the range.
	 * @return The index of the lowest value in the range.
	 */
	private static int posMin( int[] array, int start, int end )
	{
		int pos = start;
		for ( int i = start + 1; i <= end; i++ )
		{
			if ( array[ i ] < array [ pos ] ) pos = i;
		}
		return pos;
	}

	/**
	 * Retrieves the index of the highest value in the array.
	 * T(n)=n
	 * @param array Array with data.
	 * @return Index of the highest value.
	 */
	public static int posMax( int[] array )
	{
		return posMax( array, 0, array.length - 1 );
	}

	/**
	 * Retrieves the highest value in the array.
	 * T(n)=n
	 * @param array Array with data.
	 * @return Highest value in the array.
	 * @see #posMax(int[])
	 */
	public static int getMax( int[] array )
	{
		return array[ posMax(array) ];
	}

	/**
	 * Internal method for obtaning the maximum value in a range.
	 * T(n)=n
	 * @param array Array with data.
	 * @param start Start of the range.
	 * @param end End of the range.
	 * @return The index of the highest value in the range.
	 */
	private static int posMax( int[] array, int start, int end )
	{
		int pos = start;
		for ( int i = start + 1; i <= end; i++ )
		{
			if ( array[ i ] > array [ pos ] ) pos = i;
		}
		return pos;
	}

	/**
	 * Internal method for exchanging two values in an array.
	 * T(n)=1
	 * @param array Array with data.
	 * @param i One index to be exchanged.
	 * @param j Other index to be exchanged.
	 */
	private static void swap( int[] array, int i, int j )
	{
		int aux = array[ i ];
		array[ i ] = array[ j ];
		array[ j ] = aux;
	}
}