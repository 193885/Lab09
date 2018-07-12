package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.BorderIDMap;
import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.CountryIDMap;

public class BordersDAO {

	public List<Country> loadAllCountries(CountryIDMap cmap) {

		String sql = "SELECT ccode, StateAbb, StateNme FROM country ORDER BY StateAbb";
		List<Country> result = new ArrayList<Country>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				Country c = new Country (rs.getString("StateAbb"), rs.getInt("ccode"),  rs.getString("StateNme"));
			
				result.add(cmap.get(c));
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public List<Border> getCountryPairs(int anno,CountryIDMap cIDMAP) {
		
		String sql = "SELECT state1no, state2no, year FROM contiguity WHERE conttype = 1 and contiguity.year <= ? and state1no > state2no ";
	
		List<Border> result = new ArrayList<Border>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, anno);
			ResultSet rs = st.executeQuery();
			
			int id = 0;
			
			while (rs.next()) {
				
				Country c1  = cIDMAP.get(rs.getInt("state1no"));
				
				Country c2  = cIDMAP.get(rs.getInt("state2no"));

				Border b = new Border (id,c1,c2,rs.getInt("year"));
				
				id++;
				
				result.add(b);

			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public List<Country> getCountryByYear(int year) {
		
	
		String sql =    "select * " + 
						"from country " + 
						"where  ccode in (select state1no " + 
						"from contiguity as conf " + 
						"where conf.year <= ? " + 
						"and conttype = 1) ";
		
		List<Country> result = new ArrayList<Country>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, year);
			ResultSet rs = st.executeQuery();
				
			while (rs.next()) {
				
				Country c1  = new Country(rs.getString("StateAbb"), rs.getInt("CCode"), rs.getString("StateNme"));
		
				result.add(c1);
	
	}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}
	
	public List<Country> getEdge(int year,Country c) {
		
		
		String sql =    	"select * " + 
							"from country " + 
							"where  ccode in (select state2no " + 
							"from contiguity as conf " + 
							"where conf.year <= ? " + 
							"and state1no = ? " + 
							"and conttype = 1) ";
		
		List<Country> result = new ArrayList<Country>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, year);
			st.setInt(2, c.getCodeCoutry());
			ResultSet rs = st.executeQuery();
				
			while (rs.next()) {
				
				Country cc  = new Country(rs.getString("StateAbb"), rs.getInt("CCode"), rs.getString("StateNme"));
		
				result.add(cc);
	
	}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}
}
