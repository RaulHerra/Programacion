package main.java.model;

import java.util.List;
import java.util.Objects;

public class City {
	
	private String city_id;
	private String city;
	private Country country;
	private String time;
	
	
	public City(String city_id, String city, String time) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, city_id, time);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		
		if (!sonIguales && obj != null && obj instanceof City) {
			City casteado = (City)obj;
			
			sonIguales = this.city_id.equals(casteado.city_id) &&
					this.city.equals(casteado.city) &&
					this.time.equals(casteado.time);
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return String.format("ID; %s, City; %s, Time; %s", this.city_id, this.city, this.time);
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTime() {
		return time;
	}

	public void setListAddress(String time) {
		this.time = time;
	}
	
}
