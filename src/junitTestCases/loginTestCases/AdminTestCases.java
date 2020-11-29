package junitTestCases.loginTestCases;

import org.junit.Test;

import exceptionPack.EmptyFieldsException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

public class AdminTestCases {
//	@Test
//	public void successAdminLogin() {
//		
//		//giving the correct credentials for the admin-login database function
//		boolean current_status_code = DatabaseOperations.checkLoginCred("admin", "admin");
//		assertEquals("Admin Login Successful", true, current_status_code);
//	}
//	
//	@Test
//	public void failAdminLogin() {
//		
//		//giving the incorrect credentials for the admin-login database function
//		boolean current_status_code = DatabaseOperations.checkLoginCred("admin","wrong-password");
//		assertEquals("Admin Login Un-successful", true, current_status_code);
//	}

	@Test(expected = EmptyFieldsException.class)
	public void TestLoginPage() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		LoginTestMethodClass.testLoginAdmin();
	}

	@Test
	public void TestLoginSuccess() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		boolean test = LoginTestMethodClass.testLoginAdminSuccess();
		assertTrue(test);
	}
	
	@Test
	public void TestLoginFailure() throws ClassNotFoundException, SQLException, EmptyFieldsException {
		boolean test = LoginTestMethodClass.testLoginAdminFailure();
		assertFalse(test);
	}

}
