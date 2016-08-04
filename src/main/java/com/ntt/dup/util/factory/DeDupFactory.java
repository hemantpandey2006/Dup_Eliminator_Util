package com.ntt.dup.util.factory;

import com.ntt.dup.constants.DeDupConstant;
import com.ntt.dup.exception.SortingException;
import com.ntt.dup.util.DeDupArray;
import com.ntt.dup.util.DeDupList;
import com.ntt.dup.util.DeDupSet;
import com.ntt.dup.util.IDeDup;

/**
 * Manages factory of DeDup objects based on the criteria 
 *
 * @author Hemant
 */
public class DeDupFactory{
	
	/**
	 * Returns the relevant DeDup factory object based on the passed filter criteria
	 * 
	 * @param criteria - criteria for identifying relevant factory object, permitted are [ARRAY] or [LIST] or [SET]
	 * @return - IDeDup based on factory pattern provided criteria
	 * @throws SortingException
	 */
	public static IDeDup getInstance(String criteria) throws SortingException{
		IDeDup deDup = null;
		if (DeDupConstant.Criteria.ARRAY.name().equalsIgnoreCase(criteria)){
			deDup = new DeDupArray();	
		} else if (DeDupConstant.Criteria.LIST.name().equalsIgnoreCase(criteria)){
			deDup = new DeDupList();	
		} else if (DeDupConstant.Criteria.SET.name().toString().equalsIgnoreCase(criteria)){
			deDup = new DeDupSet();	
		} else{
			throw new SortingException("Invalid Type --- Permitted [ARRAY] or [LIST] or [SET]");
		}
		
		return deDup;
	}
	
	

}
