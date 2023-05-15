package main.java.model;

import java.util.Objects;

public class Country {
	
	private String id_country;
	private String name;
	private String time;
	
	public Country(String id_country, String name, String time) {
		super();
		this.id_country = id_country;
		this.name = name;
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, id_country, time);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		if (!sonIguales && obj != null && obj instanceof Country) {
			Country casteado = (Country)obj;
			
			sonIguales = this.name.equals(casteado.name) &&
					this.id_country.equals(casteado.id_country) &&
					this.time.equals(casteado.time);
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return String.format("ID; %s, Name; %s, Time; %s", this.id_country, this.name, this.time);
	}

	public String getid_country() {
		return id_country;
	}

	public void setid_country(String id_country) {
		this.id_country = id_country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
