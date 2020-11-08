package adityaTestPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.DatabaseOperations;

public class AdminTestCases {
	
	@Test
	public void successAdminLogin() {
		
		//giving the correct credentials for the admin-login database function
		boolean current_status_code = DatabaseOperations.checkLoginCred("admin", "admin");
		assertEquals("Admin Login Successful", true, current_status_code);
	}
	
	@Test
	public void failAdminLogin() {
		
		//giving the incorrect credentials for the admin-login database function
		boolean current_status_code = DatabaseOperations.checkLoginCred("admin","wrong-password");
		assertEquals("Admin Login Un-successful", true, current_status_code);
	}
	

	
	
}
