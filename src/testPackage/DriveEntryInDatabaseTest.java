package testPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriveEntryInDatabaseTest {
	static boolean result = false;
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Before
	public void getResult() {
		LogOutAndDriveEntryTestClass log = new LogOutAndDriveEntryTestClass();
		result = log.getLogOut();
	}
	
	@Test
	public void TestDriveToDatabase() {
		assertTrue("Drive addition to database failed!", result);
	}
}
