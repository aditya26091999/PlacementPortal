package junitTestCases.driveOperationsTestPack;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.prefs.BackingStoreException;

import org.junit.Test;

import exceptionPack.BackLogOutOfBoundsException;
import exceptionPack.CtcOutOfBoundsException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import exceptionPack.PercentageOutOfBoundsException;

public class DriveTestCases {
	static int res;
	static boolean resBol;
	
	/**
	 * Scenario 4 (TS04—Priority P1) Positive scenario drives that are to be conducted are successfully added to the database.
	 */
	@Test
	public void AddDriveSuccess() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------SUCCESSFUL ADD DRIVE TEST CASE #1-----------------");
		res = AddDriveMethodClass.addDriveMethod();
//		System.out.println("Operation returned: "+AddDriveMethodClass.addDriveMethod());
		if(res > 0) {
			resBol = true;
			System.out.println("Added to database!");
		} else {
			resBol = false;
		}
		assertTrue(resBol);
	}
	
	/**
	 * Scenario 5 (TS05—Priority P1) Negative scenario where drives that are to be conducted are successfully added to the database but database is not updated.
	 */
	@Test(expected = PercentageOutOfBoundsException.class)
	public void InvalidPercentTest() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------FAILURE DRIVE TEST CASE(Invalid Percentage) #2-----------------");
		AddDriveMethodClass.addDriveMethod();
	}
	
	/**
	 * Scenario 5 (TS05—Priority P1) Negative scenario where drives that are to be conducted are successfully added to the database but database is not updated.
	 */
	@Test(expected = BackLogOutOfBoundsException.class)
	public void InvalidBacklogTest() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------FAILURE DRIVE TEST CASE(Invalid Backlog) #3-----------------");
		AddDriveMethodClass.addDriveMethod();
	}
	
	/**
	 * Scenario 5 (TS05—Priority P1) Negative scenario where drives that are to be conducted are successfully added to the database but database is not updated.
	 */
	@Test(expected = CtcOutOfBoundsException.class)
	public void InvalidCTCTest() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------FAILURE DRIVE TEST CASE(Invalid CTC) #4-----------------");
		AddDriveMethodClass.addDriveMethod();
	}
	
	/**
	 * Scenario 5 (TS05—Priority P1) Negative scenario where drives that are to be conducted are successfully added to the database but database is not updated.
	 */
	@Test(expected = NameException.class)
	public void InvalidCompanyNameTest() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------FAILURE DRIVE TEST CASE(Invalid Company Name) #5-----------------");
		AddDriveMethodClass.addDriveMethod();
	}
	
	@Test
	public void RemoveDriveTest() {
		System.out.println("-------------------REMOVE DRIVE TEST CASE #6-----------------");
		assertTrue(RemoveDriveMethodClass.RemoveDrive());
	}
}
