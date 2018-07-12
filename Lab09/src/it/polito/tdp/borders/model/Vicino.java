package it.polito.tdp.borders.model;

public class Vicino implements Comparable<Vicino>{
	
	private Country stato;
	private int nvicini;
	
	public Vicino(Country stato, int nvicini) {
		super();
		this.stato = stato;
		this.nvicini = nvicini;
	}

	public Country getStato() {
		return stato;
	}

	public void setStato(Country stato) {
		this.stato = stato;
	}

	public int getNvicini() {
		return nvicini;
	}

	public void setNvicini(int nvicini) {
		this.nvicini = nvicini;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nvicini;
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
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
		Vicino other = (Vicino) obj;
		if (nvicini != other.nvicini)
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + stato + "     " + nvicini+"\n" ;
	}

	@Override
	public int compareTo(Vicino o) {
		
		
		
		return(-this.getNvicini()+o.getNvicini());
	}

}
