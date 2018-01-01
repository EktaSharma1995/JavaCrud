package com.ekta.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ekta.bean.Employee;
import com.ekta.constants.Constants;
import com.ekta.dao.IEmployeeDAO;
import com.ekta.impl.InMemoryCRUDImpl;

/**
 * All user input will be taken here
 * 
 * @author ektasharma
 *
 */
public class AppLauncher {

	private static void printInitialMenu() {
		System.out.println("***************** Choices *****************");
		System.out.println("c. Create a record");
		System.out.println("r. Retrieve a record");
		System.out.println("ra. Retrieve all records");
		System.out.println("u. Update a record");
		System.out.println("d. Delete a record");

		System.out.println("q. Exit");
		System.out.print("Enter your choice -> ");
	}
	
	private static boolean isChoiceCreate(String choice) {
		return choice.matches(Constants.CREATE_REG_EXP);
	}
	
	private static boolean isChoiceRetrieve(String choice) {
		return choice.matches(Constants.RETRIEVE_REG_EXP);
	}
	
	private static boolean isChoiceRetrieveAll(String choice) {
		return choice.matches(Constants.RETRIEVE_ALL_REG_EXP);
	}
	
	private static boolean isChoiceUpdate(String choice) {
		return choice.matches(Constants.UPDATE_REG_EXP);
	} 
	
	private static boolean isChoiceDelete(String choice) {
		return choice.matches(Constants.DELETE_REG_EXP);
	}
	
	public static void main(String[] args) {
		
		Scanner keyBoard = new Scanner(System.in);
		IEmployeeDAO inMemoryCrudImpl = new InMemoryCRUDImpl();   //Object of interface class to access methods defined in inMemoryrudImp class. 
		Employee emp = null;
		String choice = null;
		for (;;) {
			printInitialMenu();
			choice = keyBoard.next();

			if (isChoiceCreate(choice)) {   // string comparison is by equals or equalsIgnoreCase.
				emp = new Employee();
				System.out.println("You want to create a employee record.");

				System.out.println("What is the id of the employee you want to create?");
				int id = keyBoard.nextInt();

				System.out.println("What is the first name of the employee you want to create?");
				String firstName = keyBoard.next();

				System.out.println("What is the last name of the employee you want to create?");
				String lastName = keyBoard.next();

				System.out.println("What is the gender of the employee you want to create?");
				String gender = keyBoard.next();

				System.out.println("What is the birth date of the employee you want to create?");
				String dateOfBirth = keyBoard.next();

				System.out.println("What is the SIN of the employee you want to create?");
				int sin = keyBoard.nextInt();
				
				System.out.println("What is the address of the employee you want to create?");
				String address = keyBoard.next();
				
				System.out.println("What is the phone number the employee you want to create?");
				String phoneNumber = keyBoard.nextLine();

				emp.setId(id);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setGender(gender);
				emp.setDateOfBirth(dateOfBirth);
				emp.setSin(sin);
				emp.setAddress(address);
				emp.setPhoneNumber(phoneNumber);

				inMemoryCrudImpl.create(emp);    //Passing emp object of class Employee for creating a record, values asked from the user.

				System.out.println(emp.toString());

			} else if (isChoiceRetrieve(choice)) {
				emp = new Employee();
				System.out.println("You want to retrieve a employee record.");

				System.out.println("What is the ID of the employee you want to retrieve?");
				int idForReference = keyBoard.nextInt();

				emp.setId(idForReference);

				 Employee empl = inMemoryCrudImpl.retrieve(emp);   // Setting value of id in the emp object corresponding to the record which we want to retrieve.
				 
				 if (empl != null) {
					 System.out.println(empl.toString());
				 }
				 
				 else {
					 System.out.println("Empty");
				 }
				

			} else if (isChoiceRetrieveAll(choice)) {
				emp = new Employee();

				System.out.println("You want to retrieve all the records.");

				List<Employee> employeeDbForLauncher = new ArrayList<Employee>();  //Arraylist of type Employee with the name employeeDbForLauncher.

				employeeDbForLauncher = inMemoryCrudImpl.retrieveAll();  //Arraylist which will store all the values of retrieved data here in AppLauncher class.

				if (employeeDbForLauncher.isEmpty()) {
					System.out.println("Employee DB is empty");
				}

				for (Employee empl : employeeDbForLauncher) {  //Enhanced for loop. 
					System.out.println(empl);      // Printing each record retrieved using retrieveAll() method stored in object empl. 
				}
			} else if (isChoiceUpdate(choice)){
				emp = new Employee();

				System.out.println("You want to update a employee record.");

				System.out.println("Enter the id to get updated:");
				int employeeId = keyBoard.nextInt();
				emp.setId(employeeId);

				System.out.println("What field you want to update?");
				String fieldToBeUpdated = keyBoard.next();

				if (fieldToBeUpdated.equalsIgnoreCase(Constants.FIRST_NAME)) {

					System.out.println("Enter the first name?");
					String firstNameAfterUpdation = keyBoard.next();
					emp.setFirstName(firstNameAfterUpdation);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.LAST_NAME)) {

					System.out.println("Enter the last name?");
					String lastNameAfterUpdation = keyBoard.next();
					emp.setLastName(lastNameAfterUpdation);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.GENDER)) {

					System.out.println("Enter the gender?");
					String genderAfterUpdation = keyBoard.next();
					emp.setGender(genderAfterUpdation);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.DATE_OF_BIRTH)) {
					System.out.println("Enter the date Of Birth?");
					String dobAfterUpdation = keyBoard.next();
					emp.setDateOfBirth(dobAfterUpdation);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.SIN)) {
					System.out.println("Enter the SIN?");
					String sinAfterUpdation = keyBoard.next();
					emp.setDateOfBirth(sinAfterUpdation);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.PHONE_NUMBER)) {
					System.out.println("Enter the Phone number?");
					String phoneNumberAfterUpdation = keyBoard.next();
					emp.setPhoneNumber(phoneNumberAfterUpdation);

				} else if (fieldToBeUpdated.equalsIgnoreCase(Constants.ADDRESS)) {
					System.out.println("Enter the Address?");
					String addressAfterUpdation = keyBoard.next();
					emp.setAddress(addressAfterUpdation);
			   }

				inMemoryCrudImpl.update(emp, fieldToBeUpdated);    // DP: Programming to interface

			} else if (isChoiceDelete(choice)) {
				emp = new Employee();

				System.out.println("You want to delete a employee record.");

				System.out.println("What is the ID of the employee you want to delete?");
				int idForReference = keyBoard.nextInt();

				emp.setId(idForReference);

				inMemoryCrudImpl.delete(emp);

			} else {
				break;

			}
		}

	}

}
