package controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import alertBoxPack.AlertBoxClass;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;
import model.DataEntryValidation;
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

	public static Integer msn;

	// TODO Connect admin and Student login cred with database and validate entries
	@FXML
	public void adminLoginRoutine(ActionEvent event) throws Exception {
		boolean isLoginCredValid;
		if (DataEntryValidation.checkLoginCred(adminIDTxtField.getText(), adminPassTextField.getText())) {
			AlertBoxClass.Amber("ALERT", "Username OR Password Missing!");
		} else {
			isLoginCredValid = DatabaseOperations.checkLoginCred(adminIDTxtField.getText(),
					adminPassTextField.getText());
			if (isLoginCredValid) {
				AlertBoxClass.Notify("SUCCESS", "Welcome! " + adminIDTxtField.getText());
				ScreenPackClass.showAdminDashScreen(loginRootPane);
			} else {
				AlertBoxClass.ErrBox("LOGIN FAIL", "Incorrect credentials!");
			}
		}
	}

	@FXML
	public void studLoginRoutine(ActionEvent event) throws Exception {
		boolean isLoginCredValid;
		boolean isANumber;
		if (DataEntryValidation.checkLoginCred(studIDTextField.getText(), studentPassTextField.getText())) {
			AlertBoxClass.Amber("ALERT", "Username OR Password Missing!");
		} else {
			// msn = Integer.parseInt(studIDTextField.getText());
			isANumber = DataEntryValidation.checkMsnLoginNumber(studIDTextField.getText());
			if (isANumber) {
				AlertBoxClass.Amber("ALERT", "Incorrect MSN number!");
			} else {
				msn = Integer.parseInt(studIDTextField.getText());
				isLoginCredValid = DatabaseOperations.checkLoginCred(msn, studentPassTextField.getText());
				if (isLoginCredValid) {
					AlertBoxClass.Notify("SUCCESS",
							"Welcome " + DatabaseOperations.getFname(Integer.parseInt(studIDTextField.getText())));
					ScreenPackClass.showStudentDashBoard(loginRootPane);
				} else {
					AlertBoxClass.ErrBox("ERROR", "INCORRECT Login details!");
				}
			}
		}
	}
}
