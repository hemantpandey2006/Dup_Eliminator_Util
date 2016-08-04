package com.ntt.dup.util;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ntt.dup.constants.DeDupConstant;
import com.ntt.dup.util.service.DeDupService;

public class DeDupTest {
	
	private static final int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
	private static final Integer[] expected = {1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7};
	private int[] highCountIntegers = new int[2000];
	DeDupService deDupService = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//Generating 2000 random numbers between 99 & 9999 and adding 
		//into array for performance testing in case of high volume data
		for(int i=0;i<2000;i++){
			highCountIntegers[i]=getRandomNumberInRange(99,9999);
		}
		deDupService = new DeDupService();
		
	}

	@After
	public void tearDown() throws Exception {
		deDupService = null;
	}
	
	@Test (expected = Exception.class)
	public void testFactoryWithInvalidCriteria() throws Exception {
		deDupService.eliminateDuplicate("aaa", randomIntegers);
	}
	
	@Test
	public void testEliminateDuplicatesUsingList() throws Exception {
		Assert.assertArrayEquals(expected,deDupService.eliminateDuplicate(DeDupConstant.Criteria.LIST.name(), randomIntegers));
	}
	
	@Test
	public void testEliminateDuplicatesUsingSet() throws Exception {
		Assert.assertArrayEquals(expected,deDupService.eliminateDuplicate(DeDupConstant.Criteria.SET.name(), randomIntegers));
	}
	
	@Test
	public void testEliminateDuplicatesUsingArray() throws Exception {
		Assert.assertArrayEquals(expected,deDupService.eliminateDuplicate(DeDupConstant.Criteria.ARRAY.name(), randomIntegers));
	}
	
	@Test (expected = Exception.class)
	public void testEliminateDuplicatesUsingListForNullInput() throws Exception {
		Assert.assertArrayEquals(expected,deDupService.eliminateDuplicate(DeDupConstant.Criteria.LIST.name(), null));
	}
	
	@Test (expected = Exception.class)
	public void testEliminateDuplicatesUsingSetForNullInput() throws Exception {
		Assert.assertArrayEquals(expected,deDupService.eliminateDuplicate(DeDupConstant.Criteria.SET.name(), null));
	}
	
	@Test (expected = Exception.class)
	public void testEliminateDuplicatesUsingArrayForNullInput() throws Exception {
		Assert.assertArrayEquals(expected,deDupService.eliminateDuplicate(DeDupConstant.Criteria.ARRAY.name(), null));
	}
	
	@Test
	public void testEliminateDuplicatesUsingListWithTwoThousandIntegers() throws Exception {
		Assert.assertNotNull(deDupService.eliminateDuplicate(DeDupConstant.Criteria.LIST.name(), highCountIntegers));
	}
	
	@Test
	public void testEliminateDuplicatesUsingSetWithTwoThousandIntegers() throws Exception {
		Assert.assertNotNull(deDupService.eliminateDuplicate(DeDupConstant.Criteria.SET.name(), highCountIntegers));
	}
	
	@Test
	public void testEliminateDuplicatesUsingArrayWithTwoThousandIntegers() throws Exception {
		Assert.assertNotNull(deDupService.eliminateDuplicate(DeDupConstant.Criteria.ARRAY.name(), highCountIntegers));
	}
	
	/**
	 * Generates random integer between given range
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	private int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
