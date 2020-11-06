package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.Main;

public class DriveDataAccessClass {
	static Connection conn;

	public static void createDriveTable() throws SQLException, ClassNotFoundException {
		String raw = "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(20) NOT NULL, %s varchar(20) NOT NULL, %s VARCHAR(10) NOT NULL, %s VARCHAR(10) NOT NULL, %s VARCHAR(10) NOT NULL, %s VARCHAR(10) NOT NULL, %s VARCHAR(10) NOT NULL, %s VARCHAR(50) NOT NULL, %s VARCHAR(10) NOT NULL)";
		String query = String.format(raw, Main.Constants.DRIVE_TABLE_NAME, Constants.COMP_ID, Constants.COMP_NAME,
				Constants.COMP_DATE, Constants.COMP_X_MIN, Constants.COMP_XII_MIN, Constants.COMP_BE_MIN,
				Constants.COMP_MAX_LIVE_BACK, Constants.COMP_MAX_DEAD_BACK, Constants.COMP_BRANCH, Constants.COMP_CTC);
		String connURL = Main.Constants.CONNECTION_URL;
		Class.forName(Main.Constants.CLASS_FOR_NAME);
		conn = DriverManager.getConnection(connURL);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.execute();
	}

	public static class Constants {
		public static final String COMP_ID = "DID";
		public static final String COMP_NAME = "Dname";
		public static final String COMP_DATE = "Ddate";
		public static final String COMP_X_MIN = "DXthMin";
		public static final String COMP_XII_MIN = "DXIIthMin";
		public static final String COMP_BE_MIN = "DBEMin";
		public static final String COMP_MAX_LIVE_BACK = "MaxLiveBack";
		public static final String COMP_MAX_DEAD_BACK = "MaxDeadBack";
		public static final String COMP_BRANCH = "Branch";
		public static final String COMP_CTC = "Ctc";
	}
}
