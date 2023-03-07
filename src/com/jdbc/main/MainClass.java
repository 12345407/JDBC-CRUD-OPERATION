package com.jdbc.main;

import java.util.Scanner;

import com.jdbc.model.employee;
import com.jdbc.service.DatabaseService;

public class MainClass {

	public static void main(String[] args) {
		DatabaseService databaseService = new DatabaseService();
		try(Scanner sc = new Scanner(System.in);) {
			boolean run = true;
			while(run) {
				System.out.println("Enter Choice:");
				System.out.println("1. Insert");
				System.out.println("2. Select All");
				System.out.println("3. Select by Id:");
				System.out.println("4. Delete Employee");
				System.out.println("5. Update Employee");
				System.out.println("6. Exit");
				
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice){
				case 1:
					System.out.println("Enter Name, Address, Salary");
					databaseService.insertEmployee(new employee(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine())));
					break;
					
				case 2:
					databaseService.getAllEmployees();
					break;
					
				case 3:
					System.out.println("Enter Id number: ");
					databaseService.getEmployeeById(Integer.parseInt(sc.nextLine()));
					break;
					
				case 4:
					System.out.println("Enter ID you wnat to Delete: ");
					databaseService.deleyeEmployee(Integer.parseInt(sc.nextLine()));
					break;
					
				case 5:
					System.out.println("Enter Employee Id: ");
					int update_id = Integer.parseInt(sc.nextLine());
					boolean is_found = databaseService.getEmployeeById(update_id);
					if(is_found) {
						System.out.println("Enter employee Name / Address / Salary: ");
						databaseService.updateEmployee(new employee(update_id, sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine())));
					}else System.out.println("Record not found");
					
					break;
				case 6:
					run = false;
					System.out.println("ThankYou!! Come back next time");
					break;
					
				default:
					break;
				
				}
			}
				
		} catch(Exception e) {
			throw new RuntimeException("Something went wrong "+e);
		}
			
	}
			
}
