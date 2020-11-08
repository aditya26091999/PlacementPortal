package testPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLogOutPass {
	static boolean testres;

	@Before
	public void getTestRes() {
		LogOutAndDriveEntryTestClass log = new LogOutAndDriveEntryTestClass();
		testres = log.getLogOut();
	}

	@Test
	public void LogtestPass() {
		assertTrue("Login test Failed!", testres);
	}

//	@Test
//	public void LogTestFail() {
//		assertFalse(testres);
//	}
}
