package testPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder
public class SidTestCases {
	private AllTestCasesClass obj;
	private boolean res;
	@Before
	public void getAllTestCaseObj() {
		obj = new AllTestCasesClass();
	}

	@Test
	public void StudentRegTestCasePass() throws Exception {
		res = obj.getStudRegResult(104, "John", "Doe", "John_DOE@gmail.com", "Computer", "PCCoE", "Test");
		assertTrue(res);
	}

	@Test
	public void StudentRegTestCaseFail() throws Exception {
		res = obj.getStudRegResult(103, "Tim", "test", "timTest@gmail.com", null, "PCCoE", "Testtwo");
		assertTrue(res);
	}
	
	@Test
	public void DeleteStudentTestPass() throws Exception {
		res = obj.getdelStudRegResult(101);
		assertTrue(res);
	}
	
	@Test
	public void DeleteStudentTestFail() throws Exception {
		res = obj.getdelStudRegResult(101);
		assertTrue(res);
	}
	
	@Test
	public void AddDriveToDatabaseTestPass() throws Exception{
		res = obj.getAddDriveToDBResult("TestTwo", "2020-10-24", "60", "60", "60", "1", "1", "ENTC", "5.5");
		assertTrue(res);
	}
	
	@Test
	public void AddDriveToDatabaseTestFail() throws Exception{
		res = obj.getAddDriveToDBResult("Test", null, "60", "60", "60", "1", "1", "ENTC", "5.5");
		assertTrue(res);
	}
	
	@Test
	public void ApplyForDriveTestPass() throws Exception{
		res = obj.studApplyForDrive(5, 102);
		assertTrue(res);
	}
	
	@Test
	public void ApplyForDriveTestFail() throws Exception{
		res = obj.studApplyForDrive(5, 102);
		assertTrue(res);
	}
}
