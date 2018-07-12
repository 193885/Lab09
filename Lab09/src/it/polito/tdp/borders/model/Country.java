package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;

public class Country {
	
	private String abbrCountry;
	private int codeCoutry;
	private String nomeCountry;
	
	private List <Border> borders;

	public Country(String abbrCountry, int codeCoutry, String nomeCountry) {
		super();
		this.abbrCountry = abbrCountry;
		this.codeCoutry = codeCoutry;
		this.nomeCountry = nomeCountry;
		
		this.borders = new ArrayList<>();
	}

	public String getAbbrCountry() {
		return abbrCountry;
	}

	public void setAbbrCountry(String abbrCountry) {
		this.abbrCountry = abbrCountry;
	}

	public int getCodeCoutry() {
		return codeCoutry;
	}

	public void setCodeCoutry(int codeCoutry) {
		this.codeCoutry = codeCoutry;
	}

	public String getNomeCountry() {
		return nomeCountry;
	}

	public void setNomeCountry(String nomeCountry) {
		this.nomeCountry = nomeCountry;
	}

	public List<Border> getBorders() {
		return borders;
	}

	public void setBorders(List<Border> borders) {
		this.borders = borders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeCoutry;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (codeCoutry != other.codeCoutry)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+nomeCountry;
	}

}
