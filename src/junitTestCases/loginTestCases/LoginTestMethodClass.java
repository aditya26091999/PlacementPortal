package junitTestCases.loginTestCases;

import java.sql.SQLException;
import java.util.Scanner;

import exceptionPack.EmptyFieldsException;
import model.DatabaseOperations;

public class LoginTestMethodClass {
	static Scanner sc;
	static String uname;
	static String pwd;
	static String msn;

	public static void testLoginAdmin() throws ClassNotFoundException, SQLException, EmptyFieldsException {
//		sc = new Scanner(System.in);
		System.out.println("-------------------EMPTY FIELDS TEST CASE #1-----------------");
		uname = "";
		pwd = "";
		DatabaseOperations.checkLoginCred(uname, pwd);
	}

	public static boolean testLoginAdminSuccess() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		System.out.println("-------------------VALID FIELDS TEST CASE #2-----------------");
		sc = new Scanner(System.in);
		System.out.print("Enter Admin uname: ");
		uname = sc.nextLine();
		System.out.print("\nEnter Admin password: ");
		pwd = sc.nextLine();

		return DatabaseOperations.checkLoginCred(uname, pwd);
	}

	public static boolean testLoginAdminFailure() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		System.out.println("-------------------INVALID FIELDS TEST CASE #3-----------------");
		sc = new Scanner(System.in);
		System.out.print("Enter Admin uname: ");
		uname = sc.nextLine();
		System.out.print("\nEnter Admin password: ");
		pwd = sc.nextLine();

		return DatabaseOperations.checkLoginCred(uname, pwd);
	}

	public static void testLoginStud() throws ClassNotFoundException, SQLException, EmptyFieldsException, NullPointerException {
		System.out.println("-------------------STUDENT LOGIN EMPTY FIELDS TEST CASE #1-----------------");
		msn = "";
		pwd = "";
		DatabaseOperations.checkLoginCred(msn, pwd);
	}

	public static boolean testLoginStudSuccess()
			throws ClassNotFoundException, SQLException, EmptyFieldsException {
		System.out.println("-------------------VALID FIELDS TEST CASE #2-----------------");
		sc = new Scanner(System.in);
		System.out.print("Enter Student msn: ");
		msn = sc.nextLine();
		System.out.print("Enter Student Password: ");
		pwd = sc.nextLine();

		return DatabaseOperations.checkStudLoginCred(msn, pwd);
	}

	public static boolean testLoginStudFail() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		System.out.println("-------------------INVALID FIELDS TEST CASE #3-----------------");
		sc = new Scanner(System.in);
		System.out.print("Enter Student msn: ");
		msn = sc.nextLine();
		System.out.print("Enter Student Password: ");
		pwd = sc.nextLine();

		return DatabaseOperations.checkStudLoginCred(msn, pwd);
	}
}
