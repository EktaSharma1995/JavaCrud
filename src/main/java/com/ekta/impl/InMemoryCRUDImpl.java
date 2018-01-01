package com.ekta.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ekta.bean.Employee;
import com.ekta.constants.Constants;
import com.ekta.dao.IEmployeeDAO;

public class InMemoryCRUDImpl implements IEmployeeDAO {

	public List<Employee> employeeDb = new ArrayList<Employee>();

	public boolean create(Employee employee) {
		return employeeDb.add(employee);
	}

	public Employee retrieve(Employee employee) {
		int employeeId = employee.getId();
		Employee employeeFoundInDB = null;

		for (Employee empFromDB : employeeDb) {
			if (empFromDB.getId() == employeeId) {
				employeeFoundInDB = empFromDB;
				break;
			}
		}
		
		return employeeFoundInDB;
	}

	public List retrieveAll() {
		return employeeDb;
	}

	public void update(Employee employee, String fieldToBeUpdated) {
		
		Employee employeeFromDB = this.retrieve(employee);   //For checking whether this employee object is present in db or not.
		
			if (fieldToBeUpdated.equalsIgnoreCase(Constants.FIRST_NAME)) {
				employeeFromDB.setFirstName(employee.getFirstName());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.LAST_NAME)) {
				employeeFromDB.setLastName(employee.getLastName());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.DATE_OF_BIRTH)) {
				employeeFromDB.setDateOfBirth(employee.getDateOfBirth());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.GENDER)) {
				employeeFromDB.setGender(employee.getGender());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.SIN)) {
				employeeFromDB.setSin(employee.getSin());
				System.out.print(employeeFromDB);
				
				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.PHONE_NUMBER)) {
				employeeFromDB.setPhoneNumber(employee.getPhoneNumber());
				System.out.print(employeeFromDB);
				
				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.ADDRESS)) {
				employeeFromDB.setAddress(employee.getAddress());
				System.out.print(employeeFromDB);
				} 
			}

	public void delete(Employee employee) {
		employeeDb.remove(employee);
		
	}

}
