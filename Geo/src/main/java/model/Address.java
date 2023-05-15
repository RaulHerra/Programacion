package main.java.model;

import java.util.Objects;

public class Address {
	
	private String address_id;
	private String description;
	private String state;
	private City city;
	private String times;

	public Address(String address_id, String description, String state, City city, String times) {
		super();
		this.address_id = address_id;
		this.description = description;
		this.state = state;
		this.city = city;
		this.times = times;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address_id, city, description, state, times);
	}



	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this == obj;
		
		if (!sonIguales && obj != null && obj instanceof Address) {
			Address casteado = (Address)obj;
			
			sonIguales = this.description.equals(casteado.description) &&
					this.address_id.equals(casteado.address_id) &&
					this.city.equals(casteado.city) &&
					this.state.equals(casteado.state) &&
					this.times.equals(casteado.times);
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return String.format("Description; %s, con ID; %s", this.description, this.address_id);
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
