package com.poc.models;

public class User {
	
	private String name;
	private String address;
	
	public User() {}
	
	public User(String name,String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Name: ");
		sb.append(getName());
		sb.append(" Address: ");
		sb.append(getAddress());
		return sb.toString();
	}
	
}
