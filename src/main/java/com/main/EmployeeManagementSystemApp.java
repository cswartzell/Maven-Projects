package com.main;

import java.util.List;

import com.bean.Employee;
import com.service.EmployeeService;

public class EmployeeManagementSystemApp {
	
	public static void main (String[] args) {
		EmployeeService es = new EmployeeService();
		
		Employee emp1 = new Employee(100, "Cam", 100000);
		String result = es.storeEmployee(emp1);
		System.out.println(result);
		
//		emp1.setSalary(200000);
//		result = es.updateEmployee(emp1);
//		System.out.println(result);
//
//		result = es.deleteEmployee(emp1);
//		System.out.println(result);	
		
		Employee emp2 = new Employee(200, "Tam", 120000);
		result = es.storeEmployee(emp2);
		System.out.println(result);
		Employee emp3 = new Employee(300, "Ham", 90000);
		result = es.storeEmployee(emp3);
		System.out.println(result);
		
		result = es.findEmployeeById(100);
		System.out.println(result);
		
		List<Employee> employees = es.listEmployees();
		for (Employee emp:employees) {
			System.out.println(emp);
		}
		
		employees = es.flatBonusForAll(500);
		for (Employee emp:employees) {
			System.out.println(emp);
		}	
		
		employees = es.percentBonusForAll(0.1);
		for (Employee emp:employees) {
			System.out.println(emp);
		}	
	
		es.deleteEmployee(emp1);
		es.deleteEmployee(emp2);
		es.deleteEmployee(emp3);
	}
}
