package com.vijay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee_tab")
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer empId;
	private String empName;
	private Double empSalary;
	
	

}
