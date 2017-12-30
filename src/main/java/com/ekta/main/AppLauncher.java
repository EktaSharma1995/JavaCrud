package com.ekta.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ekta.bean.Employee;
import com.ekta.dao.IEmployeeDAO;
import com.ekta.impl.InMemoryCRUDImpl;

/**
 * All user input will be taken here
 * 
 * @author ektasharma
 *
 */
public class AppLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyBoard = new Scanner(System.in);
		IEmployeeDAO inMemoryCrudImpl = new InMemoryCRUDImpl();
		Employee emp = null;
		String choice = null;
		for (;;) {
			System.out.println("***************** Choices *****************");
			System.out.println("c. Create a record");
			System.out.println("r. Retrieve a record");
			System.out.println("ra. Retrieve all records");
			System.out.println("u. Update a record");
			System.out.println("d. Delete a record");

			System.out.println("q. Exit");
			System.out.print("Enter your choice -> ");
			choice = keyBoard.next();
// string comparision is by euals or equalsIgnoreCase
			if (choice.equalsIgnoreCase("c")) {
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

				emp.setId(id);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setGender(gender);
				emp.setDateOfBirth(dateOfBirth);
				emp.setSin(sin);

				inMemoryCrudImpl.create(emp);

				System.out.println(emp.toString());

			} else if (choice.equalsIgnoreCase("r")) {
				emp = new Employee();
				System.out.println("You want to retrieve a employee record.");

				System.out.println("What is the ID of the employee you want to retrieve?");
				int idForReference = keyBoard.nextInt();

				emp.setId(idForReference);

				inMemoryCrudImpl.retrieve(emp);

				System.out.println(emp.toString());

			} else if (choice.equalsIgnoreCase("ra")) {
				emp = new Employee();

				System.out.println("You want to retrieve all the records.");

				List<Employee> employeeDbForLauncher = new ArrayList<Employee>();

				employeeDbForLauncher = inMemoryCrudImpl.retrieveAll();

				if (employeeDbForLauncher.isEmpty()) {
					System.out.println("Employee DB is empty");
				}

				for (Employee empl : employeeDbForLauncher) {
					System.out.println(empl);
				}
			} else if (choice.equalsIgnoreCase("u")){
				emp = new Employee();

				System.out.println("You want to update a employee record.");

				System.out.println("Enter the id to get updated:");
				int employeeId = keyBoard.nextInt();
				emp.setId(employeeId);

				System.out.println("What field you want to update?");
				String fieldToBeUpdated = keyBoard.next();

				if (fieldToBeUpdated.equals("fname")) {

					System.out.println("Enter the first name?");
					String firstNameAfterUpdation = keyBoard.nextLine();
					emp.setFirstName(firstNameAfterUpdation);

				} else if (fieldToBeUpdated.equals("lname")) {

					System.out.println("Enter the last name?");
					String lastNameAfterUpdation = keyBoard.nextLine();
					emp.setLastName(lastNameAfterUpdation);

				} else if (fieldToBeUpdated.equals("gender")) {

					System.out.println("Enter the gender?");
					String genderAfterUpdation = keyBoard.nextLine();
					emp.setGender(genderAfterUpdation);

				} else if (fieldToBeUpdated.equals("dateOfBirth")) {
					System.out.println("Enter the date Of Birth?");
					String dobAfterUpdation = keyBoard.nextLine();
					emp.setDateOfBirth(dobAfterUpdation);

				} else if (fieldToBeUpdated.equals("sin")) {
					System.out.println("Enter the SIN?");
					String sinAfterUpdation = keyBoard.nextLine();
					emp.setDateOfBirth(sinAfterUpdation);

				}

				// DP: Programming to interface

				inMemoryCrudImpl.update(emp, fieldToBeUpdated);

			} else if (choice.equalsIgnoreCase("d")) {
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
