package com.ntt.dup.util;

import com.ntt.dup.exception.SortingException;

/**
 * Interface for removing duplicates from provided integer arrays.
 *
 * @author Hemant
 */
public interface IDeDup {
	
	/**
	 * Removes duplicate by retaining its original order
	 * It uses three approaches (Array, List and Set) for deleting the duplicates. Based on log captures for execution time calculation
	 * 
	 * Array approach - is slowest amongst all three approaches in case of high volume of data
	 * For 2000 random numbers between 99 to 9999 deletion of duplicates take around 23 milliseconds
	 * but fastest in case of low volume of data.
	 * 
	 * List approach - is slower than Set approach but faster than Array approach in case of high volume of data
	 * For 2000 random numbers between 99 to 9999 deletion of duplicates take around 12 milliseconds
	 * this approach is slower than array approach in case of low volume of data.
	 *
	 * Set approach - is fastest amongst all three approaches in case of high volume of data
	 * For 2000 random numbers between 99 to 9999 deletion of duplicates take around 12 milliseconds
	 * this approach is slower than array approach in case of low volume of data but faster than List approach.
	 * 
	 * @param randomIntegers the random integers
	 * @return - Integer array with unique elements
	 * @throws SortingException the sorting exception
	 */
	public Integer[] eliminateDuplicate(int... randomIntegers) throws SortingException;
	
}
