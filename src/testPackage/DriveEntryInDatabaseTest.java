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
		DriveAddToDB log = new DriveAddToDB();
		result = log.driveToDB();
	}
	
	@Test
	public void TestDriveToDatabase() {
		assertTrue("Drive addition to database failed!", result);
	}
}
