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
import javafx.scene.layout.AnchorPane;
import model.DataEntryValidation;
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
	void addStudentDatabase(ActionEvent event) {
		boolean addStudToDB;
		try {
			boolean isFieldEmpty = DataEntryValidation.checkEmptyFields(firstName.getText(), lastName.getText(),
					masterSerialNum.getText(), emailAddress.getText(), studentBranch.getValue().toString(),
					studentCollege.getValue().toString());

			if (isFieldEmpty) {
				AlertBoxClass.Amber("Missing Fields", "You left some fields empty!");
			} else {
				if (!DataEntryValidation.checkEmailRegex(emailAddress.getText())) {
					AlertBoxClass.ErrBox("ERROR", "Enter a Valid Email address!");
				} else {
					addStudToDB = DatabaseOperations.addStudentToDatabase(Integer.parseInt(masterSerialNum.getText()),
							firstName.getText(), lastName.getText(), emailAddress.getText(),
							studentBranch.getValue().toString(), studentCollege.getValue().toString(),
							GeneratePasswordClass.generatePassword(20));
					if (addStudToDB) {
						System.out.println("Student database operation performed!");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			AlertBoxClass.Amber("Missing Option", "Please select a dept AND College");
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
