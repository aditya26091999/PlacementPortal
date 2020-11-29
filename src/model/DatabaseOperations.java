package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

import application.Main;
import exceptionPack.BackLogOutOfBoundsException;
import exceptionPack.CtcOutOfBoundsException;
import exceptionPack.EmailFormatException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import exceptionPack.PercentageOutOfBoundsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseOperations {
	static boolean res = false;
	public static String getFname = "";
	public static String getLname = "";
	public static String getEmail = "";
	public static Integer getMsn = 0;
	public static boolean returnRes = false;

	public static int addDriveToDatabase(String cname, String cdate, String xthMin, String xIIthMin, String BEMin,
			String deadBack, String liveBack, String branch, String ctc) throws EmptyFieldsException,
			NumberFormatException, SQLException, ClassNotFoundException, PercentageOutOfBoundsException,
			BackingStoreException, CtcOutOfBoundsException, BackLogOutOfBoundsException, NameException {
		int i = 0;
		if (DataEntryValidation.checkEmptyFields(cname, cdate, xthMin, xIIthMin, BEMin, deadBack, liveBack, ctc)) {
			throw new EmptyFieldsException("User left some fields empty!");
		} else if (DataEntryValidation.checkpercFields(Integer.parseInt(xthMin), Integer.parseInt(xIIthMin),
				Integer.parseInt(BEMin))) {
			throw new PercentageOutOfBoundsException("Invalid percentage value");
		} else if (DataEntryValidation.checkBacklogField(Integer.parseInt(deadBack), Integer.parseInt(liveBack))) {
			throw new BackLogOutOfBoundsException("Invalid Live OR Dead backlog entries");
		} else if (DataEntryValidation.checkCtcField(Float.parseFloat(ctc))) {
			throw new CtcOutOfBoundsException("Invalid CTC value");
		} else if (DataEntryValidation.checkCompName(cname)) {
			throw new NameException("Invalid Company name");
		} else {
			String query = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			query = String.format(query, Main.Constants.DRIVE_TABLE_NAME, DriveDataAccessClass.Constants.COMP_NAME,
					DriveDataAccessClass.Constants.COMP_DATE, DriveDataAccessClass.Constants.COMP_X_MIN,
					DriveDataAccessClass.Constants.COMP_XII_MIN, DriveDataAccessClass.Constants.COMP_BE_MIN,
					DriveDataAccessClass.Constants.COMP_MAX_DEAD_BACK,
					DriveDataAccessClass.Constants.COMP_MAX_LIVE_BACK, DriveDataAccessClass.Constants.COMP_BRANCH,
					DriveDataAccessClass.Constants.COMP_CTC);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cname);
			ps.setString(2, cdate);
			ps.setInt(3, Integer.parseInt(xthMin));
			ps.setInt(4, Integer.parseInt(xIIthMin));
			ps.setInt(5, Integer.parseInt(BEMin));
			ps.setInt(6, Integer.parseInt(deadBack));
			ps.setInt(7, Integer.parseInt(liveBack));
			ps.setString(8, branch);
			ps.setFloat(9, Float.parseFloat(ctc));
			i = ps.executeUpdate();

			ps.close();
			conn.close();
		}
		return i;
	}

	public static int addStudentToDatabase(String msn, String fname, String lname, String email, String branch,
			String college, String studPass)
			throws ClassNotFoundException, SQLException, EmptyFieldsException, EmailFormatException, NameException {
		int i = 0;
		if (DataEntryValidation.checkEmptyFields(fname, lname, msn, email, branch, college)) {
			throw new EmptyFieldsException("User left some fields empty");
		} else if (DataEntryValidation.checkEmailRegex(email)) {
			throw new EmailFormatException("User entered an incorrect email");
		} else if (DataEntryValidation.checkMsnLoginNumber(msn)) {
			throw new NumberFormatException();
		} else if (DataEntryValidation.checkFnameAndLname(fname, lname)) {
			throw new NameException("User entered an invalid Fname or Lname");
		} else {
			String query = "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?)";
			query = String.format(query, Main.Constants.STUDENT_TABLE_NAME, StudentDataAccessClass.Constants.STUD_MSN,
					StudentDataAccessClass.Constants.STUD_FNAME, StudentDataAccessClass.Constants.STUD_LNAME,
					StudentDataAccessClass.Constants.STUD_EMAIL, StudentDataAccessClass.Constants.STUD_BRANCH,
					StudentDataAccessClass.Constants.STUD_COLLEGE, StudentDataAccessClass.Constants.STUD_PASS);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(msn));
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, email);
			ps.setString(5, branch);
			ps.setString(6, college);
			ps.setString(7, studPass);
			i = ps.executeUpdate();

			ps.close();
			conn.close();
		}
		return i;
	}

	public static ObservableList<Drive> getCompanyDetails() {
		ObservableList<Drive> list = FXCollections.observableArrayList();
		try {
			String query = "SELECT * FROM %s";
			query = String.format(query, Main.Constants.DRIVE_TABLE_NAME);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Drive(rs.getInt(DriveDataAccessClass.Constants.COMP_ID),
						rs.getString(DriveDataAccessClass.Constants.COMP_NAME),
						rs.getString(DriveDataAccessClass.Constants.COMP_DATE),
						rs.getString(DriveDataAccessClass.Constants.COMP_X_MIN),
						rs.getString(DriveDataAccessClass.Constants.COMP_XII_MIN),
						rs.getString(DriveDataAccessClass.Constants.COMP_BE_MIN),
						rs.getString(DriveDataAccessClass.Constants.COMP_MAX_LIVE_BACK),
						rs.getString(DriveDataAccessClass.Constants.COMP_MAX_DEAD_BACK),
						rs.getString(DriveDataAccessClass.Constants.COMP_BRANCH),
						rs.getString(DriveDataAccessClass.Constants.COMP_CTC)));
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ObservableList<Student> getStudentDetails() {
		ObservableList<Student> list = FXCollections.observableArrayList();
		try {
			String query = "SELECT * FROM %s";
			query = String.format(query, Main.Constants.STUDENT_TABLE_NAME);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt(StudentDataAccessClass.Constants.STUD_MSN),
						rs.getString(StudentDataAccessClass.Constants.STUD_FNAME),
						rs.getString(StudentDataAccessClass.Constants.STUD_LNAME),
						rs.getString(StudentDataAccessClass.Constants.STUD_EMAIL),
						rs.getString(StudentDataAccessClass.Constants.STUD_BRANCH),
						rs.getString(StudentDataAccessClass.Constants.STUD_COLLEGE),
						rs.getString(StudentDataAccessClass.Constants.STUD_PASS)));
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ObservableList<Drive> getYourDriveDetails(Integer msn) {
		ObservableList<Drive> list = FXCollections.observableArrayList();
		try {
			String query = "SELECT %s, %s, %s FROM %s INNER JOIN %s WHERE %s.%s = %s.%s AND %s.%s = ?";
			query = String.format(query, DriveDataAccessClass.Constants.COMP_NAME,
					DriveDataAccessClass.Constants.COMP_DATE, DriveDataAccessClass.Constants.COMP_CTC,
					Main.Constants.DRIVE_TABLE_NAME, Main.Constants.STUD_DRIVE_APPLY_TAB,
					Main.Constants.DRIVE_TABLE_NAME, DriveDataAccessClass.Constants.COMP_ID,
					Main.Constants.STUD_DRIVE_APPLY_TAB, StudentDriveDataAccessClass.Constants.DRIVE_ID,
					Main.Constants.STUD_DRIVE_APPLY_TAB, StudentDriveDataAccessClass.Constants.STUD_ID);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, msn);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Drive(rs.getString(DriveDataAccessClass.Constants.COMP_NAME),
						rs.getString(DriveDataAccessClass.Constants.COMP_DATE),
						rs.getString(DriveDataAccessClass.Constants.COMP_CTC)));
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean removeSelectedDrive(int DriveID) {
		try {
			String query = "DELETE FROM %s WHERE %s = ?";
			query = String.format(query, Main.Constants.DRIVE_TABLE_NAME, DriveDataAccessClass.Constants.COMP_ID);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, DriveID);
			int i = ps.executeUpdate();
			if (i > 0) {
				res = true;
			} else {
				res = false;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	public static boolean removeSelectedStudent(int msn) {
		try {
			String query = "DELETE FROM %s WHERE %s = ?";
			query = String.format(query, Main.Constants.STUDENT_TABLE_NAME, StudentDataAccessClass.Constants.STUD_MSN);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, msn);
			int i = ps.executeUpdate();
			if (i > 0) {
				res = true;
			} else {
				res = false;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	public static boolean removeStudDriveDetails(Integer msn) {
		res = true;
		try {
			String query = "DELETE from %s WHERE %s = ?";
			query = String.format(query, Main.Constants.STUD_DRIVE_APPLY_TAB,
					StudentDriveDataAccessClass.Constants.STUD_ID);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, msn);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	public static boolean applyForDrive(int driveid, int studid) {
		try {
			res = true;
			String query = "INSERT INTO %s (%s, %s) VALUES (?, ?)";
			query = String.format(query, Main.Constants.STUD_DRIVE_APPLY_TAB,
					StudentDriveDataAccessClass.Constants.DRIVE_ID, StudentDriveDataAccessClass.Constants.STUD_ID);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, driveid);
			ps.setInt(2, studid);
			int i = ps.executeUpdate();

			if (i > 0) {
				res = true;

			} else
				res = false;
			ps.close();
			conn.close();
		} catch (Exception e) {

			e.printStackTrace();
			res = false;
		}
		return res;
	}

	public static boolean checkLoginCred(String uname, String pwd)
			throws ClassNotFoundException, SQLException, EmptyFieldsException {
		if (DataEntryValidation.checkLoginCred(uname, pwd)) {
			throw new EmptyFieldsException("User left login fields empty");
		} else {
			String query = "SELECT * FROM %s WHERE %s = ? and %s = ?";
			query = String.format(query, Main.Constants.ADMIN_TABLE_NAME, AdminDataAccessClass.Constants.ADMIN_UNAME,
					AdminDataAccessClass.Constants.ADMIN_PASSWD);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = true;
			} else {
				res = false;
			}
			ps.close();
			conn.close();
			rs.close();
		}

		return res;
	}

	public static boolean checkStudLoginCred(String msn, String pwd)
			throws ClassNotFoundException, SQLException, EmptyFieldsException {
		if (DataEntryValidation.checkLoginCred(msn, pwd)) {
			throw new EmptyFieldsException("User left login fields empty");
		} else if (DataEntryValidation.checkMsnLoginNumber(msn)) {
			throw new NumberFormatException();
		} else {
			String query = "SELECT * FROM %s WHERE %s = ? and %s = ?";
			query = String.format(query, Main.Constants.STUDENT_TABLE_NAME, StudentDataAccessClass.Constants.STUD_MSN,
					StudentDataAccessClass.Constants.STUD_PASS);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(msn));
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = true;
			} else {
				res = false;
			}
			ps.close();
			conn.close();
			rs.close();
		}

		return res;
	}

	public static String getFname(Integer msn) {
		String fname = "NAN";
		try {
			String query = "SELECT %s FROM %s WHERE %s = ?";
			query = String.format(query, StudentDataAccessClass.Constants.STUD_FNAME, Main.Constants.STUDENT_TABLE_NAME,
					StudentDataAccessClass.Constants.STUD_MSN);

			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, msn);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fname = rs.getString(StudentDataAccessClass.Constants.STUD_FNAME);
			} else {
				fname = "NAN";
			}
			ps.close();
			conn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fname;
	}

	public static boolean getStudDetails(Integer msn) {
		try {
			String query = "SELECT %s, %s, %s, %s FROM %s WHERE %s = ?";
			query = String.format(query, StudentDataAccessClass.Constants.STUD_MSN,
					StudentDataAccessClass.Constants.STUD_FNAME, StudentDataAccessClass.Constants.STUD_LNAME,
					StudentDataAccessClass.Constants.STUD_EMAIL, Main.Constants.STUDENT_TABLE_NAME,
					StudentDataAccessClass.Constants.STUD_MSN);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, msn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getMsn = rs.getInt(StudentDataAccessClass.Constants.STUD_MSN);
				getFname = rs.getString(StudentDataAccessClass.Constants.STUD_FNAME);
				getLname = rs.getString(StudentDataAccessClass.Constants.STUD_LNAME);
				getEmail = rs.getString(StudentDataAccessClass.Constants.STUD_EMAIL);
			}
			ps.close();
			conn.close();
			rs.close();
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	public static List<String> getStudCompNames(Integer msn) {
		List<String> compNames = new ArrayList<>();
		try {
			String query = "SELECT %s FROM %s INNER JOIN %s WHERE %s.%s = %s.%s AND %s.%s = ?";
			query = String.format(query, DriveDataAccessClass.Constants.COMP_NAME, Main.Constants.DRIVE_TABLE_NAME,
					Main.Constants.STUD_DRIVE_APPLY_TAB, Main.Constants.DRIVE_TABLE_NAME,
					DriveDataAccessClass.Constants.COMP_ID, Main.Constants.STUD_DRIVE_APPLY_TAB,
					StudentDriveDataAccessClass.Constants.DRIVE_ID, Main.Constants.STUD_DRIVE_APPLY_TAB,
					StudentDriveDataAccessClass.Constants.STUD_ID);
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, msn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				compNames.add(rs.getString(DriveDataAccessClass.Constants.COMP_NAME));
			}
			ps.close();
			conn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compNames;
	}

	public static int updateStudent(int msn, String fname, String lname, String email, String branch, String college)
			throws EmailFormatException, ClassNotFoundException, SQLException, EmptyFieldsException, NameException {
		int i = 0;
		if (DataEntryValidation.checkEmailRegex(email)) {
			throw new EmailFormatException("User entered incorrect email ID");
		} else if (DataEntryValidation.checkEmptyFields(fname, lname, email, branch, college)) {
			throw new EmptyFieldsException("User left some fields empty");
		} else if (DataEntryValidation.checkFnameAndLname(fname, lname)) {
			throw new NameException("User entered invalid Fname OR Lname");
		} else {
			String query = "UPDATE Student SET fname = ?, lname = ?, email = ?, branch = ?, college = ? WHERE msn = ?";
			String ConnURL = Main.Constants.CONNECTION_URL;
			Class.forName(Main.Constants.CLASS_FOR_NAME);
			Connection conn = DriverManager.getConnection(ConnURL);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, branch);
			ps.setString(5, college);
			ps.setInt(6, msn);
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		}
		return i;
	}
}
