package junitTestCases.updateStudentTestpack;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import exceptionPack.EmailFormatException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;

public class UpdateStudDataTestCases {
	static int res;
	static boolean resBol;
	
	/**
	 * Scenario 3 (TS03—Priority P1) Positive scenario master serial number can be searched and records can be updated successfully.
	 */
	@Test
	public void UpdateSuccessCase() throws ClassNotFoundException, EmailFormatException, SQLException, EmptyFieldsException, NameException {
		System.out.println("-------------------SUCCESSFUL UPDATE STUDENT RECORD TEST CASE #1-----------------");
		res = UpdateStudMethodClass.updateStudMethod();
		
		if(res > 0) {
			resBol = true;
		} else {
			resBol = false;
		}
		assertTrue(resBol);
	}
	
	@Test(expected = Exception.class)
	public void UpdateFailureCase() throws ClassNotFoundException, EmailFormatException, SQLException, EmptyFieldsException, NameException {
		System.out.println("-------------------FAIL TO UPDATE STUDENT RECORD AND THROW EXCEPTION TEST CASE #2-----------------");
		UpdateStudMethodClass.updateStudMethod();
	}
}
