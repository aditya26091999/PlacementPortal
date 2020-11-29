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
	
	@Test(expected = PercentageOutOfBoundsException.class)
	public void InvalidPercentTest() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------FAILURE DRIVE TEST CASE(Invalid Percentage) #2-----------------");
		AddDriveMethodClass.addDriveMethod();
	}
	
	@Test(expected = BackLogOutOfBoundsException.class)
	public void InvalidBacklogTest() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------FAILURE DRIVE TEST CASE(Invalid Backlog) #3-----------------");
		AddDriveMethodClass.addDriveMethod();
	}
	
	@Test(expected = CtcOutOfBoundsException.class)
	public void InvalidCTCTest() throws NumberFormatException, ClassNotFoundException, EmptyFieldsException, SQLException, PercentageOutOfBoundsException, BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		System.out.println("-------------------FAILURE DRIVE TEST CASE(Invalid CTC) #4-----------------");
		AddDriveMethodClass.addDriveMethod();
	}
	
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
