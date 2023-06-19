package Inheritance;

import Interface.Interface;

public abstract class Member implements Interface {

	protected String name;
	protected String surname;

	public Member() {
		this.name = "No Name";
		this.surname = "No Surname";
	}

	public Member(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public abstract double calcExaminationFee();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Name=" + name + "\nSurname=" + surname;
	}

}
