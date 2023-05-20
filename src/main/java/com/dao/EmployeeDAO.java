package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;
import com.resource.DBResource;

public class EmployeeDAO {
	Connection con;
	public EmployeeDAO() {
		this.con = DBResource.getDBConnection();
	}
	
	public int storeEmployee (Employee employee) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_java_db", "root", "password");
//			Connection con = DBResource.getDBConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setFloat(3, employee.getSalary());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public int updateEmployee (Employee employee) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_java_db", "root", "password");
			PreparedStatement pstmt = con.prepareStatement("update employee set salary = ? where id = ?");
			pstmt.setInt(2, employee.getId());
			pstmt.setFloat(1, employee.getSalary());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public int deleteEmployee (Employee employee) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_java_db", "root", "password");
//			Connection con = DBResource.getDBConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from employee where id = ?");
			pstmt.setInt(1, employee.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public Employee findEmployeeById (int empId) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_java_db", "root", "password");
//			Connection con = DBResource.getDBConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employee where id = ?");
			pstmt.setInt(1, empId);
			ResultSet rs =  pstmt.executeQuery();
			if (rs.next()) {
				// convert returned result set into Java object
				Employee emp = new Employee( rs.getInt(1), rs.getString(2), rs.getFloat(3));
				return emp;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<Employee> listEmployees () {
		List<Employee> listOfEmp = new ArrayList<>();
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_java_db", "root", "password");
//			Connection con = DBResource.getDBConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employee");
			ResultSet rs =  pstmt.executeQuery();
			while (rs.next()) {
				// convert returned result set into Java object
				Employee emp = new Employee( rs.getInt(1), rs.getString(2), rs.getFloat(3));
				listOfEmp.add(emp);
			}
			return listOfEmp;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	

	public String closeConnection() {
		try {
			con.close();
			return "Connection Closed";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "ERROR: Connection May Not Have Closed";
	}
}
