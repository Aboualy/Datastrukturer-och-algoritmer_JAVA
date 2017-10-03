package abo.pro;
import java.util.ArrayList;

public class Path {
	public ArrayList<City> city = new ArrayList<City>();

	public Path(ArrayList<City> ci) {
		city = ci;
	}

	public ArrayList<City> getPath() {
		return city;
	}

	public void add(City c) {
		city.add(c);
	}

	public String toStringR() {
		String list = "";
		for (int i = 0; i < city.size() - 1; i++) {
			list = list + city.get(i).toString() + ",";
		}
		list = city.get(city.size() - 1).toString();
		return list;
	}
}