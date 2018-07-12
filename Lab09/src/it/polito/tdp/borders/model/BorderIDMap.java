package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.Map;

public class BorderIDMap {
	
	private Map <Integer, Border> map;

	public  BorderIDMap() {

		map = new HashMap <Integer, Border>();
	} 
	
	public  Border get(Integer  borderId) {
		
		return map.get(borderId);
	}
		
	public  Border get ( Border b) {
		
		Border old = map.get(b.getId());
		
		if(old == null) {
			
			map.put(b.getId(), b);
			
			return b;
		}
		
		return old;
	}
	
	public void put ( Border b, Integer bId) {
		
		map.put(bId, b);
	}
	
}
