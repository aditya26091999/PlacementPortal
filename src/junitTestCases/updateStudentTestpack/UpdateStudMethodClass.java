package junitTestCases.updateStudentTestpack;

import java.sql.SQLException;
import java.util.Scanner;

import exceptionPack.EmailFormatException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import model.DatabaseOperations;

public class UpdateStudMethodClass {
	static String msn;
	static String fname;
	static String lname;
	static String email;
	static String branch = "Computer";
	static String college = "PCCoE";
	static Scanner sc;
	
	public static int updateStudMethod() throws ClassNotFoundException, EmailFormatException, SQLException, EmptyFieldsException, NameException {
		sc = new Scanner(System.in);
		
		System.out.print("Enter MSN of student whose data needs to be updated: ");
		msn = sc.nextLine();
		System.out.print("\nEnter Fname of student to update: ");
		fname = sc.nextLine();
		System.out.print("\nEnter Lname of student to update: ");
		lname = sc.nextLine();
		System.out.print("\nEnter Email of student to update: ");
		email = sc.nextLine();
		
		return DatabaseOperations.updateStudent(Integer.parseInt(msn), fname, lname, email, branch, college);
	}
}
