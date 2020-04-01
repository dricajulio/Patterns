package patterns;

// class that implement the interfaceCountry w/ the prototype design
public class Country {
	public String code;
	public String name;
	public String continent;
	public float surface;
	public String head;
	
	
	public Country (String code, String name, String continent, float surfaceArea, String headOfState ) {
		this.code =code;
		this.name = name;
		this.continent = continent;
		this.surface = surfaceArea;
		this.head = headOfState;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContinent () {
		return continent;
	}
	
	public void setContinent (String continent) {
		this.continent = continent;
	}
	
	public float getSurface () {
		return surface;
	}
	
	public void setSurface (float surface) {
		this.surface = surface;
	}
	
	public String getHead() {
		return head;
	}
	
	public void setHead (String head) {
		this.head = head;
	}
	
	//I had added this method here to be able to print the 
	//object without problems
	@Override
	public String toString() {
		return "CODE: " + code + ", NAME: " + name + ", CONTINENT: " + continent +", SURFACE AREA: " + surface + ", HEAD OF STATE: " + head;
	
	}
}
