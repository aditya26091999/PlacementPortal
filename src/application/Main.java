package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.AdminDataAccessClass;
import model.DriveDataAccessClass;
import model.StudentDataAccessClass;
import model.StudentDriveDataAccessClass;
import screenPack.ScreenPackClass;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		createAllTables();
		ScreenPackClass.showLoginScreen();
	}

	private void createAllTables() throws Exception {
		StudentDataAccessClass.createStudentTable();
		DriveDataAccessClass.createDriveTable();
		AdminDataAccessClass.createAdminTable();
		StudentDriveDataAccessClass.createStudentDriveApplyTable();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static class Constants {
		public static final String ADMIN_TABLE_NAME = "Admin";
		public static final String STUDENT_TABLE_NAME = "Student";
		public static final String DRIVE_TABLE_NAME = "Drive";
		public static final String STUD_DRIVE_APPLY_TAB = "StudDriveTab";
		public static final String CONNECTION_URL = "jdbc:sqlite:tnpPortal.db";
		public static final String CLASS_FOR_NAME = "org.sqlite.JDBC";
	}
}
