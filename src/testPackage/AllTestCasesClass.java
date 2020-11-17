package testPackage;

import java.sql.SQLException;

import model.DatabaseOperations;

public class AllTestCasesClass {
	public static boolean studReg;
	public static boolean delStudReg;
	public static boolean delDrive;
	public static boolean applyDrive;
	public static boolean addDriveToDB;

	public boolean getStudRegResult(int msn, String fname, String lname, String email, String branch, String college,
			String studPass) throws ClassNotFoundException, SQLException {
		studReg = DatabaseOperations.addStudentToDatabase(msn, fname, lname, email, branch, college, studPass);
		System.out.println(studReg);
		return studReg;
	}

	public boolean getdelStudRegResult(int msn) {
		delStudReg = DatabaseOperations.removeSelectedStudent(msn);
		return delStudReg;
	}

	public boolean getDelDriveResult(int DriveID) {
		delDrive = DatabaseOperations.removeSelectedDrive(DriveID);
		return delDrive;
	}

	public boolean studApplyForDrive(int driveid, int msn) {
		applyDrive = DatabaseOperations.applyForDrive(driveid, msn);
		return applyDrive;
	}

	public boolean getAddDriveToDBResult(String cname, String cdate, String xthMin, String xIIthMin, String BEMin,
			String deadBack, String liveBack, String branch, String ctc) {
		addDriveToDB = DatabaseOperations.addDriveToDatabase(cname, cdate, xthMin, xIIthMin, BEMin, deadBack, liveBack,
				branch, ctc);
		return addDriveToDB;
	}
}
