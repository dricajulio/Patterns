package patterns;

import java.util.ArrayList;

public class CountryDAO {
	
	public ArrayList<Country> getCountries();
	public ArrayList<Country> getCountruesByCode(String code);
	public ArrayList<Country> getCountriesByName(String name);
	public boolean saveCountry (Country country);
	

}
