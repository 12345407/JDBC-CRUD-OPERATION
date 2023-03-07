package com.jdbc.model;

public class employee {
	private int employeeId;
	private String employeename;
	private String employeeAddress;
	private double empoyeeSalary;
	
	
	public employee(String employeename, String employeeAddress, double empoyeeSalary) {
		super();
		this.employeename = employeename;
		this.employeeAddress = employeeAddress;
		this.empoyeeSalary = empoyeeSalary;
	}
	
	
	public employee(int employeeId, String employeename, String employeeAddress, double empoyeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeename = employeename;
		this.employeeAddress = employeeAddress;
		this.empoyeeSalary = empoyeeSalary;
	}


	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public double getEmpoyeeSalary() {
		return empoyeeSalary;
	}
	public void setEmpoyeeSalary(double empoyeeSalary) {
		this.empoyeeSalary = empoyeeSalary;
	}
	
	
	
	
}
