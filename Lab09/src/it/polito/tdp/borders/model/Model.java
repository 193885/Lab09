package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private BordersDAO bdao;
	
	private List <Country> countries;
	private List <Border> borders;

	private List <Country> confini;
	private List <Country> stati;

	private CountryIDMap cmap;
	
	private SimpleGraph<Country, DefaultEdge> grafo;
	
	public Model() {		

		bdao = new BordersDAO();
	
	}

	public void calcoloConfini(int year) {
		
		cmap = new CountryIDMap();
		
		countries = bdao.loadAllCountries(cmap);
		
	//	borders = bdao.getCountryPairs(year, cmap);
		
		grafo = new SimpleGraph<>(DefaultEdge.class);
		
		stati  = bdao.getCountryByYear(year);
		
		Graphs.addAllVertices(grafo,stati );
		
		for (Country c : grafo.vertexSet()) {
			
			confini = bdao.getEdge(year, c);
			
			for (Country co : confini)
			
			grafo.addEdge(c, co);
				
		}	
		
		System.out.format("Inseriti: %d vertici, %d archi\n", grafo.vertexSet().size(), grafo.edgeSet().size());
	}

	public List<Vicino> numeroVicini() {
		
		 List <Vicino> vicini = new ArrayList<> ();
					
		for (Country c : grafo.vertexSet()) { 

			
			Vicino v  = new Vicino (c,Graphs.neighborListOf(grafo, c).size());
			
			vicini.add(v);
		
		}
		
		Collections.sort(vicini);

		return vicini;
	
	}
	
	public int componentiConnesse() {
		
		ConnectivityInspector<Country, DefaultEdge> ci =  new ConnectivityInspector<>(grafo);
		
		return ci.connectedSets().size();

	}
	

}
