package junitTestCases.registerNewStudTest;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import exceptionPack.EmailFormatException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import model.DatabaseOperations;

public class StudRegisterTestCases {
	static boolean res;
	int resSet;
	@Test
	public void RegisterSuccess() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		System.out.println("-------------------SUCCESSFUL REGISTER TEST CASE #1-----------------");
		resSet = RegisterTestMethodClass.registerTestMethod();
		if(resSet > 0) {
			res = true;
			boolean ret = DatabaseOperations.removeSelectedStudent(Integer.parseInt(RegisterTestMethodClass.msn));
			System.out.println("Delete operation returned: "+ret);
		}
		else {
			res = false;
		}
		assertTrue(res);
	}
	
	@Test(expected = EmptyFieldsException.class)
	public void RegEmptyFail() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		System.out.println("-------------------FAILURE REGISTER(Empty Fields) TEST CASE #2-----------------");
		resSet = RegisterTestMethodClass.registerTestMethod();
	}
	
	@Test(expected = EmailFormatException.class)
	public void RegWrongEmailFail() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		System.out.println("-------------------FAILURE REGISTER(Wrong Email Format) TEST CASE #3-----------------");
		resSet = RegisterTestMethodClass.registerTestMethod();
	}
	
	@Test(expected = NameException.class)
	public void RegWrongFnameFail() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		System.out.println("-------------------FAILURE REGISTER(Wrong Fname) TEST CASE #4-----------------");
		resSet = RegisterTestMethodClass.registerTestMethod();
	}
	
	@Test(expected = NameException.class)
	public void RegWrongLnameFail() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		System.out.println("-------------------FAILURE REGISTER(Wrong Lname) TEST CASE #5-----------------");
		resSet = RegisterTestMethodClass.registerTestMethod();
	}
	
	@Test(expected = SQLException.class)
	public void DuplicateMSN() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		System.out.println("-------------------FAILURE REGISTER(Duplicate MSN) TEST CASE #6-----------------");
		resSet = RegisterTestMethodClass.registerTestMethod();
	}
	
	@Test(expected = SQLException.class)
	public void DuplicateEmail() throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		System.out.println("-------------------FAILURE REGISTER(Duplicate Email) TEST CASE #7-----------------");
		resSet = RegisterTestMethodClass.registerTestMethod();
	}
}
