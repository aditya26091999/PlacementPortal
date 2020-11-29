package junitTestCases.removeStudentTestPack;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RemoveStudentTestCases {
	
	/**
	 * Scenario 6 (TS06—Priority P1) Positive scenario where students can be deleted from the database.
	 */
	@Test
	public void RemoveStudentSuccess() {
		System.out.println("-------------------SUCCESSFUL REMOVAL OF STUDENT RECORD TEST CASE #1-----------------");
		assertTrue(RemoveStudentMethodClass.removeStudMethod());
	}
}
