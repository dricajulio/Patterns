package patterns;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLCountryDAO implements CountryDAO {
	
	// METHOD 1: GET ALL COUNTRIES
	@Override
	public ArrayList<Country> getCountries() {
		// CREATE THE ARRAYLIST TO PUT ALL THE COUNTRIES
		// THAT ARE GOING TO BE RETURNED
		ArrayList<Country> countries = new ArrayList<Country>();
		
		// THIS IS THE METHOD IN CHARGE OF CREATE THE QUERY
		String query = "select * from country";
		
		// ACCESSING THE DATABASE
		DataSourceSingletonWritter db = new DataSourceSingletonWritter();
		
		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);
		
		// LOOP OVER THE RESULT SET
		try {
			while( rs.next() ) {
				// FOR EACH ONE OF THE VALUES, WE WANT TO
				// GET THE ATTRIBTUES
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continent = rs.getString(3);
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);
				
				countries.add(new Country(code, name, continent, surfaceArea, headOfState));	
			}
			
			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE COUNTRIES
		return countries;
	}
	@Override
	public ArrayList<Country> getCountriesByCode(String codeSearch) {
		// CREATE THE ARRAYLIST TO PUT ALL THE COUNTRIES
		// THAT ARE GOING TO BE RETURNED
		ArrayList<Country> countries = new ArrayList<Country>();
		
		// THIS IS THE METHOD IN CHARGE OF CREATE THE QUERY
		String query = "select * from country where Code =" + codeSearch;
		
		// ACCESSING THE DATABASE
		DataSourceSingletonWritter db = new DataSourceSingletonWritter();
		
		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);
		
		// LOOP OVER THE RESULT SET
		try {
			while( rs.next() ) {
				// FOR EACH ONE OF THE VALUES, WE WANT TO
				// GET THE ATTRIBTUES
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continent = rs.getString(3);
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);
				
				countries.add(new Country(code, name, continent, surfaceArea, headOfState));	
			}
			
			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE COUNTRIES
		return countries;
	}

	@Override
	public ArrayList<Country> getCountriesByName(String nameSearch) {
		// CREATE THE ARRAYLIST TO PUT ALL THE COUNTRIES
		// THAT ARE GOING TO BE RETURNED
		ArrayList<Country> countries = new ArrayList<Country>();
		
		// THIS IS THE METHOD IN CHARGE OF CREATE THE QUERY
		String query = "select * from country where Code =" + nameSearch;
		
		// ACCESSING THE DATABASE
		DataSourceSingletonWritter db = new DataSourceSingletonWritter();
		
		// QUERYING THE DATABASE
		ResultSet rs = db.select(query);
		
		// LOOP OVER THE RESULT SET
		try {
			while( rs.next() ) {
				// FOR EACH ONE OF THE VALUES, WE WANT TO
				// GET THE ATTRIBTUES
				String code = rs.getString(1);
				String name = rs.getString(2);
				String continent = rs.getString(3);
				float surfaceArea = rs.getFloat(4);
				String headOfState = rs.getString(5);
				
				countries.add(new Country(code, name, continent, surfaceArea, headOfState));	
			}
			
			// CLOSING THE CONNECTION TO THE DATABASE
			db.closing();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RETURN THE ARRAYLIST WITH ALL THE COUNTRIES
		return countries;
	}
	@Override
	public boolean saveCountry(Country country) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
