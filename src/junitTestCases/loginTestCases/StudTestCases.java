package junitTestCases.loginTestCases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import exceptionPack.EmptyFieldsException;

public class StudTestCases {
	/**
	 * Scenario 2 (TS02—Priority P1) Negative scenario where login fails
	 */
	@Test(expected = EmptyFieldsException.class)
	public void TestLoginPage()
			throws ClassNotFoundException, NullPointerException, SQLException, EmptyFieldsException {
		LoginTestMethodClass.testLoginStud();
	}

	/**
	 * Scenario 2 (TS02—Priority P1) Negative scenario where login fails
	 */
	@Test
	public void TestLoginFailure() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		boolean test = LoginTestMethodClass.testLoginStudFail();
		assertFalse(test);
	}
	
	/**
	 * Scenario 1 (TS01—Priority P1) Positive scenario where user is logged into the system according to his/her privilege.
	 */
	@Test
	public void TestLoginSuccess() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		boolean test = LoginTestMethodClass.testLoginStudSuccess();
		System.out.println(test);
		assertTrue(test);
	}
}
