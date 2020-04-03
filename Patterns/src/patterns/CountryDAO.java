package patterns;

import java.util.ArrayList;

public interface CountryDAO {
	
	public ArrayList<Country> getCountries();
	public ArrayList<Country> getCountriesByCode(String code);
	public ArrayList<Country> getCountriesByName(String name);
	public boolean saveCountry(Country country);
}
