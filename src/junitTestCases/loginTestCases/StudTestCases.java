package junitTestCases.loginTestCases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import exceptionPack.EmptyFieldsException;

public class StudTestCases {
	@Test(expected = EmptyFieldsException.class)
	public void TestLoginPage() throws ClassNotFoundException, NullPointerException, SQLException, EmptyFieldsException {
		LoginTestMethodClass.testLoginStud();
	}
	
	@Test
	public void TestLoginFailure() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		boolean test = LoginTestMethodClass.testLoginStudFail();
		assertFalse(test);
	}
	
	@Test
	public void TestLoginSuccess() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		boolean test = LoginTestMethodClass.testLoginStudSuccess();
		System.out.println(test);
		assertTrue(test);
	}
}
