package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.Main;

public class StudentDriveDataAccessClass {
	static Connection conn;

	public static void createStudentDriveApplyTable() throws ClassNotFoundException, SQLException {
		String raw = "CREATE TABLE IF NOT EXISTS %s (%s INTEGER, %s INTEGER, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE ON UPDATE CASCADE, UNIQUE(%s, %s))";
		String query = String.format(raw, Main.Constants.STUD_DRIVE_APPLY_TAB,
				StudentDriveDataAccessClass.Constants.DRIVE_ID, StudentDriveDataAccessClass.Constants.STUD_ID,
				StudentDriveDataAccessClass.Constants.DRIVE_ID, Main.Constants.DRIVE_TABLE_NAME,
				DriveDataAccessClass.Constants.COMP_ID, StudentDriveDataAccessClass.Constants.STUD_ID,
				Main.Constants.STUDENT_TABLE_NAME, StudentDataAccessClass.Constants.STUD_MSN,
				StudentDriveDataAccessClass.Constants.DRIVE_ID, StudentDriveDataAccessClass.Constants.STUD_ID);
		String connURL = Main.Constants.CONNECTION_URL;
		Class.forName(Main.Constants.CLASS_FOR_NAME);
		conn = DriverManager.getConnection(connURL);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.execute();
	}

	public static class Constants {
		public static final String DRIVE_ID = "DID";
		public static final String STUD_ID = "SID";
	}
}
