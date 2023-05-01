package com.vijay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.model.Employee;
import com.vijay.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		Integer id=empService.saveEmployee(employee);
		String message="Employee '"+id+"' Saved";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> list=empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable Integer id)
	{
		Employee employee=empService.getOneEmployee(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
	{
		empService.deleteEmployee(id);
		String message="Employee '"+id+"'  Deleted";
		return new ResponseEntity<String >(message,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee)
	{
	   empService.updateEmployee(employee);
		String message="Employee '"+employee.getEmpId()+"' Updated";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	
	}
	
	
	

	
}
