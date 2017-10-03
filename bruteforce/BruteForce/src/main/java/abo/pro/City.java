package abo.pro;
public class City {
	private float latitude;
	private float longitude;
	private String city;

	public City(String city, float latitude, float longitude) {
		this.latitude = latitude;
		this.longitude= longitude;
		this.city = city;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public double Length(City other) {
		float x = other.latitude - this.latitude;
		float y = other.longitude - this.longitude;
		double length = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return length;
	}

	public String toString() {
		String City = "";
		City = City + city + ":" + latitude + "," + longitude;
		return City;
	}
}
