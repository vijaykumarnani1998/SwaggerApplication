package com.vijay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.exception.EmployeeNotFoundException;
import com.vijay.model.Employee;
import com.vijay.repo.EmployeeRepository;
import com.vijay.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public Integer saveEmployee(Employee employee) {
		Employee e=empRepo.save(employee);
		return e.getEmpId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list=empRepo.findAll();
		return list;
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Employee employee=empRepo.findById(id).orElseThrow(()->
		new EmployeeNotFoundException("Employee '"+id+"' Not Exists"));
		return employee;
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee employee=getOneEmployee(id);
		empRepo.delete(employee);
		
		 // 1. empRepo.deleteById(id);
		
		// 2.  empRepo.delete(getOneEmployee(id));
		

	}

	@Override
	public void updateEmployee(Employee employee) {
		
		if(employee.getEmpId()!=null)
		{
			empRepo.save(employee);
	}

	}
}
