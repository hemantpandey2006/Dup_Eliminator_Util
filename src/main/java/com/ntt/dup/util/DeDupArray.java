package com.ntt.dup.util;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.ntt.dup.exception.SortingException;

/**
 * Class with implementation for removing duplicates from provided integer arrays using Array
 * 
 * @author Hemant
 *
 */
public class DeDupArray implements IDeDup {
	
	private static final Logger LOGGER = Logger.getLogger(DeDupArray.class);

	/* (non-Javadoc)
	 * @see com.ntt.dup.util.IDeDup#eliminateDuplicate(int[])
	 */
	public Integer[] eliminateDuplicate(int... randomIntegers) throws SortingException{
		LOGGER.info("Inside DeDup.eliminateDuplicatesUsingArray()");
		long startTime = System.currentTimeMillis();
		Integer[] uniqueIntegers = null;
		if(randomIntegers!=null){
			LOGGER.info("Orignial Array before sorting : "+Arrays.toString(randomIntegers));
	        Integer[] distinctList = new Integer[randomIntegers.length];
	        boolean isDuplicate = false;
	        int count = randomIntegers.length-1;
	        for(int i = randomIntegers.length-1; i >= 0; --i){
	            isDuplicate = false;
	            for(int j = i-1; j >= 0 && !isDuplicate; --j){
	                if(randomIntegers[j] == randomIntegers[i]){
	                    isDuplicate = true;
	                }
	            }
	            if(!isDuplicate){
	                distinctList[count--] = randomIntegers[i];
	            }
	        }
	        uniqueIntegers = new Integer[randomIntegers.length-count-1];
	        System.arraycopy(distinctList, count+1, uniqueIntegers, 0, randomIntegers.length-count-1);
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

