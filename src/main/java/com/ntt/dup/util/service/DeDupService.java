package com.ntt.dup.util.service;

import com.ntt.dup.exception.SortingException;
import com.ntt.dup.util.factory.DeDupFactory;

/**
 * Filters the object based on the criteria 
 *
 * @author Hemant
 */

public class DeDupService {
	
	/**
	 * Eliminates duplicate element from the provided integer array and returns the unique integer array based on the passed criteria. 
	 *  
	 * @param criteria - criteria for getting the relevant factory object, permitted values are [ARRAY] or [LIST] or [SET]
	 * @param randomIntegers - integer array with duplicate elements
	 * @return - integer array with unique elements
	 * @throws SortingException
	 */
	public Integer[] eliminateDuplicate(String criteria, int... randomIntegers) throws SortingException{
		return DeDupFactory.getInstance(criteria).eliminateDuplicate(randomIntegers);
	}
}
