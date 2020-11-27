package junitTestCases;
import java.sql.SQLException;
import java.util.Scanner;

import exceptionPack.EmptyFieldsException;
import model.DatabaseOperations;

public class LoginTestMethodClass {
	static Scanner sc;
	static String uname;
	static String pwd;
	public static void testLogin() throws ClassNotFoundException, SQLException, EmptyFieldsException {
//		sc = new Scanner(System.in);
		System.out.println("-------------------EMPTY FIELDS TEST CASE #1-----------------");
		uname = "";
		pwd = "";
		DatabaseOperations.checkLoginCred(uname, pwd);
	}
	
	public static boolean testLoginSuccess() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		System.out.println("-------------------VALID FIELDS TEST CASE #2-----------------");
		sc = new Scanner(System.in);
		System.out.print("Enter Admin uname: ");
		uname = sc.nextLine();
		System.out.print("\nEnter Admin password: ");
		pwd = sc.nextLine();
		
		return DatabaseOperations.checkLoginCred(uname, pwd);
	}
	
	public static boolean testLoginFailure() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		System.out.println("-------------------INVALID FIELDS TEST CASE #3-----------------");
		sc = new Scanner(System.in);
		System.out.print("Enter Admin uname: ");
		uname = sc.nextLine();
		System.out.print("\nEnter Admin password: ");
		pwd = sc.nextLine();
		
		return DatabaseOperations.checkLoginCred(uname, pwd);
	}
}
