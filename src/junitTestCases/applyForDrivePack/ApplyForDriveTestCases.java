package junitTestCases.applyForDrivePack;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ApplyForDriveTestCases {
	
	/**
	 * Scenario 7(TS07—Priority P1) Positive scenario where students are able to apply for a drive.
	 */
	@Test
	public void ApplicationSuccessful() {
		System.out.println("-------------------SUCCESSFUL DRIVE APPLICATION TEST CASE #1-----------------");
		assertTrue(ApplyForDriveClass.applyToDriveMethod());
	}
}
