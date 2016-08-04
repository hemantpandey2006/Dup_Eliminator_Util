package com.ntt.dup.util;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ntt.dup.exception.SortingException;

/**
 * Class with implementation for removing duplicates from provided integer arrays using Set
 * 
 * @author Hemant
 *
 */
public class DeDupSet implements IDeDup {
	
	private static final Logger LOGGER = Logger.getLogger(DeDupSet.class);
	
	/* (non-Javadoc)
	 * @see com.ntt.dup.util.IDeDup#eliminateDuplicate(int[])
	 */
	public Integer[] eliminateDuplicate(int... randomIntegers) throws SortingException{
		LOGGER.info("Inside DeDup.eliminateDuplicateUsingSet()");
		long startTime = System.currentTimeMillis();
		Integer[] uniqueIntegers = null;
		if(randomIntegers!=null){
			LOGGER.info("Orignial Array before sorting : "+Arrays.toString(randomIntegers));
			//Used LinkedHashSet because as per question the answer should retain the original order. 
			//In case of sorted elements we can use TreeSet
			Set<Integer> s = new LinkedHashSet<Integer>();
			for(int r:randomIntegers)
				s.add(r);
			uniqueIntegers = (Integer [])s.toArray(new Integer[0]);
			LOGGER.info("Output Array with unique elements : "+Arrays.toString(uniqueIntegers));
		}else{
			LOGGER.error("Input Array is null throwing exception");
			throw new SortingException("Provided array should not be null");
		}
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		LOGGER.debug("Time taken in execution of the method :"+timeTaken);
		return uniqueIntegers;
	}

}

