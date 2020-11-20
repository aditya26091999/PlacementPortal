package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import alertBoxPack.AlertBoxClass;
import exceptionPack.EmailFormatException;
import exceptionPack.EmptyFieldsException;
import exceptionPack.NameException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import model.GeneratePasswordClass;
import screenPack.ScreenPackClass;
import javafx.scene.control.ComboBox;

public class AddNewStudentFXMLController implements Initializable {
	@FXML
	private AnchorPane rootAddNewStudPane;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField masterSerialNum;
	@FXML
	private TextField emailAddress;
	@FXML
	private ComboBox<String> studentBranch;
	@FXML
	private ComboBox<String> studentCollege;
	@FXML
	private Button addStudentBtn;

	@FXML
	private Button cancelBtn;

	ObservableList<String> collegeName = FXCollections.observableArrayList("PCCoE", "PCCoER", "NMIT");
	ObservableList<String> branchName = FXCollections.observableArrayList("Computer", "IT", "ENTC", "Civil",
			"Mechanical");

	@FXML
	void addStudentDatabase(ActionEvent event)
			throws ClassNotFoundException, SQLException, EmptyFieldsException, NameException {
		try {
			int msn = Integer.parseInt(masterSerialNum.getText());
			String fname = firstName.getText();
			String lname = lastName.getText();
			String email = emailAddress.getText();
			String branch = studentBranch.getValue().toString();
			String college = studentCollege.getValue().toString();

			int i = DatabaseOperations.addStudentToDatabase(msn, fname, lname, email, branch, college,
					GeneratePasswordClass.generatePassword(20));
			if (i > 0) {
				AlertBoxClass.Notify("SUCCESS", "Student " + msn + " Added!");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("INCORRECT MSN", "Please enter a proper MSN!");
		} catch (EmailFormatException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("INCORRECT EMAIL", "Incorrect Email");
		} catch (EmptyFieldsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("EMPTY FILEDS", "You left some fields empty!");
		} catch (SQLException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "Email or MSN conflict!");
		} catch (NameException e) {
			AlertBoxClass.ErrBox("ERROR", "Incorrect Fname or Lname!");
		}
	}

	@FXML
	void goBackToAdminDash(ActionEvent event) throws Exception {
		ScreenPackClass.showAdminDashScreen(rootAddNewStudPane);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		studentBranch.setItems(branchName);
		studentCollege.setItems(collegeName);
	}
}
