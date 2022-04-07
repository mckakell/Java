package application;

import java.util.Date;

public class PetEntry {

	private Date dateRegistered;
	private int id;
	private String name;
	private String species;
	private String sex;
	
	public PetEntry(int id, String name, String species, String sex, Date dateReg) {
		this.id = id;
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.dateRegistered = dateReg;
	}
	
	@Override
	public String toString() {
		return "Pet ID: " + id + ", Pet Name: " + name + ", Pet Species: " + species + ", Pet Sex: " + sex + ", Date Registered: " + dateRegistered;
	}
}
