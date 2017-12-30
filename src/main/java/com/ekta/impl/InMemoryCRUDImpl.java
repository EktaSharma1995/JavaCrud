package com.ekta.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ekta.bean.Employee;
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

//	public boolean checkElement(int id) {
//		boolean status = false;
//		int indexOfId = employeeDb.indexOf(id);
//		if (indexOfId > -1) {
//			System.out.println("In the list");
//			status = true;
//		} else {
//			System.out.println("Match not found");
//		}
//		return status;
//	}

	public void update(Employee employee, String fieldToBeUpdated) {
		
		Employee emp = this.retrieve(employee);
		
		int id = emp.getId();
		int indexOfId = employeeDb.indexOf(id);


			Employee employeeFromDB = employeeDb.get(indexOfId);

			if (fieldToBeUpdated.equals("fname")) {
				employeeFromDB.setFirstName(employee.getFirstName());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equals("lname")) {
				employeeFromDB.setLastName(employee.getLastName());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equals("dob")) {
				employeeFromDB.setDateOfBirth(employee.getDateOfBirth());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equals("gender")) {
				employeeFromDB.setGender(employee.getGender());
				System.out.print(employeeFromDB);

				} else if (fieldToBeUpdated.equals("sin")) {
				employeeFromDB.setSin(employee.getSin());
				System.out.print(employeeFromDB);
				}
			
	}

	public void delete(Employee employee) {
//		int employeeId = employee.getId();
//		int indexOfField = employeeDb.indexOf(employeeId);
		employeeDb.remove(employee);
		
	}

}
