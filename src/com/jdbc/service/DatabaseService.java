package com.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.model.employee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

public class DatabaseService {
	DatabaseUtil databaseUtil = new DatabaseUtil();
	
	public void insertEmployee(employee employee) throws SQLException{
		try(Connection connection =  databaseUtil.getConnection();
				PreparedStatement prepareStatement =  connection.prepareStatement(QueryUtil.insertEmployeeQuery());
				){
			prepareStatement.setString(1, employee.getEmployeename());
			prepareStatement.setString(2, employee.getEmployeeAddress());
			prepareStatement.setDouble(3, employee.getEmpoyeeSalary());
			
			int rows = prepareStatement.executeUpdate();
			if(rows>0) System.out.println("Sucess");
			else System.out.println("failed");
		}
		
	}//End of Insert Employee()
	
	private void printEmployee(employee employee) {
		System.out.println("Employee id:"+ employee.getEmployeeId());
		System.out.println("Employee name:"+ employee.getEmployeename());
		System.out.println("Employee address:"+ employee.getEmployeeAddress());
		System.out.println("Employee salary:"+ employee.getEmpoyeeSalary());
		System.out.println("----------------------------");
	}
	
	public void getAllEmployees() throws SQLException {
		try(Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllQuery());
				){
			while(resultSet.next()) {
				printEmployee(new employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4)));
			}
		}
	}// End of getAllEmployees()
	
	public boolean getEmployeeById(int id) throws SQLException {
		boolean isFound = false;
		try(Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet  = statement.executeQuery(QueryUtil.getEmployeeById(id));
				){
			if(resultSet.next()) {
				isFound = true;
				printEmployee(new employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4)));
			}
			else System.out.println("Data not Found");
		}
		return isFound;
	}// End getEmployeeById()
	
	public boolean deleyeEmployee(int id) throws SQLException {
		boolean isDeleted = false;
		try(Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryUtil.getEmployeeById(id));
				){
			if(resultSet.next()) {
				int row = statement.executeUpdate(QueryUtil.deleteEmployee(id));
				if(row>0) {
					isDeleted = true;
					System.out.println("Record Deleted Successfully!");
				}
				
				else System.out.println("Something went wrong");
			}
			else System.out.println("Record not found!");
			
		}
		return isDeleted;
	} //End of deleteEmployee()
	
	public void updateEmployee(employee employee) throws SQLException {
		try(Connection connection = databaseUtil.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(QueryUtil.updateEmployee(employee.getEmployeeId()));
				){
			prepareStatement.setString(1, employee.getEmployeename());
			prepareStatement.setString(2, employee.getEmployeeAddress());
			prepareStatement.setDouble(3, employee.getEmpoyeeSalary());
			
			int row = prepareStatement.executeUpdate();
			if(row > 0) System.out.println("Data updated successfully!");
			else System.out.println("Something went wrong");
		}
	}//End of updateEmployee()
	
	
	

	
}
