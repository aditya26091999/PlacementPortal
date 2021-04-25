package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import alertBoxPack.AlertBoxClass;
import exceptionPack.EmptyFieldsException;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

public class LoginPageFXMLController {
	@FXML
	private AnchorPane loginRootPane;
	@FXML
	private VBox adminRootPane;
	@FXML
	private TextField adminIDTxtField;
	@FXML
	private PasswordField adminPassTextField;
	@FXML
	private Button AdminloginBtn;
	@FXML
	private VBox studentRootPane;
	@FXML
	private TextField studIDTextField;
	@FXML
	private PasswordField studentPassTextField;
	@FXML
	private Button studLoginBtn;

	public static int Intmsn;

	@FXML
	public void adminLoginRoutine(ActionEvent event) throws Exception {
		String uname = adminIDTxtField.getText();
		String pwd = adminPassTextField.getText();

		try {
			boolean login = DatabaseOperations.checkLoginCred(uname, pwd);
			if (login) {
				AlertBoxClass.Notify("SUCCESS", "Welcome! " + adminIDTxtField.getText());
				ScreenPackClass.showAdminDashScreen(loginRootPane);
			} else {
				AlertBoxClass.ErrBox("ERROR", "Incorrect login details!");
			}
		} catch (EmptyFieldsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "You left Username or Password field empty!");
		} catch (SQLException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("FATAL ERROR", "CORRUPT DATABASE");
			AlertBoxClass.Notify("INFO", "Contact your software vendor!");
		} catch (Exception e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("FATAL ERROR", "Contact software vendor!");
		}
	}

	@FXML
	public void studLoginRoutine(ActionEvent event) throws Exception {
		boolean isLoginCredValid;
		String msn = studIDTextField.getText();
		String pwd = studentPassTextField.getText();
		Intmsn = Integer.parseInt(studIDTextField.getText());
		try {
			isLoginCredValid = DatabaseOperations.checkStudLoginCred(msn, pwd);
			if (isLoginCredValid) {
				AlertBoxClass.Notify("SUCCESS",
						"Welcome " + DatabaseOperations.getFname(Integer.parseInt(studIDTextField.getText())));
				ScreenPackClass.showStudentDashBoard(loginRootPane);
			} else {
				AlertBoxClass.ErrBox("ERROR", "Incorrect login details");
			}
		} catch (EmptyFieldsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "You left Username or Password field empty!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "Master Serial Number is invalid!");
		} catch (SQLException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("FATAL ERROR", "CORRUPT DATABASE");
		} catch (Exception e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("FATAL ERROR", "CONTACT S/W VENDOR!");
		}
	}
}
