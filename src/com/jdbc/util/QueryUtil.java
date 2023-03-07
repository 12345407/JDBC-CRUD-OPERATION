package com.jdbc.util;

public class QueryUtil {
	public static String insertEmployeeQuery() {
		return "INSERT INTO employee (employee_name, employee_address, employee_salary) VALUES (?,?,?)";
	}
	
	public static String selectAllQuery() {
		return "SELECT * FROM employee";
	}
	public static String getEmployeeById(int id) {
		return "SELECT * FROM employee WHERE employee_id = "+id;
	}
	public static String deleteEmployee(int id) {
		return "DELETE FROM employee WHERE employee_id = "+ id;
	}
	public static String updateEmployee(int id) {
		return "UPDATE employee SET employee_name = ?, employee_address = ?, employee_salary = ? WHERE employee_id = "+id;
	}
}
