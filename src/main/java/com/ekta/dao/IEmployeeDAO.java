package com.ekta.dao;

import java.util.List;

import com.ekta.bean.Employee;

public interface IEmployeeDAO {

	public boolean create(Employee employee);

	public Employee retrieve(Employee employee);

	public List retrieveAll();

	public void update(Employee employee, String fieldToBeUpdated);

	public void delete(Employee employee);

}
