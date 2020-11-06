package controller;

import java.net.URL;
import java.util.ResourceBundle;

import alertBoxPack.AlertBoxClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;
import model.DataEntryValidation;
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
	void updateRecord(ActionEvent event) {
		boolean updateStudToDB;
		try {
			boolean isFieldEmpty = DataEntryValidation.checkEmptyFields(firstName.getText(), lastName.getText(),
					emailAddress.getText(), studentBranch.getValue().toString(), studentCollege.getValue().toString());

			if (isFieldEmpty) {
				AlertBoxClass.Amber("Missing Fields", "You left some fields empty!");
			} else {
				if (!DataEntryValidation.checkEmailRegex(emailAddress.getText())) {
					AlertBoxClass.ErrBox("ERROR", "Enter a Valid Email address!");
				} else {
					updateStudToDB = DatabaseOperations.updateStudent(AdminDashBoardFXMLController.msn,
							firstName.getText(), lastName.getText(), emailAddress.getText(), studentBranch.getValue(),
							studentCollege.getValue());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			AlertBoxClass.Amber("Missing Option", "Please select a dept AND College");
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
