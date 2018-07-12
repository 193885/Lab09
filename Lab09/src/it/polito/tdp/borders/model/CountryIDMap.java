package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.Map;

public class CountryIDMap {

	private Map <Integer, Country> map;

	public  CountryIDMap() {

		map = new HashMap <Integer, Country>();
	} 
	
	public  Country get(Integer  countryId) {
		
		return map.get(countryId);
	}
		
	public  Country get ( Country c) {
		
		Country old = map.get(c.getCodeCoutry());
		
		if(old == null) {
			
			map.put(c.getCodeCoutry(), c);
			
			return c;
		}
		
		return old;
	}
	
	public void put ( Country c, Integer cId) {
		
		map.put(cId, c);
	}
	
}
