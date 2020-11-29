package junitTestCases.registerNewStudTest;

import java.sql.SQLException;
import java.util.Scanner;

import exceptionPack.EmailFormatException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import model.DatabaseOperations;
import model.GeneratePasswordClass;

public class RegisterTestMethodClass {
	static Scanner sc;
	static String msn;
	static String fname;
	static String lname;
	static String email;
	static String branch = "Computer";
	static String college = "PCCoE";
	static String studPass;
	
	public static int registerTestMethod() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		sc = new Scanner(System.in);
		System.out.print("Enter student MSN: ");
		msn = sc.nextLine();
		System.out.print("\nEnter student fname: ");
		fname = sc.nextLine();
		System.out.print("\nEnter student lname: ");
		lname = sc.nextLine();
		System.out.print("\nEnter student email: ");
		email = sc.nextLine();
		
		
		return DatabaseOperations.addStudentToDatabase(msn, fname, lname, email, branch, college, GeneratePasswordClass.generatePassword(20));
	}
}
