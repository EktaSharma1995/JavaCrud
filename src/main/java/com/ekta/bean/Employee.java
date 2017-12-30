package com.ekta.bean;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private int sin;

	
	public Employee() {
	}
	
	public Employee(int id, String firstName, String lastName, String gender, String dateOfBirth, int sin) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.sin = sin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getSin() {
		return sin;
	}

	public void setSin(int sin) {
		this.sin = sin;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", sin=" + sin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + id;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + sin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
//		if (dateOfBirth == null) {
//			if (other.dateOfBirth != null)
//				return false;
//		} else if (!dateOfBirth.equals(other.dateOfBirth))
//			return false;
		if (id != other.id)
			return false;
//		if (firstName == null) {
//			if (other.firstName != null)
//				return false;
//		} else if (!firstName.equals(other.firstName))
//			return false;
//		if (gender == null) {
//			if (other.gender != null)
//				return false;
//		} else if (!gender.equals(other.gender))
//			return false;
//		if (lastName == null) {
//			if (other.lastName != null)
//				return false;
//		} else if (!lastName.equals(other.lastName))
//			return false;
//		if (sin != other.sin)
//			return false;
		return true;
	}

}
