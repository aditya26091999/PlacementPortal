package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.Main;

public class AdminDataAccessClass {
	static Connection conn;
	
	public static void createAdminTable() throws ClassNotFoundException, SQLException {
		String raw = "CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(50) NOT NULL, %s VARCHAR(50) NOT NULL)";
		String query = String.format(raw, Main.Constants.ADMIN_TABLE_NAME, Constants.ADMIN_ID, Constants.ADMIN_UNAME, Constants.ADMIN_PASSWD);
		String connURL = Main.Constants.CONNECTION_URL;
		Class.forName(Main.Constants.CLASS_FOR_NAME);
		conn = DriverManager.getConnection(connURL);
		PreparedStatement ps = conn.prepareStatement(query);
		ps.execute();
	}
	
	public static class Constants {
		public static final String ADMIN_ID = "A_ID";
		public static final String ADMIN_UNAME = "Uname";
		public static final String ADMIN_PASSWD = "Pwd";
	}
}
