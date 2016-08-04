package com.ntt.dup.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.ntt.dup.exception.SortingException;

/**
 * Class with implementation for removing duplicates from provided integer arrays using List
 * 
 * @author Hemant
 *
 */
public class DeDupList implements IDeDup {
	
	private static final Logger LOGGER = Logger.getLogger(DeDupList.class);
	
	/* (non-Javadoc)
	 * @see com.ntt.dup.util.IDeDup#eliminateDuplicate(int[])
	 */
	public Integer[] eliminateDuplicate(int... randomIntegers)throws SortingException{
		LOGGER.info("Inside DeDup.eliminateDuplicateUsingList()");
		long startTime = System.currentTimeMillis();
		Integer[] uniqueIntegers=null;
		if(randomIntegers!=null){
			LOGGER.info("Orignial Array before sorting : "+Arrays.toString(randomIntegers));
			List<Integer> numberList = new ArrayList<Integer>();		
			for(int i=0;i<randomIntegers.length;i++){
				if(!numberList.contains(randomIntegers[i])){
					numberList.add(randomIntegers[i]);
				}
			}
			uniqueIntegers = (Integer [])numberList.toArray(new Integer[0]);
			LOGGER.info("Output Array with unique elements : "+Arrays.toString(uniqueIntegers));
		} else{
			LOGGER.error("Input Array is null throwing exception");
			throw new SortingException("Provided array should not be null");
		}
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		LOGGER.debug("Time taken in execution of the method :"+timeTaken);
		return uniqueIntegers;
	}
	
}

