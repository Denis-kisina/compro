package homework11.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import homework11.problem3.util.Util;

public class EmployeeInfo {
	
	/**
	 * Removes from a copy of the input list all duplicate Employees,
	 * and then returns this list.
	 * 
	 * An Employee instance is considered to be a duplicate of another Employee
	 * instance if the two instances have the same name and salary.
	 */
	public static List<Employee> removeDuplicates(List<Employee> employees) {
		List<Employee> noduplicates = new ArrayList<Employee>();
		
		for(Employee employee : employees) {
			boolean isunique = true;
			for(Employee emp : noduplicates) {
				if(employee.equals(emp)) {
					isunique = false;
					break;
				}
			}
			if(isunique)
				noduplicates.add(employee);
		}
		return noduplicates;
	}
	
	
	//DO NOT MODIFY
	/**
	 * Use the main method to test your solution
	 */
	public static void main(String[] args) {	
		List<Employee> myDupsRemoved = removeDuplicates(TestData.originalList);
		boolean dupsCorrectlyRemoved = Util.listsAreEqual(TestData.dupsRemoved, myDupsRemoved);
		System.out.println("Is answer correct? " + dupsCorrectlyRemoved);
	}
	
	

	 
}
