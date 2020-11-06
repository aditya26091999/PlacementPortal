package screenPack;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ScreenPackClass {
	public static void showLoginScreen() throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/view/LoginPageFXML.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setTitle("TnP Portal");
		stage.setScene(scene);
		stage.show();
	}

	public static void showLoginPage(AnchorPane rootpane) throws IOException {
		Parent root = FXMLLoader.load(Main.class.getResource("/view/LoginPageFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setTitle("TnP Portal");
		stage.setScene(scene);
		stage.show();
	}

	public static void showAdminDashScreen(AnchorPane rootpane) throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/view/AdminDashBoardFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void showAddNewDriveScreen(AnchorPane rootpane) throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/view/AddNewDriveFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void showAddNewStudentScreen(AnchorPane rootpane) throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/view/AddNewStudentFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void showStudentDashBoard(AnchorPane rootpane) throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/view/StudentDashBoardFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void showGetStudDetailsScreen(AnchorPane rootpane) throws Exception {
		AnchorPane pane = FXMLLoader.load(Main.class.getResource("/view/GetStudDetailsFXML.fxml"));
		rootpane.getChildren().setAll(pane);
	}
	
	public static void showStudUpdateScreen(AnchorPane rootpane) throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/view/UpdateStudRecFXML.fxml"));
		Stage stage = (Stage) rootpane.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}
