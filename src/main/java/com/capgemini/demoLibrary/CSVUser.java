package com.capgemini.demoLibrary;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
	@CsvBindByName
	private String name;

	@CsvBindByName
	private String email;

	@CsvBindByName
	private String phno;

	@CsvBindByName
	private String country;

	public CSVUser() {

	}

	public CSVUser(String name, String email, String phno, String country) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CSVUser{name='" + name + '\'' + ", email='" + email + ", phnoeNo='" + phno + '\'' + ", country='"
				+ country + '\'' + "}";
	}
}
