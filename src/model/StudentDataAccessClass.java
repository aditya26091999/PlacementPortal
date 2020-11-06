package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.Main;

public class StudentDataAccessClass {
	static Connection conn;

	public static void createStudentTable() throws ClassNotFoundException, SQLException {
		String raw = "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY, %s VARCHAR(20) NOT NULL, %s varchar(50) NOT NULL, %s Varchar(50) NOT NULL UNIQUE, %s varchar(50) NOT NULL, %s varchar(50) NOT NULL, %s VARCHAR(50) NOT NULL UNIQUE)";
		String query = String.format(raw, Main.Constants.STUDENT_TABLE_NAME, Constants.STUD_MSN, Constants.STUD_FNAME, Constants.STUD_LNAME, Constants.STUD_EMAIL, Constants.STUD_BRANCH, Constants.STUD_COLLEGE, Constants.STUD_PASS);
		String connURL = Main.Constants.CONNECTION_URL;
		Class.forName(Main.Constants.CLASS_FOR_NAME);
		conn = DriverManager.getConnection(connURL);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.execute();
	}

	public static class Constants {
		public static final String STUD_MSN = "MSN";
		public static final String STUD_FNAME = "fname";
		public static final String STUD_LNAME = "lname";
		public static final String STUD_EMAIL = "email";
		public static final String STUD_BRANCH = "branch";
		public static final String STUD_COLLEGE = "college";
		public static final String STUD_PASS = "Passwd";
	}
}
