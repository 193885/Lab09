package it.polito.tdp.borders.db;

import java.util.List;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.CountryIDMap;
import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.BorderIDMap;

public class TestDAO {

	public static void main(String[] args) {

		BordersDAO dao = new BordersDAO();
		
		CountryIDMap cIDMAP = new CountryIDMap();
	

		System.out.println("Lista di tutte le nazioni:");
	List<Border> countries = dao.getCountryPairs(2014, cIDMAP);
	}
}
