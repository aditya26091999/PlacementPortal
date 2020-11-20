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

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;
import model.DatabaseOperations;
import screenPack.ScreenPackClass;

public class UpdateStudRecFXMLController implements Initializable {
	@FXML
	private AnchorPane updateRootPane;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField emailAddress;
	@FXML
	private ComboBox<String> studentBranch;
	@FXML
	private ComboBox<String> studentCollege;
	@FXML
	private Button updateStudRecord;
	@FXML
	private Button backToDash;
	ObservableList<String> collegeName = FXCollections.observableArrayList("PCCoE", "PCCoER", "NMIT");
	ObservableList<String> branchName = FXCollections.observableArrayList("Computer", "IT", "ENTC", "Civil",
			"Mechanical");

	@FXML
	void showDashBoard(ActionEvent event) throws Exception {
		ScreenPackClass.showAdminDashScreen(updateRootPane);
	}

	@FXML
	void updateRecord(ActionEvent event) throws ClassNotFoundException, SQLException, NameException {
		String fname = firstName.getText();
		String lname = lastName.getText();
		String email = emailAddress.getText();
		String branch = studentBranch.getValue().toString();
		String college = studentCollege.getValue().toString();
		int msn = AdminDashBoardFXMLController.msn;
		try {
			int i = DatabaseOperations.updateStudent(msn, fname, lname, email, branch, college);
			if (i > 0)
				AlertBoxClass.Notify("SUCCESS", "Student record updated!");
		} catch (EmptyFieldsException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "You left some fields empty!");
		} catch (EmailFormatException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "Invalid Email!");
		} catch (NameException e) {
			e.printStackTrace();
			AlertBoxClass.ErrBox("ERROR", "Invalid First name or Last name!");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		studentBranch.setItems(branchName);
		studentCollege.setItems(collegeName);

		firstName.setText(AdminDashBoardFXMLController.fname);
		lastName.setText(AdminDashBoardFXMLController.lname);
		emailAddress.setText(AdminDashBoardFXMLController.email);
		studentBranch.setValue(AdminDashBoardFXMLController.branch);
		studentCollege.setValue(AdminDashBoardFXMLController.college);
	}
}
