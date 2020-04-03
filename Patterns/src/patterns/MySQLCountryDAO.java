package patterns;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLCountryDAO implements CountryDAO {
	
	// Method 1: get all countries
	@Override
	public ArrayList<Country> getCountries() {
		//  Creating the array list to put all the countries
		// that are going to be returned
		ArrayList<Country> countries = new ArrayList<Country>();
		
		// This is the method in charge of create the query
		String query = "select * from country";
		
		// accessing the database
		DataSourceSingletonWritter db = new DataSourceSingletonWritter();
		
		// querying the database
		ResultSet rs = db.select(query);
		
		// loop over the result set
		try {
			while( rs.next() ) {
				// Getting the attributes for each of the values
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
		// Accessing the db
				DataSourceSingletonWritter db = new DataSourceSingletonWritter();
				
				// From the object, getting the data
				 String code = country.getCode();
				 String name = country.getName();
				 String continent = country.getContinent();
				 float surface = country.getSurface();
				 String head = country.getHead();
				
				// Creating the query
				String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState) "
		                + "VALUES ('"+ code + "', '"+ name + "', " + " '"+ continent + "', '" + surface +"' , '"+ head +"')";
				// Request to save the data
				boolean result = db.save(query);
				
				
				//closing the db
				db.closing();
				
				return result;
			}
			
		}
