package junitTestCases.removeStudentTestPack;

import java.util.Scanner;

import model.DatabaseOperations;

public class RemoveStudentMethodClass {
	static Scanner sc;
	static int msn;
	
	public static boolean removeStudMethod() {
		sc = new Scanner(System.in);
		System.out.println("Enter the MSN of student to be removed: ");
		msn = sc.nextInt();
		
		return DatabaseOperations.removeSelectedStudent(msn);
	}
}
